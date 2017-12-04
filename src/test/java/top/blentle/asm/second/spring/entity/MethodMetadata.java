package top.blentle.asm.second.spring.entity;

import java.util.Map;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/4 0004
 * @description : 方法元数据的访问
 * @since : 1.0
 */
public interface MethodMetadata {
    /**
     * Return the name of the method.
     */
    String getMethodName();

    /**
     * Return the fully-qualified name of the class that declares this method.
     */
    String getDeclaringClassName();

    /**
     * Return whether the underlying method is declared as 'static'.
     */
    boolean isStatic();

    /**
     * Return whether the underlying method is marked as 'final'.
     */
    boolean isFinal();

    /**
     * Return whether the underlying method is overridable,
     * i.e. not marked as static, final or private.
     */
    boolean isOverridable();

    /**
     * Determine whether the underlying method has an annotation or
     * meta-annotation of the given type defined.
     * @param annotationType the annotation type to look for
     * @return whether a matching annotation is defined
     */
    boolean isAnnotated(String annotationType);

    /**
     * Retrieve the attributes of the annotation of the given type,
     * if any (i.e. if defined on the underlying method, as direct
     * annotation or as meta-annotation).
     * @param annotationType the annotation type to look for
     * @return a Map of attributes, with the attribute name as key (e.g. "value")
     * and the defined attribute value as Map value. This return value will be
     * {@code null} if no matching annotation is defined.
     */
    Map<String, Object> getAnnotationAttributes(String annotationType);
}
