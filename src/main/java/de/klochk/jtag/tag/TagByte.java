package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Setter;

/**
 * <strong>TAG_BYTE</strong>
 *
 * @author ifxandy
 */
public class TagByte extends ITag {

    /**
     * Value
     */
    @Setter(value = AccessLevel.PRIVATE)
    private byte value;

    /**
     * Get value
     * @return value
     */
    @Override
    public Byte getValue() { return value; }

    public TagByte(String name, byte value) {

        super(name);
        setValue(value);

    }

    @Override
    public String toString() {

        final String name = getName();
        String append = "";
        if ((name != null) && !name.equals("")) {
            append = "(\"" + getName() + "\")";
        }
        return "TAG_Byte" + append + ": " + getValue();

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
        if (!(object instanceof TagByte)) return false;
        if (!super.equals(object)) return false;

        TagByte other = (TagByte) object;
        return getValue().equals(other.getValue());

    }

}
