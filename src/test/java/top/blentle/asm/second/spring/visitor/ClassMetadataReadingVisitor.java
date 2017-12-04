package top.blentle.asm.second.spring.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
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
public class ClassMetadataReadingVisitor extends ClassVisitor implements ClassMetadata {


    private String className;

    private boolean isInterface;

    private boolean isAbstract;

    private boolean isFinal;

    /**
     *  是否有内部类
     */
    private String enclosingClassName;

    /**
     *  内部类是否是可以被new 出来的
     */
    private boolean independentInnerClass;

    private String superClassName;

    private String[] interfaces;

    private Set<String> memberClassNames = new LinkedHashSet<String>();


    public ClassMetadataReadingVisitor() {
        super(Opcodes.ASM4);
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
        return false;
    }

    public String getEnclosingClassName() {
        return null;
    }

    public boolean hasSuperClass() {
        return false;
    }

    public String getSuperClassName() {
        return null;
    }

    public String[] getInterfaceNames() {
        return new String[0];
    }

    public String[] getMemberClassNames() {
        return new String[0];
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.err.println(".............");
    }
}
