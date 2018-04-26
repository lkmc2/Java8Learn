package Chapter01.ChooseColorAndWeightInApple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by lkmc2 on 2018/4/26.
 */



public class ChooseAppleMethodreference {

    /**
     * 断言接口
     * @param <T> 参数类型
     */
    public interface Predicate<T> {
        /**
         * 测试参数是否符合规则
         * @param t 参数
         * @return 参数是否符合规则
         */
        boolean test(T t);
    }

    /**
     * 过滤出符合要求的苹果列表
     * @param stock 苹果库存
     * @param p 断言
     * @return 符合要求的苹果列表
     */
    public static List<Apple> filterApples(List<Apple> stock, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : stock) {
            // 判断苹果是否符合要求
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);

        System.out.println("-----绿苹果列表-----");
        // 过滤列表中的绿苹果并打印（方法引用）
        printInfoInList(filterApples(appleList, Apple::isGreen));

        System.out.println("-----质量大于150g苹果列表-----");
        //过滤出列表中质量大于150g的水果并打印（方法引用）
        printInfoInList(filterApples(appleList, Apple::isHeavyApple));

        /*
        运行结果：
            -----绿苹果列表-----
            Apple{color='green', weight=17}
            Apple{color='green', weight=141}
            Apple{color='green', weight=191}
            Apple{color='green', weight=199}
            -----质量大于150g苹果列表-----
            Apple{color='red', weight=164}
            Apple{color='red', weight=216}
            Apple{color='green', weight=191}
            Apple{color='green', weight=199}
         */
    }

    /**
     * 打印列表中的信息
     * @param list 列表
     * @param <T> 列表的类型
     */
    public static <T> void printInfoInList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    /**
     * 根据类型生成对象添加到列表中
     * @param clazz 对象类型
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 含对象的列表
     */
    public static <T> List<T> generateObjToList(Class<T> clazz, Object... args) {
        Constructor<T> useConstructor = null;

        Class[] types = new Class[args.length];
        for (int i = 0, len = args.length; i < len; i++) {
            types[i] = args[i].getClass();
        }

        try {
            useConstructor = clazz.getConstructor(types);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (useConstructor == null) {
            return null;
        }

        List<T> result = new ArrayList<>();
        try {
            Object[] params = null;
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                params = new Object[args.length];

                for (int j = 0, len = params.length; j < len; j++) {
                    switch (args[j].getClass().getSimpleName()) {
                        case "String":
                            int value = random.nextInt(2);
                            params[j] = (value == 0) ? Apple.GREEN : Apple.RED;
                            break;
                        case "Integer":
                            params[j] = random.nextInt(300);
                            break;
                        default:
                            break;
                    }
                }

                T obj = useConstructor.newInstance(params);
                result.add(obj);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
