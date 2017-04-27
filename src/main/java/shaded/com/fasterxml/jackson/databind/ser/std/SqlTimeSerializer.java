package shaded.com.fasterxml.jackson.databind.ser.std;

import java.io.IOException;
import java.lang.reflect.Type;

import shaded.com.fasterxml.jackson.core.JsonGenerationException;
import shaded.com.fasterxml.jackson.core.JsonGenerator;
import shaded.com.fasterxml.jackson.databind.JavaType;
import shaded.com.fasterxml.jackson.databind.JsonMappingException;
import shaded.com.fasterxml.jackson.databind.JsonNode;
import shaded.com.fasterxml.jackson.databind.SerializerProvider;
import shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

@JacksonStdImpl
public class SqlTimeSerializer
    extends StdScalarSerializer<java.sql.Time>
{
    public SqlTimeSerializer() { super(java.sql.Time.class); }

    @Override
    public void serialize(java.sql.Time value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException
    {
        jgen.writeString(value.toString());
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
        JsonStringFormatVisitor v2 = (visitor == null) ? null : visitor.expectStringFormat(typeHint);
        if (v2 != null) {
            v2.format(JsonValueFormat.DATE_TIME);
        }
    }
}
