/**
 * Classes used for exposing logical structure of POJOs as Jackson
 * sees it, and exposed via
 * {@link shaded.com.fasterxml.jackson.databind.ObjectMapper#acceptJsonFormatVisitor(Class, JsonFormatVisitorWrapper)}
 * and
 * {@link shaded.com.fasterxml.jackson.databind.ObjectMapper#acceptJsonFormatVisitor(shaded.com.fasterxml.jackson.databind.JavaType, JsonFormatVisitorWrapper)}
 * methods.
 *<p>
 * The main entrypoint for code, then, is {@link shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper} and other
 * types are recursively needed during traversal.
 */
package shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;
