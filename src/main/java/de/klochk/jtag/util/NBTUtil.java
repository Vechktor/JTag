package de.klochk.jtag.util;

import de.klochk.jtag.NBTConst;
import de.klochk.jtag.tag.ITag;
import de.klochk.jtag.tag.TagEnd;

import java.util.HashMap;
import java.util.List;

/**
 * Utility class
 *
 * @author ifxandy
 */
public class NBTUtil {

    /**
     * Get type name
     * @param cls - type
     * @return name
     */
    public static String getTypeName(ITag<?> cls) throws NoSuchFieldException {

        if (cls instanceof TagEnd) {
            return "TAG_END";

        } else if (cls.getValue() instanceof Byte) {
            return "TAG_BYTE";

        } else if (cls.getValue() instanceof Short) {
            return "TAG_SHORT";

        } else if (cls.getValue() instanceof Integer) {
            return "TAG_INT";

        } else if (cls.getValue() instanceof Long) {
            return "TAG_LONG";

        } else if (cls.getValue() instanceof Float) {
            return "TAG_FLOAT";

        } else if (cls.getValue() instanceof Double) {
            return "TAG_DOUBLE";

        } else if (cls.getValue() instanceof Byte[]) {
            return "TAG_BYTE_ARRAY";

        } else if (cls.getValue() instanceof String) {
            return "TAG_STRING";

        } else if (cls.getValue() instanceof List &&
                GenericTypeResolver.resolve(cls, "value", 0)
                        .equals(ITag.class)) {
            return "TAG_LIST";

        } else if (cls.getValue() instanceof HashMap &&
                GenericTypeResolver.resolve(cls, "value", 0)
                        .equals(String.class) &&
                GenericTypeResolver.resolve(cls, "value", 1)
                        .equals(ITag.class)) {
            return "TAG_COMPOUND";

        } else if (cls.getValue() instanceof Integer[]) {
            return "TAG_INT_ARRAY";

        } else if (cls.getValue() instanceof Long[]) {
            return "TAG_LONG_ARRAY";

        }

        throw new IllegalArgumentException("Type of given tag does not match anything standard types.");

    }

    /**
     * Get type id
     * @param cls - type
     * @return id
     */
    public static int getTypeId(ITag<?> cls) throws NoSuchFieldException {

        if (cls instanceof TagEnd) {
            return NBTConst.getTypeInt();

        } else if (cls.getValue() instanceof Byte) {
            return NBTConst.getTypeByte();

        } else if (cls.getValue() instanceof Short) {
            return NBTConst.getTypeShort();

        } else if (cls.getValue() instanceof Integer) {
            return NBTConst.getTypeInt();

        } else if (cls.getValue() instanceof Long) {
            return NBTConst.getTypeLong();

        } else if (cls.getValue() instanceof Float) {
            return NBTConst.getTypeFloat();

        } else if (cls.getValue() instanceof Double) {
            return NBTConst.getTypeDouble();

        } else if (cls.getValue() instanceof Byte[]) {
            return NBTConst.getTypeByteArray();

        } else if (cls.getValue() instanceof String) {
            return NBTConst.getTypeString();

        } else if (cls.getValue() instanceof List &&
                    GenericTypeResolver.resolve(cls, "value", 0)
                    .equals(ITag.class)) {
            return NBTConst.getTypeList();

        } else if (cls.getValue() instanceof HashMap &&
                    GenericTypeResolver.resolve(cls, "value", 0)
                    .equals(String.class) &&
                    GenericTypeResolver.resolve(cls, "value", 1)
                    .equals(ITag.class)) {
            return NBTConst.getTypeCompound();

        } else if (cls.getValue() instanceof Integer[]) {
            return NBTConst.getTypeIntArray();

        } else if (cls.getValue() instanceof Long[]) {
            return NBTConst.getTypeLongArray();

        }

        throw new IllegalArgumentException("Type of given tag does not match anything standard types.");

    }

    public static Object getTypeById(int id) {

       if (id == 0) return TagEnd.class;
       if (id == 1) return Byte.class;
       if (id == 2) return Short.class;
       if (id == 3) return Integer.class;
       if (id == 4) return Long.class;
       if (id == 5) return Float.class;
       if (id == 6) return Double.class;
       if (id == 7) return Byte[].class;
       if (id == 8) return String.class;
       if (id == 9) return List.class;
       if (id == 10) return HashMap.class;
       if (id == 11) return Integer[].class;
       if (id == 12) return Long[].class;

        throw new IllegalArgumentException("Type of given tag does not match anything standard types.");

    }

}
