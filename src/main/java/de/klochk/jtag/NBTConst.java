package de.klochk.jtag;

import lombok.Getter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * NBT Constants
 *
 * @author ifxandy
 */
public class NBTConst {

    /**
     * Charset
     */
    @Getter
    private static final Charset charset = StandardCharsets.UTF_8;

    /**
     * TAG type ids.
     * Edit: Optimize memory allocation
     * using short, not just int
     *
     * Patch:
     * provide public access for switch
     */
    @Getter
    public static final short typeEnd = 0, typeByte = 1,
                                typeShort = 2, typeInt = 3,
                                typeLong = 4, typeFloat = 5,
                                typeDouble = 6, typeByteArray = 7,
                                typeString = 8, typeList = 9,
                                typeCompound = 10, typeIntArray = 11,
                                typeLongArray = 12;

}
