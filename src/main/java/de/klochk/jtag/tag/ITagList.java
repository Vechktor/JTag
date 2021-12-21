package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;

/**
 * Abstract Tag List
 *
 * Patch:
 * Remove type and other variables,
 * Replace them with inferred type T
 *
 * @author ifxandy
 */
public class ITagList<T> extends ITag {

    /**
     * Value
     */
    @Setter(value = AccessLevel.PRIVATE)
    private List<T> value;

    public ITagList (String name, List<T> value) {

        super(name);
        setValue(value);

    }

    /**
     * Get value
     * @return value
     */
    @Override
    public List<T> getValue() { return value; }

    @Override
    public String toString() {

        final String name = getName();
        String append = "";
        if ((name != null) && !name.equals("")) {
            append = "(\"" + getName() + "\")";
        }
        final StringBuilder bldr = new StringBuilder();
        bldr.append("TAG_List").append(append).append(": ").append(getValue().size()).append(" entries ").append("\r\n{\r\n");
        for (T t : getValue()) {
            bldr.append("   ").append(t.toString().replaceAll("\r\n", "\r\n   ")).append("\r\n");
        }
        bldr.append("}");
        return bldr.toString();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((getValue() == null) ? 0 : getValue().hashCode());
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
        if (!(obj instanceof ITagList)) { return false; }

        ITagList other = (ITagList) obj;
        if (getValue() == null) {
            return other.getValue() == null;
        } else return getValue().equals(other.getValue());

    }

}
