package top.blentle.asm.third;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import top.blentle.asm.second.spring.ClassReaderTest;
import top.blentle.asm.second.spring.visitor.AnnotationMetadataReadingVisitor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/11 0011
 * @description :
 * @since : 1.0
 */
public class ClassAnnotationTest {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream("F:\\GitHub\\asm-5.1-src-learning\\target\\test-classes\\top\\blentle\\asm\\second\\spring\\visitor\\ClassTest.class"));
            ClassReader reader = new ClassReader(is);
            ClassVisitor visitor = new ClassMetadataReadingVisitor();
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
