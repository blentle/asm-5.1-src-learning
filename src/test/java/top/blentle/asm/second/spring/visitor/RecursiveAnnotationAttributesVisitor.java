package top.blentle.asm.second.spring.visitor;

import top.blentle.asm.second.spring.entity.AnnotationAttributes;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description : 递归调用获取注释的属性
 * @since : 1.0
 */
class RecursiveAnnotationAttributesVisitor extends AbstractRecursiveAnnotationVisitor {

    /**
     * 注释类型
     */
    private final String annotationType;

    public RecursiveAnnotationAttributesVisitor(String annotationType, ClassLoader classLoader, AnnotationAttributes attributes) {
        super(classLoader, attributes);
        this.annotationType = annotationType;
    }



}
