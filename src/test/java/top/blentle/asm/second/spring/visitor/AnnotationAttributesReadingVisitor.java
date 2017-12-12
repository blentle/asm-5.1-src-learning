package top.blentle.asm.second.spring.visitor;

import top.blentle.asm.second.spring.entity.AnnotationAttributes;

import java.util.Map;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :  注释属性读取器
 * @since : 1.0
 */
public class AnnotationAttributesReadingVisitor extends AbstractRecursiveAnnotationVisitor {

    private final String annotationType;

    private final Map<String, AnnotationAttributes> attributeMap;

    private final Map<String,Set<String>> metaAnnotationMap;

    public AnnotationAttributesReadingVisitor(ClassLoader classLoader,String annotationType, Map<String, AnnotationAttributes> attributeMap, Map<String, Set<String>> metaAnnotationMap) {
        super(classLoader,new AnnotationAttributes());
        this.annotationType = annotationType;
        this.attributeMap = attributeMap;
        this.metaAnnotationMap = metaAnnotationMap;
    }
}
