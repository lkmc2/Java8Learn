package Chapter03;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by lkmc2 on 2018/5/1.
 * 方法引用示例03
 */

public class MethodReferenceDemo03 {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        // map中放入Apple和Orange类的构造方法引用
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    /**
     * 获取水果
     * @param fruit 名称为apple或orange
     * @param weight 水果重量
     * @return 生成指定重量的苹果或橘子
     */
    public static Fruit getMeFruit(String fruit, Integer weight) {
        // 调用继承自Fruit(Integer weight)的构造方法
        return map.get(fruit.toLowerCase()).apply(weight);
    }

    public static void main(String[] args) {
        // 生成苹果类型的对象
        Fruit apple = getMeFruit("apple", 12);
        System.out.println(apple);

        // 生成橘子类型的对象
        Fruit orange = getMeFruit("orange", 8);
        System.out.println(orange);

        /*
        运行结果；
        Apple: Fruit{color='null', weight=12}
        Orange: Fruit{color='null', weight=8}
         */
    }
}
