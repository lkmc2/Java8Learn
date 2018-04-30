package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Created by lkmc2 on 2018/4/30.
 * Lambda对应的函数式接口
 */

public class LambdaDescription {
    // 布尔表达式
    Predicate<List<String>> booleanLambda = (List<String> list) -> list.isEmpty();
    // 对应的方法引用形式
    Predicate<List<String>> booleanMethodReference = List::isEmpty;

    // 创建对象
    Supplier<Apple> createObjLambda = () -> new Apple();
    // 对应的方法引用形式
    Supplier<Apple> createObjMethodReference= Apple::new;

    // 消费一个对象
    Consumer<Apple> consumerLambda = (Apple a) -> System.out.println(a.getWeight());

    // 从一个对象中选择/提取
    Function<String, Integer> strToLenLambda = (String s) -> s.length();
    // 对应的方法引用形式
    Function<String, Integer> strToLenMethodReference = String::length;
    // 第二种表示方法
    ToIntFunction<String> toLenLambda = (String s) -> s.length();

    // 合并两个值
    IntBinaryOperator addLambda = (int a, int b) -> a * b;

    // 比较两个对象
    Comparator<Apple> compareApple1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    // 对应的方法引用形式
    Comparator<Apple> compareAppleMethodReference = Comparator.comparing(Apple::getWeight);
    // 第二中表示方法
    BiFunction<Apple, Apple, Integer> compareApple2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    // 第三种表示方式
    ToIntBiFunction<Apple, Apple> compareApple3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
}
