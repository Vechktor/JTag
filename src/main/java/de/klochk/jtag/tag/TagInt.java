package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * <strong>TAG_INT</strong>
 *
 * @author ifxandy
 */
public class TagInt extends ITag {

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private int value;

    public TagInt(String name, int value) {

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
        return "TAG_Int" + append + ": " + value;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + value;
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
        if (!(obj instanceof TagInt)) { return false; }

        TagInt other = (TagInt) obj;
        return getValue() == other.getValue();

    }

}
