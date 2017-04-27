package shaded.com.fasterxml.jackson.failing;

import shaded.com.fasterxml.jackson.annotation.JsonFormat;
import shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;

import shaded.com.fasterxml.jackson.databind.BaseMapTest;
import shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class TestPOJOAsArray extends BaseMapTest
{
    // for [JACKSON-805]
    @JsonFormat(shape=Shape.ARRAY)
    static class SingleBean {
        public String name = "foo";
    }

    
    // for [JACKSON-805]
    public void testBeanAsArrayUnwrapped() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        SingleBean result = mapper.readValue(quote("foobar"), SingleBean.class);
        assertNotNull(result);
        assertEquals("foobar", result.name);
    }

}
