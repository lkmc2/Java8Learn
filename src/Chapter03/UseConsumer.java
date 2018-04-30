package Chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用java8自带Consumer断言条件
 */

public class UseConsumer {

//        java8 自带的Consumer接口如下：
//        @FunctionalInterface
//        public interface Consumer<T>{
//            void accept(T t);
//        }

    /**
     * 遍历对象列表
     * @param list 对象列表
     * @param c 消费条件
     * @param <T> 对象类型
     */
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    public static void main(String[] args) {
        // 使用Lambda设置变量内容
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));

        // 使用方法引用设置变量内容
        forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);
    }
}
