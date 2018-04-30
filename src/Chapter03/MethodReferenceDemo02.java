package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 方法引用示例02
 */

public class MethodReferenceDemo02 {

    public static void main(String[] args) {

        // 指向Apple(String color, Integer weight)构造方法的引用
        BiFunction<String, Integer, Apple> appleConstructorLambda = (color, weight) -> new Apple(color, weight);
        // 将参数填入构造器，生成苹果对象（Lambda）
        Apple appleRed = appleConstructorLambda.apply(Apple.RED, 230);
        System.out.println(appleRed);

        // 对应的方法引用
        BiFunction<String, Integer, Apple> appleConstructorMethod = Apple::new;
        // 将参数填入构造器，生成苹果对象（方法引用）
        Apple appleGreen = appleConstructorLambda.apply(Apple.GREEN, 110);
        System.out.println(appleGreen);

        /*
        运行结果：
        Apple{color='red', weight=230}
        Apple{color='green', weight=110}
         */
    }
}
