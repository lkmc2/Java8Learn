package Chapter03.Composite;

import java.util.function.Function;

/**
 * Created by lkmc2 on 2018/5/1.
 * 信封文本转换（函数复合）
 */

public class Letter {

    // 添加头部
    public static String addHeader(String text) {
        return "From lkmc2:" + text;
    }

    // 添加尾部
    public static String addFooter(String text) {
        return text + " To My love";
    }

    // 检查拼写
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    // 获取添加头部方法的引用
    static Function<String, String> addHeaderFunction = Letter::addHeader;

    // 函数复合，将添加头部、拼写检查、添加尾部复合在一个方法引用中
    static Function<String, String> transformationAll =
                    addHeaderFunction
                    .andThen(Letter::checkSpelling)
                    .andThen(Letter::addFooter);

    // 函数复合，将添加头部、添加尾部复合在一个方法引用中
    static Function<String, String> transformationHeaderAndFooter =
                    addHeaderFunction
                    .andThen(Letter::addFooter);

    public static void main(String[] args) {
        String text = "I don't know what is labda.";

        // 使用方法引用给文本添加头部或尾部
        String resultHeaderAndFoter = transformationHeaderAndFooter.apply(text);
        System.out.println(resultHeaderAndFoter);

        // 使用方法引用给文本添加头部、检查拼写、替换尾部
        String resultAll= transformationAll.apply(text);
        System.out.println(resultAll);

        /*
        运行结果：
        From lkmc2:I don't know what is labda. To My love
        From lkmc2:I don't know what is lambda. To My love
         */
    }
}
