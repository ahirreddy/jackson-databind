package shaded.com.fasterxml.jackson.failing;

import java.util.*;

import shaded.com.fasterxml.jackson.databind.JavaType;
import shaded.com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Failing test related to [Issue#76]
 */
public class TestJavaType76
    extends shaded.com.fasterxml.jackson.test.BaseTest
{
    @SuppressWarnings("serial")
    static class HashTree<K, V> extends HashMap<K, HashTree<K, V>> { }

    public void testRecursiveType()
    {
        TypeFactory tf = TypeFactory.defaultInstance();
        JavaType type = tf.constructType(HashTree.class);
        assertNotNull(type);
    }
}

