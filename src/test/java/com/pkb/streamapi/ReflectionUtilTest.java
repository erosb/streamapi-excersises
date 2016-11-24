package com.pkb.streamapi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.ConsoleHandler;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import org.junit.Test;

public class ReflectionUtilTest {

    private ReflectionUtil subject() {
        return new ReflectionUtil();
    }

    @Test
    public void testCollectDeclaredGetters() throws NoSuchMethodException, SecurityException {
        List<Method> actual = subject().collectDeclaredGetters(LinkedList.class);
        assertEquals(3, actual.size());
        assertTrue(actual.containsAll(asList(
                LinkedList.class.getMethod("getFirst"),
                LinkedList.class.getMethod("getLast"),
                LinkedList.class.getMethod("get", int.class))
        ));
    }

    @Test
    public void testCountMethodsWithDefaultImplementation() {
        long actual = subject().countMethodsWithDefaultImplementation(Comparator.class);
        assertEquals(7L, actual);
    }

    @Test
    public void testCollectReturnTypesOfMethods() {
        List<Class<?>> actual = subject().collectReturnTypesOfMethods(Image.class);
        assertEquals(8, actual.size());
        assertEquals(new HashSet<Class<?>>(actual).size(), actual.size());
        assertTrue(actual.containsAll(asList(
                void.class,
                float.class,
                ImageCapabilities.class,
                Graphics.class,
                int.class,
                Object.class,
                Image.class,
                ImageProducer.class
        )));
    }

    @Test
    public void testGetAverageCountOfPublicMethods() {
        double actual = subject().getAverageCountOfPublicMethods(asList(ConsoleHandler.class));
        assertEquals(2.0, actual, 0.0);
    }

    @Test
    public void testGetDefaultConstructor() throws NoSuchMethodException, SecurityException {
        Constructor<?> actual = subject().getDefaultConstructor(Object.class);
        assertEquals(actual, Object.class.getConstructor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDefaultConstructorFailure() {
        subject().getDefaultConstructor(Integer.class);
    }

    @Test
    public void testGetFirstThreeConstants() throws NoSuchFieldException, SecurityException {
        List<Field> actual = subject().getFirstThreeConstants(BufferedImage.class);
        assertEquals(asList(
                BufferedImage.class.getField("TYPE_3BYTE_BGR"),
                BufferedImage.class.getField("TYPE_4BYTE_ABGR"),
                BufferedImage.class.getField("TYPE_4BYTE_ABGR_PRE")
        ), actual);
    }

    @Test
    public void testGetLongParamList() throws NoSuchMethodException, SecurityException {
        List<Method> actual = subject().collectMethodsWithTooLongParamList(BufferedImage.class, 5);
        Method getRGB = BufferedImage.class.getMethod("getRGB", int.class, int.class, int.class, int.class,
                int[].class, int.class, int.class);
        Method setRGB = BufferedImage.class.getMethod("setRGB", int.class, int.class, int.class, int.class,
                int[].class, int.class, int.class);
        assertEquals(new ArrayList<>(asList(getRGB, setRGB)), new ArrayList<>(actual));
    }

}
