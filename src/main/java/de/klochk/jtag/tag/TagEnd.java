package de.klochk.jtag.tag;

public class TagEnd extends ITag {

    public TagEnd() {
        super("");
    }

    @Override
    public Object getValue() { return null; }

    @Override
    public String toString() {

        return "TAG_End";
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result;
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
        return obj instanceof TagEnd;

    }

}
