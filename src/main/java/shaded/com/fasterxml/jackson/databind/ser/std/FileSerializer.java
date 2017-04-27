package shaded.com.fasterxml.jackson.databind.ser.std;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import shaded.com.fasterxml.jackson.core.JsonGenerationException;
import shaded.com.fasterxml.jackson.core.JsonGenerator;
import shaded.com.fasterxml.jackson.databind.JavaType;
import shaded.com.fasterxml.jackson.databind.JsonMappingException;
import shaded.com.fasterxml.jackson.databind.JsonNode;
import shaded.com.fasterxml.jackson.databind.SerializerProvider;
import shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;

/**
 * For now, File objects get serialized by just outputting
 * absolute (but not canonical) name as String value
 */
public class FileSerializer
    extends StdScalarSerializer<File>
{
    public FileSerializer() { super(File.class); }

    @Override
    public void serialize(File value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException
    {
        jgen.writeString(value.getAbsolutePath());
    }

    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
        return createSchemaNode("string", true);
    }
    
    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
            throws JsonMappingException
    {
        visitor.expectStringFormat(typeHint);
    }
}
