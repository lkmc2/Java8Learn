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

    /**
     * 将苹果列表以指定格式打印
     * @param stock 苹果列表
     * @param formatter 打印格式策略
     */
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

        /*
        运行结果：
        -----------打印每个苹果的轻重和颜色-----------
        一个重的green的苹果
        一个轻的green的苹果
        一个重的red的苹果
        一个重的red的苹果
        一个重的green的苹果
        一个轻的red的苹果
        一个重的red的苹果
        一个重的red的苹果
        一个轻的red的苹果
        一个轻的green的苹果
        -----------打印每个苹果的重量-----------
        一个290g的苹果
        一个40g的苹果
        一个274g的苹果
        一个178g的苹果
        一个258g的苹果
        一个25g的苹果
        一个198g的苹果
        一个206g的苹果
        一个7g的苹果
        一个133g的苹果
         */
    }
}
