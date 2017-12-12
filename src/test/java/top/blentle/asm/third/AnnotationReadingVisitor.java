package top.blentle.asm.third;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/11 0011
 * @description :
 * @since : 1.0
 */
public class AnnotationReadingVisitor extends AnnotationVisitor {

    private String className;

    private Set<String> set;

    public AnnotationReadingVisitor(String className, Set<String> set) {
        super(Opcodes.ASM5);
        this.className = className;
        this.set = set;
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
        set.add(className);
        System.err.println("..........这个方法一定会被调用...................");
        super.visitEnd();
    }
}
