package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * <strong>TAG_INT_ARRAY</strong>
 *
 * @author ifxandy
 */
public class TagIntArray extends ITag {

    /**
     * Value
     */
    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private int[] value;

    public TagIntArray(String name, int[] array) {

        super(name);
        setValue(array);

    }

    @Override
    public String toString() {

        final StringBuilder integers = new StringBuilder();
        for (final int b : getValue()) {
            integers.append(b).append(" ");
        }
        final String name = getName();
        String append = "";
        if ((name != null) && !name.equals("")) {
            append = "(\"" + getName() + "\")";
        }
        return "TAG_Int_Array" + append + ": " + integers;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Arrays.hashCode(getValue());
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
        if (!(obj instanceof TagIntArray)) { return false; }

        TagIntArray other = (TagIntArray) obj;
        return Arrays.equals(getValue(), other.getValue());

    }

}
