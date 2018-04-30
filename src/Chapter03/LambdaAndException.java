package Chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by lkmc2 on 2018/4/30.
 * Lambda与异常的处理方法
 */

public class LambdaAndException {

    /*
        任何函数式接口都不允许抛出受检异常（checked exception）。如果你需要Lambda
    表达式来抛出异常，有两种办法：定义一个自己的函数式接口，并声明受检异常，
    或者把Lambda包在一个 try/catch 块中
     */

    // 方式1
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }

    // 方式2
    Function<BufferedReader, String> f = (BufferedReader b) -> {
        try {
            return b.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

}
