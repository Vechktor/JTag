package de.klochk.jtag.tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents simple NBT Tag
 *
 * Patch:
 * Remove all not-needed classes
 * and extenders, use type inference
 * and diamond operator
 *
 * @author ifxandy
 */
@RequiredArgsConstructor
public class ITag<T> {

    @Getter
    private final String name;

    /**
     * Value
     */
    @Getter
    private final T value;

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
        if (getValue() == null) if (other.getValue() != null) return false;
        else return getValue().equals(other.getValue());
        
        return true;

    }

}
