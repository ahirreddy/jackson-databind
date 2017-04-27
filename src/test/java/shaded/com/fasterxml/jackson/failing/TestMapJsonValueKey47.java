package shaded.com.fasterxml.jackson.failing;

import java.util.HashMap;
import java.util.Map;

import shaded.com.fasterxml.jackson.annotation.JsonCreator;
import shaded.com.fasterxml.jackson.annotation.JsonValue;
import shaded.com.fasterxml.jackson.databind.BaseMapTest;
import shaded.com.fasterxml.jackson.databind.ObjectMapper;

// [Issue#47]
public class TestMapJsonValueKey47 extends BaseMapTest
{
    public static class Wat
    {
        private final String wat;

        @JsonCreator
        Wat(String wat) {
            this.wat = wat;
        }

        @JsonValue
        public String getWat() {
            return wat;
        }

        @Override
        public String toString() {
            return "(String)[Wat: " + wat + "]";
        }
    }

    public void testMapJsonValueKey()
    throws Exception
    {
        Map<Wat, Boolean> input = new HashMap<Wat, Boolean>();
        input.put(new Wat("3"), true);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(input);
        assertEquals(aposToQuotes("{'3':'true'}"), json);
    }
}
