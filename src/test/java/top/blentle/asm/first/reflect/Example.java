package top.blentle.asm.first.reflect;

/**
 * Created by blentle on 2017/2/10.
 */
public class Example extends ExampleSuper03{
    private Integer a;
    private Double b;
    private String c;
    private ExampleRef ref;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public ExampleRef getRef() {
        return ref;
    }

    public void setRef(ExampleRef ref) {
        this.ref = ref;
    }

    public static void main(String[] args) {
        System.err.println("Hello world !");
    }
}
