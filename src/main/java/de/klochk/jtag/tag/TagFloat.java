package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * <strong>TAG_FLOAT</strong>
 *
 * @author ifxandy
 */
public class TagFloat extends ITag {

    /**
     * Value
     */
    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private float value;

    public TagFloat(String name, float value) {

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
        return "TAG_Float" + append + ": " + getValue();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Float.floatToIntBits(getValue());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) { return true; }
        if (!super.equals(obj)) { return false; }
        if (!(obj instanceof TagFloat)) { return false; }

        TagFloat other = (TagFloat) obj;
        return Float.floatToIntBits(getValue()) == Float.floatToIntBits(other.getValue());

    }

}
