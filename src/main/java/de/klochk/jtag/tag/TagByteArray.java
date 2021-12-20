package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * <strong>TAG_BYTE_ARRAY</strong>
 *
 * @author ifxandy
 */
public class TagByteArray extends ITag {

    /**
     * Value
     */
    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private byte[] value;

    public TagByteArray(String name, byte[] value) {

        super(name);
        setValue(value);

    }

    @Override
    public String toString() {

        final StringBuilder hex = new StringBuilder();
        for (final byte b : value) {
            final String hexDigits = Integer.toHexString(b).toUpperCase();
            if (hexDigits.length() == 1) {
                hex.append("0");
            }
            hex.append(hexDigits).append(" ");
        }
        final String name = getName();
        String append = "";
        if ((name != null) && !name.equals("")) {
            append = "(\"" + getName() + "\")";
        }
        return "TAG_Byte_Array" + append + ": " + hex;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {

        int prime = 31;
        int result = 1;
        result = (prime * result) + ((getName() == null) ? 0 : getName().hashCode());
        return result;

    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (!(object instanceof TagByteArray)) return false;
        if (!super.equals(object)) return false;

        TagByteArray other = (TagByteArray) object;
        return Arrays.equals(getValue(), other.getValue());

    }

}
