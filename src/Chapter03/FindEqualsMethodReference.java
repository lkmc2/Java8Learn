package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by lkmc2 on 2018/5/1.
 * 找出等效的方法引用
 */

public class FindEqualsMethodReference {

    // 将字符串解析成数字（Lambda形式）
    Function<String, Integer> stringToIntegerLambda = (String s) -> Integer.parseInt(s);
    // 等效的方法引用
    Function<String, Integer> stringToIntegerMethod = Integer::parseInt;

    // 判断列表中是否包含指定的元素（Lambda形式）
    BiPredicate<List<String>, String> containsLambda = (list, element) -> list.contains(element);
    // 等效的方法引用
    BiPredicate<List<String>, String> containsMethod = List::contains;

    public static void main(String[] args) {
        // 创建对象（供应者）
        Supplier<Apple> supplier1 = () -> new Apple();
        // 获取创建的苹果对象
        Apple apple1 = supplier1.get();
        System.out.println(apple1);

        // 等效的方法引用
        Supplier<Apple> supplier2 = Apple::new;
        // 获取创建的苹果对象
        Apple apple2 = supplier2.get();
        System.out.println(apple2);
        /*
        运行结果：
        Apple{color='null', weight=null}
        Apple{color='null', weight=null}
         */

        // 指向Apple(Integer weight)构造方法的方法应用
        Function<Integer, Apple> functionLambda = (weight) -> new Apple(weight);
        // 此处通过apply方法向构造参数传weight参数
        Apple apple3 = functionLambda.apply(110);
        System.out.println(apple3);

        // 等效的方法引用，指向Apple(Integer weight)构造方法
        Function<Integer, Apple> functionMethod = Apple::new;
        // 此处通过apply方法向构造参数传weight参数
        Apple apple4 = functionMethod.apply(223);
        System.out.println(apple4);
        /*
        运行结果：
        Apple{color='null', weight=110}
        Apple{color='null', weight=223}
         */
    }
}
