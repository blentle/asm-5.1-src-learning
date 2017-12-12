package top.blentle.asm.third;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import top.blentle.asm.second.spring.entity.ClassMetadata;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/4 0004
 * @description : 类元素局读取的访问者 ，即类元素读取器
 * @since : 1.0
 */
public class ClassMetadataReadingVisitor extends ClassVisitor{


    private String className;

    private boolean isInterface;

    private boolean isAbstract;

    private boolean isFinal;

    /**
     * 外部类的类名称
     */
    private String enclosingClassName;

    /**
     * 要么没有外部类，即自身是顶层的类，要么是静态内部类
     */
    private boolean independentInnerClass;

    private String superClassName;

    private String[] interfaces;

    private Set<String> memberClassNames = new LinkedHashSet<String>();


    public ClassMetadataReadingVisitor() {
        super(Opcodes.ASM5);
    }


    public String getClassName() {
        return this.className;
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public boolean isAbstract() {
        return this.isAbstract;
    }

    public boolean isConcrete() {
        return !(this.isAbstract || this.isInterface);
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public boolean isIndependent() {
        return (this.enclosingClassName == null) || (this.independentInnerClass);
    }

    public boolean hasEnclosingClass() {
        return this.enclosingClassName != null;
    }

    public String getEnclosingClassName() {
        return this.enclosingClassName;
    }

    public boolean hasSuperClass() {
        return this.superClassName != null;
    }

    public String getSuperClassName() {
        return this.superClassName;
    }

    public String[] getInterfaceNames() {
        return this.interfaces;
    }

    public String[] getMemberClassNames() {
        return this.memberClassNames.toArray(new String[this.memberClassNames.size()]);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name.replaceAll("/", ".");
        this.isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
        this.isAbstract = (access & Opcodes.ACC_ABSTRACT) != 0;
        this.isFinal = (access & Opcodes.ACC_FINAL) != 0;
        if (superName != null)
            this.superClassName = superName.replaceAll("/", ".");
        this.interfaces = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            this.interfaces[i] = interfaces[i].replaceAll("/", ".");
        }
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        String className = Type.getType(desc).getClassName();
        return new AnnotationReadingVisitor(className);
    }
}
