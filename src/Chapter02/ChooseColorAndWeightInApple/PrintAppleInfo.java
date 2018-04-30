package Chapter02.ChooseColorAndWeightInApple;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 编写分条件苹果打印的方法
 */

/*
    编写一个 prettyPrintApple 方法，它接受一个Apple的List，并可以对它参数化，以多种方式
    根据苹果生成一个String 输出（有点儿像多个可定制的 toString 方法）。
    可以让prettyPrintApple方法 ，只打印每个苹果的重量。
    或让prettyPrintApple方法分别打印每个苹果的轻重和颜色。
 */

public class PrintAppleInfo {

    // 苹果打印格式策略
    public interface AppleFormatter {
        String accept(Apple apple);
    }

    // 打印苹果轻重和颜色的格式策略
    public static class AppleWeightAndColorFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String desc = apple.getWeight() > 150 ? "重" : "轻";
            return "一个" + desc + "的" + apple.getColor() + "的苹果";
        }
    }
    // 打印苹果重量的格式策略
    public static class AppleWeightFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return "一个" + apple.getWeight() + "g的苹果";
        }
    }


    public static void prettyPrintApple(List<Apple> stock, AppleFormatter formatter) {
        for (Apple apple : stock) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);

        System.out.println("-----------打印每个苹果的轻重和颜色-----------");
        prettyPrintApple(appleList, new AppleWeightAndColorFormatter());

        System.out.println("-----------打印每个苹果的重量-----------");
        prettyPrintApple(appleList, new AppleWeightFormatter());
    }
}
