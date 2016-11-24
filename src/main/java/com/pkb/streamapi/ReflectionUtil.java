package com.pkb.streamapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtil {

    /**
     * Collects the getter {@link Class#getDeclaredMethods() methods declared} in {@code clazz} which' name starts with
     * {@code "get"}.
     *
     * @param clazz
     * @return
     */
    public List<Method> collectDeclaredGetters(final Class<?> clazz) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * @param clazz
     * @param treshold
     * @return the methods in {@code clazz} which' methods have longer parameter list than {@code treshold}. The
     *         returned methods should be sorted by the method names.
     */
    public List<Method> collectMethodsWithTooLongParamList(final Class<?> clazz, final int treshold) {
		throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * @param clazz
     * @return a distinct list of the return types of the methods of {@code clazz}.
     */
    public List<Class<?>> collectReturnTypesOfMethods(final Class<?> clazz) {
		throw new UnsupportedOperationException("not yet implemented");
    }

    public long countMethodsWithDefaultImplementation(final Class<?> intf) {
		throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * @param classes
     * @return the average number of public methods in {@code classes}.
     */
    public double getAverageCountOfPublicMethods(final Collection<Class<?>> classes) {
		throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * @param clazz
     * @return the default (parameterless) constructor of {@code clazz}.
     * @throws IllegalArgumentException
     *             if {@code clazz} does not have a default constructor.
     */
    public Constructor<?> getDefaultConstructor(final Class<?> clazz) {
		throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * Returns the first 3 public static final fields of {@code clazz}, sorted by their name.
     *
     * @param clazz
     */
    public List<Field> getFirstThreeConstants(final Class<?> clazz) {
		throw new UnsupportedOperationException("not yet implemented");
    }
    
}
