package top.blentle.asm.third;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/11 0011
 * @description :
 * @since : 1.0
 */
public class AnnotationReadingVisitor extends AnnotationVisitor {

    private String className;

    public AnnotationReadingVisitor(String className) {
        super(Opcodes.ASM5);
        this.className = className;
    }

    @Override
    public void visit(String name, Object value) {
        System.err.println("!!!!!!!!!!!!!!!!!!!!" + name);
        super.visit(name, value);
    }

    @Override
    public void visitEnum(String name, String desc, String value) {
        super.visitEnum(name, desc, value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        System.err.println("??????????????????????" + name);
        return super.visitAnnotation(name, desc);
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        return super.visitArray(name);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
