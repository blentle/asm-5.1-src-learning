package top.blentle.asm.second.spring.visitor;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import top.blentle.asm.second.spring.entity.AnnotationAttributes;
import top.blentle.asm.second.spring.entity.AnnotationMetadata;
import top.blentle.asm.second.spring.entity.MethodMetadata;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/4 0004
 * @description :
 * @since : 1.0
 */
public class AnnotationMetadataReadingVisitor extends ClassMetadataReadingVisitor implements AnnotationMetadata {

    private final ClassLoader classLoader;

    public AnnotationMetadataReadingVisitor(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * 类上的注释
     */
    private final Set<String> annotationSet = new LinkedHashSet<String>(4);

    /**
     * 元注释:即注释上的注释了，最基层的注释
     */
    private final Map<String, Set<String>> metaAnnotationMap = new LinkedHashMap<String, Set<String>>(4);

    /**
     * 注释的属性
     */
    private final Map<String, AnnotationAttributes> attributeMap = new LinkedHashMap<String, AnnotationAttributes>(4);

    /**
     * 方法上的注释
     */
    private final Set<MethodMetadata> methodMetadataSet = new LinkedHashSet<MethodMetadata>(4);

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        // Skip bridge methods - we're only interested in original annotation-defining user methods.
        // On JDK 8, we'd otherwise run into double detection of the same annotated method...
        //跳过桥接方法,桥接方法不用访问吧，因为我们只关注客户端定义的方法。
        if ((access & Opcodes.ACC_BRIDGE) != 0) {
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
        return new MethodMetadataReadingVisitor(name, access, getClassName(), this.classLoader, methodMetadataSet);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        String className = Type.getType(desc).getClassName();
        this.annotationSet.add(className);
        return new AnnotationAttributesReadingVisitor(this.classLoader,className,attributeMap,metaAnnotationMap);
    }

    public Set<String> getAnnotationTypes() {
        return this.annotationSet;
    }

    public Set<String> getMetaAnnotationTypes(String annotationType) {
        return this.metaAnnotationMap.get(annotationType);
    }

    public boolean hasAnnotation(String annotationType) {
        return this.annotationSet.contains(annotationType);

    }

    /**
     * 是否有最根上的注释
     *
     * @param metaAnnotationType the meta-annotation type to look for
     * @return
     */
    public boolean hasMetaAnnotation(String metaAnnotationType) {
        Collection<Set<String>> allMetaTypes = this.metaAnnotationMap.values();
        for (Set<String> metaTypes : allMetaTypes) {
            if (metaTypes.contains(metaAnnotationType)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnnotated(String annotationType) {
        return this.attributeMap.containsKey(annotationType);
    }

    /**
     * 获取注释上的属性
     *
     * @param annotationType the annotation type to look for
     * @return
     */
    public Map<String, Object> getAnnotationAttributes(String annotationType) {
        return getAnnotationAttributes(annotationType, false);
    }

    public Map<String, Object> getAnnotationAttributes(String annotationType, boolean classValuesAsString) {
        AnnotationAttributes raw = this.attributeMap.get(annotationType);
        return convertClassValues(raw, classValuesAsString);
    }

    public boolean hasAnnotatedMethods(String annotationType) {
        //todo:
        return false;
    }

    public Set<MethodMetadata> getAnnotatedMethods(String annotationType) {
        //todo:
        return null;
    }

    private Map<String, Object> convertClassValues(AnnotationAttributes raw, boolean classValuesAsString) {
        if (raw == null)
            return null;
        //先复制一份
        AnnotationAttributes result = new AnnotationAttributes(raw.size());
        //todo:
        return result;
    }


}
