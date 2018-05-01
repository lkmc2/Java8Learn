package Chapter03;

import java.awt.*;

/**
 * Created by lkmc2 on 2018/5/1.
 * 自定义接口（三个参数，一个返回值）
 */

public class DefineInterfaceMyself {

    // 自定义接口（三个参数，一个返回值）
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    // 指向Color类的Color(int r, int g, int b)构造器
    static TriFunction<Integer, Integer, Integer, Color> colorConstructor = Color::new;

    public static void main(String[] args) {
        // 使用apply方法调用Color三个参数的构造器
        Color color = colorConstructor.apply(120, 133, 232);
        // 打印生成的颜色对象
        System.out.println(color);

        /*
        运行结果：
        java.awt.Color[r=120,g=133,b=232]
         */
    }

}
