package de.klochk.jtag.tag;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents simple NBT Tag
 *
 * @author ifxandy
 */
@RequiredArgsConstructor
public abstract class ITag {

    @Getter
    private final String name;

    /**
     * Get Tag value
     * @return value
     */
    public Object getValue() { return null; }

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

        if (object == null) return false;
        if (!(object instanceof ITag)) return false;
        if (this == object) return true;

        ITag other = (ITag) object;
        if (getName() == null) if (other.getName() != null) return false;
        else return getName().equals(other.getName());
        
        return true;

    }

}
