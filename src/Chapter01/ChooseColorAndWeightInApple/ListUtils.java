package Chapter01.ChooseColorAndWeightInApple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lkmc2 on 2018/4/26.
 * 列表工具类
 */

public class ListUtils {

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
