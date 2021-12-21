package de.klochk.jtag.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * Resolves generic type of given object
 *
 * @author ifxandy
 */
public class GenericTypeResolver {

    /**
     * Resolve generic type
     *
     * ** Working with reflection **
     * May work not stable and produce
     * issues and exceptions!
     */
    public static Class<?> resolve (Object object,
                             String declaredName, int index) throws NoSuchFieldException {

        Field field = object.getClass().getDeclaredField(declaredName);
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();

        return (Class<?>) parameterizedType.getActualTypeArguments()[index];

    }

}
