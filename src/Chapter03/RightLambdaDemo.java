package Chapter03;

import java.util.concurrent.Callable;

/**
 * Created by lkmc2 on 2018/4/30.
 * 正确使用Lambda的例子
 */

public class RightLambdaDemo {

    /*
        说明：能使用Lambda替代的必须是函数式接口。
        函数式接口定义：只定义一个抽象方法的接口
     */

    /*
        @FunctionalInterface注解用于表示该接口是函数式接口，
        可限定接口只有一个抽象方法，否则报错。
     */
    @FunctionalInterface
    interface MyCallable {
        String apply();
    }

    public static void execute(Runnable r) {
        r.run();
    }

    public static Callable<String> fetch() {
        return () -> "正在使用fetch方法……";
    }

    public static void main(String[] args) {
        execute(() -> {
            System.out.println("正在执行execute方法……");
        });

        try {
            System.out.println(fetch().call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        运行结果：
            正在执行execute方法……
            正在使用fetch方法……
         */
    }
}
