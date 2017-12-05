package top.blentle.asm.second.spring;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import top.blentle.asm.second.spring.visitor.AnnotationMetadataReadingVisitor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/4 0004
 * @description :  初步出发点:
 * 一直想知道spring的annotation是如何实现继承的，如 Controller ，Service ,Configuration 上面都会有Component，
 * 也正是这个Component，所以Spring的Context才能找到Bean ，然后才loadBeans ，看源码时，发现了一个SimpleMetadataReader类
 * ，其构造方法使用了ASM 来读取类信息，还好之前了解了一点儿asm，现在就类信息的读取，来复习一下asm
 * @since : 1.0
 */
public class ClassReaderTest {

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream("F:\\GitHub\\asm-5.1-src-learning\\target\\test-classes\\top\\blentle\\asm\\second\\spring\\visitor\\ClassTest.class"));
            ClassReader reader = new ClassReader(is);
            ClassVisitor visitor = new AnnotationMetadataReadingVisitor();
            reader.accept(visitor, ClassReader.SKIP_DEBUG);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
