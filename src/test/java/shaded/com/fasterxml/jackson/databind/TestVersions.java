package shaded.com.fasterxml.jackson.databind;

import shaded.com.fasterxml.jackson.core.Version;
import shaded.com.fasterxml.jackson.core.Versioned;

import shaded.com.fasterxml.jackson.databind.ObjectMapper;
import shaded.com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;

/**
 * Tests to ensure that we get proper Version information via
 * things defined as Versioned.
 */
public class TestVersions extends shaded.com.fasterxml.jackson.test.BaseTest
{
    public void testMapperVersions()
    {
        ObjectMapper mapper = new ObjectMapper();
        assertVersion(mapper);
        assertVersion(mapper.reader());
        assertVersion(mapper.writer());
        assertVersion(new JacksonAnnotationIntrospector());
    }

    /*
    /**********************************************************
    /* Helper methods
    /**********************************************************
     */
    
    private void assertVersion(Versioned vers)
    {
        Version v = vers.version();
        assertFalse("Should find version information (got "+v+")", v.isUknownVersion());
        Version exp = PackageVersion.VERSION;
        assertEquals(exp.toFullString(), v.toFullString());
        assertEquals(exp, v);
    }
}

