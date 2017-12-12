package top.blentle.asm.second.spring.visitor;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import top.blentle.asm.second.spring.entity.AnnotationAttributes;
import top.blentle.asm.second.spring.entity.MethodMetadata;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description : 方法元数据的访问
 * @since : 1.0
 */
public class MethodMetadataReadingVisitor extends MethodVisitor implements MethodMetadata {

    private final String name;

    private final int access;

    private final String declaringClassName;

    private final ClassLoader classLoader;

    private final Set<MethodMetadata> methodMetadataSet;

    /**
     * 注释
     */
    private final Map<String, AnnotationAttributes> attributeMap = new LinkedHashMap<String, AnnotationAttributes>(2);


    public MethodMetadataReadingVisitor(String name, int access, String declaringClassName, ClassLoader classLoader, Set<MethodMetadata> methodMetadataSet) {
        super(Opcodes.ASM5);
        this.name = name;
        this.access = access;
        this.declaringClassName = declaringClassName;
        this.classLoader = classLoader;
        this.methodMetadataSet = methodMetadataSet;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        String className = Type.getType(desc).getClassName();
        this.methodMetadataSet.add(this);
        //return new AnnotationA;
        return null;
    }

    public String getMethodName() {
        return this.name;
    }

    public String getDeclaringClassName() {
        return this.declaringClassName;
    }

    public boolean isStatic() {
        return ((this.access & Opcodes.ACC_STATIC) != 0);
    }

    public boolean isFinal() {
        return ((this.access & Opcodes.ACC_FINAL) != 0);
    }

    public boolean isOverridable() {
        return (!isStatic() && !isFinal() && ((this.access & Opcodes.ACC_PRIVATE) == 0));
    }

    public boolean isAnnotated(String annotationType) {
        return attributeMap.containsKey(annotationType);
    }

    public Map<String, Object> getAnnotationAttributes(String annotationType) {
        return this.attributeMap.get(annotationType);
    }
}
