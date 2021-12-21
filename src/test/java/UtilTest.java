import de.klochk.jtag.NBTConst;
import de.klochk.jtag.tag.ITag;
import de.klochk.jtag.util.GenericTypeResolver;
import de.klochk.jtag.util.NBTUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Utility class tests
 *
 * @author ifxandy
 */
public class UtilTest {

    @Test
    @DisplayName("Generic Type Resolver")
    public void testGenericResolver () throws NoSuchFieldException {

        ITag<Integer> tagInt = new ITag<>("integer", 5);

        System.out.println(GenericTypeResolver.resolve(tagInt,
                "value", 0).toString());

    }

    @Test
    @DisplayName("NBTUtil")
    public void testNBTUtil () throws NoSuchFieldException {

        ITag<Integer> tagInt = new ITag<>("integer", 5);

        assert(NBTUtil.getTypeId(tagInt) == NBTConst.getTypeInt());
        assert(NBTUtil.getTypeName(tagInt).equals("TAG_INT"));
        assert(NBTUtil.getTypeById(3).equals(Integer.class));

    }

}
