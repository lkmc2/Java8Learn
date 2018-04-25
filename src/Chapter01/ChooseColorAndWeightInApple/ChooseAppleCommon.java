package Chapter01.ChooseColorAndWeightInApple;

import com.sun.tracing.dtrace.ArgsAttributes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by lkmc2 on 2018/4/25.
 * 获取特定条件苹果的普通方式
 */

public class ChooseAppleCommon {

    public static final String GREEN = "green";
    public static final String RED = "red";

    /**
     * 从库存中获取绿色的苹果
     *
     * @param stock 库存
     * @return 绿色的苹果列表
     */
    public static List<Apple> filterGreenApples(List<Apple> stock) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : stock) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从库存中获取质量超过150克的水果
     * @param stock 库存
     * @return 质量超过150克的水果列表
     */
    public static List<Apple> filterHeavyApples(List<Apple> stock) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : stock) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
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

    public static void main(String[] args) {
//        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----绿苹果列表-----");
        // 过滤列表中的绿苹果并打印
        printInfoInList(filterGreenApples(Objects.requireNonNull(appleList)));

        System.out.println("-----质量大于150g苹果列表-----");
        //过滤出列表中质量大于150g的水果并打印
        printInfoInList(filterHeavyApples(appleList));

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
     * 根据类型生成对象添加到列表中
     * @param clazz 对象类型
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 含对象的列表
     */
    public static <T> List<T> generateObjToList(Class<T> clazz, Object... args) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<T> useConstructor = null;

        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            int parameterCount = constructor.getParameterCount();

            if (parameterCount != args.length) {
                return null;
            }

            int equalsParamCount = 0;
            for (int i = 0; i < parameterCount; i++) {
                if (Objects.equals(parameterTypes[i], args[i].getClass())) {
                    equalsParamCount++;
                }
            }

            if (equalsParamCount == parameterCount) {
                useConstructor = constructor;
                break;
            }
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
                            params[j] = (value == 0) ? GREEN : RED;
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
