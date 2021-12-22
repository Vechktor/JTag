package de.klochk.jtag.stream;

import de.klochk.jtag.NBTConst;
import de.klochk.jtag.tag.ITag;
import de.klochk.jtag.tag.TagEnd;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class NBTInputStream<T extends DataInputStream> implements Closeable {

    private final T stream;

    /**
     * Read tag
     */
    public ITag<?> readTag () throws IOException {
        return readTag((short) 0);
    }

    /**
     * Read tag
     * @throws IOException TAG_END without preceding tags
     */
    public ITag<?> readTag (short depth) throws IOException {

        short type = (short) (stream.readByte() & 0xFF);

        String name;
        if (type != NBTConst.getTypeEnd()) {

            short length = (short) (stream.readUnsignedShort() & 0xFFFF);
            byte[] bytes = new byte[length];
            stream.readFully(bytes);

            name = new String(bytes, NBTConst.getCharset());

        } else name = "";

        return readTagPayload(type, name, depth);

    }

    /**
     * Read tag payload
     * @throws IOException TAG_END without preceding tags
     */
    public ITag<?> readTagPayload (short type, String name, short depth) throws IOException {

        switch (type) {

            case NBTConst.typeEnd:
                if (depth == 0) {
                    throw new IOException("TAG_END without preceding TAG_COMPOUND/TAG_LIST.");
                } else return new TagEnd();

            case NBTConst.typeByte:
                return new ITag<>(name, stream.readByte());

            case NBTConst.typeShort:
                return new ITag<>(name, stream.readShort());

            case NBTConst.typeInt:
                return new ITag<>(name, stream.readInt());

            case NBTConst.typeLong:
                return new ITag<>(name, stream.readLong());

            case NBTConst.typeFloat:
                return new ITag<>(name, stream.readFloat());

            case NBTConst.typeDouble:
                return new ITag<>(name, stream.readDouble());

            case NBTConst.typeByteArray:
                int length = stream.readInt();
                byte[] bytes = new byte[length];
                stream.readFully(bytes);
                return new ITag<>(name, bytes);

            case NBTConst.typeString:
                length = stream.readShort();
                bytes = new byte[length];
                stream.readFully(bytes);
                return new ITag<>(name, new String(bytes, NBTConst.getCharset()));

            case NBTConst.typeList:
                short childType = stream.readByte();
                length = stream.readInt();

                List<ITag<?>> tagList = new ArrayList<>();
                for (int i = 0; i < length; i++) {

                    ITag<?> tag = readTagPayload(childType, "", (short) (depth + 1));
                    if (tag instanceof TagEnd)
                        throw new IOException("Unexpected TAG_END in TAG_LIST.");
                    tagList.add(tag);

                }

                return new ITag<>(name, tagList);

            case NBTConst.typeCompound:
                Map<String, ITag<?>> tagMap = new HashMap<>();
                while (true) {
                    ITag<?> tag = readTag((short) (depth + 1));
                    if (tag instanceof TagEnd) break;

                    tagMap.put(tag.getName(), tag);
                }

                return new ITag<>(name, tagMap);

            case NBTConst.typeIntArray:
                length = stream.readInt();
                int[] ints = new int[length];
                for (int i = 0; i < length; i++) {
                    ints[i] = stream.readInt();
                }

                return new ITag<>(name, ints);

            case NBTConst.typeLongArray:
                length = stream.readInt();
                long[] longs = new long[length];
                for (int i = 0; i < length; i++) {
                    longs[i] = stream.readLong();
                }

                return new ITag<>(name, longs);

        }

        throw new IllegalArgumentException("Type of given tag does not match anything standard types.");

    }

    @Override
    public void close() throws IOException {
        stream.close();
    }

}
