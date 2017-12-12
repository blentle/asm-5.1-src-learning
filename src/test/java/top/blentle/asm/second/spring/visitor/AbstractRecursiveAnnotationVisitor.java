package top.blentle.asm.second.spring.visitor;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import top.blentle.asm.second.spring.entity.AnnotationAttributes;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :
 * @since : 1.0
 */
abstract class AbstractRecursiveAnnotationVisitor extends AnnotationVisitor {

    protected final AnnotationAttributes attributes;

    protected final ClassLoader classLoader;

    public AbstractRecursiveAnnotationVisitor(ClassLoader classLoader, AnnotationAttributes attributes) {
        super(Opcodes.ASM5);
        this.attributes = attributes;
        this.classLoader = classLoader;
    }

    @Override
    public void visit(String name, Object value) {
        attributes.put(name, value);
    }


    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        String className = Type.getType(desc).getClassName();
        AnnotationAttributes annotationAttributes = new AnnotationAttributes();
        this.attributes.put(name, annotationAttributes);
        return new RecursiveAnnotationAttributesVisitor(className, this.classLoader, annotationAttributes);
    }
}
