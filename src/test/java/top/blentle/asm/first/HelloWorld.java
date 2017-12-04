package top.blentle.asm.first;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by blentle on 2017/2/10.
 */
public class HelloWorld extends ClassLoader {
    public static void main(String[] args) {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V1_1 ,Opcodes.ACC_PUBLIC,"Example",null,"java/lang/Object",null);
        //访问构造方法
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC,"<init>","()V",null,null);
        //生成构造方法的字节码指令
        methodVisitor.visitVarInsn(Opcodes.ALOAD,0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/object","init<>","()V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(1,1);
        methodVisitor.visitEnd();
    }
}
