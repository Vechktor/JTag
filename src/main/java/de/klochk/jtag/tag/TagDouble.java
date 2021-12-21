package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class TagDouble extends ITag {

    /**
     * Value
     */
    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private double value;

    public TagDouble(String name, double value) {

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
        return "TAG_Double" + append + ": " + getValue();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getValue());
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
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
        if (!(obj instanceof TagDouble)) { return false; }
        TagDouble other = (TagDouble) obj;
        return Double.doubleToLongBits(getValue()) == Double
                .doubleToLongBits(other.getValue());
    }

}
