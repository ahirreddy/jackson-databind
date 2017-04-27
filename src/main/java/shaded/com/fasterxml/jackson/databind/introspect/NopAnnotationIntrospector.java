package shaded.com.fasterxml.jackson.databind.introspect;

import shaded.com.fasterxml.jackson.core.Version;

import shaded.com.fasterxml.jackson.databind.*;

/**
 * Dummy, "no-operation" implementation of {@link AnnotationIntrospector}.
 * Can be used as is to suppress handling of annotations; or as a basis
 * for simple configuration overrides (whether based on annotations or not).
 */
public abstract class NopAnnotationIntrospector
    extends AnnotationIntrospector
    implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * Static immutable and shareable instance that can be used as
     * "null" introspector: one that never finds any annotation
     * information.
     */
    public final static NopAnnotationIntrospector instance = new NopAnnotationIntrospector() {
        private static final long serialVersionUID = 1L;

        @Override
        public Version version() {
            return shaded.com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION;
       }
    };

    @Override
    public Version version() {
        return Version.unknownVersion();
    }
}
