package top.blentle.asm.first.reflect;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.util.TraceClassVisitor;

import java.util.HashMap;

/**
 * Created by blentle on 2017/2/16.
 */
public class ExampleTest {

    @Test
    public void testFieldGet(){
        ExampleRef ref = new ExampleRef();
        ref.setAge(99);
        ref.setHeight(1.70);
        ref.setId(110008);
        ref.setName("110008-name-test-ref!");

        ExampleRef ref02 = new ExampleRef();
        ref02.setAge(9902);
        ref02.setHeight(1.7002);
        ref02.setId(11000802);
        ref.setName("11000802-name-test-ref-02?");

        ExampleRef ref03 = new ExampleRef();
        ref03.setAge(9903);
        ref03.setHeight(1.7003);
        ref03.setId(11000803);
        ref03.setName("11000803-name-test-ref-03-----");

        Example example = new Example();
        example.setA(10);
        example.setB(22.2);
        example.setC("3333.3.3.3.3.3---------");
        example.setWidth(9089.09);

        example.setRef(ref);
        example.setId02(02);
        example.setId03(03);
        example.setS01("s01");
        example.setRef02(ref02);
        example.setRef03(ref03);
        //get fieldValueByCircle
        long start = System.currentTimeMillis();
        String res1 = ReflectUtil.fieldsToString(example);
        long end = System.currentTimeMillis();
        System.err.println("循环调用用时:" + (end - start) + "ms");
        System.err.println("循环调用后的结果:" + res1);

//        ClassReader reader = new ClassReader("top.blentle.asm.first.Example");
//        ClassVisitor visitor = new TraceClassVisitor()
//        ClassNode classNode = new ClassNode();
//        reader.accept(reader,0);
//        classNode.
        System.err.println(0xFFFF);
    }
}
