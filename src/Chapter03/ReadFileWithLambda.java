package Chapter03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用Lambda简化文件读取方式
 */

public class ReadFileWithLambda {

    // 读取一行文件内容
    public static String processFile() throws IOException {
        // 此处使用了Java7中带资源的try语句，系统会自动关闭资源
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    // 函数式接口（读取文件逻辑处理器）
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }

    /**
     * 读取文件内容
     * @param processor 读取文件逻辑处理器
     * @return 处理后的文件内容
     * @throws IOException 输入输出流异常
     */
    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        // 读取文件的一行内容（普通方法）
        String result = processFile();
        System.out.println(result);

        // 读取文件的一行内容（Lambda，指定参数类型）
        result = processFile((BufferedReader br) -> br.readLine());
        System.out.println(result);

        // 读取文件的两行内容（Lambda，省略参数类型）
        result = processFile((br) -> br.readLine() + br.readLine());
        System.out.println(result);

        // 读取文件的一行内容（方法引用）
        result = processFile(BufferedReader::readLine);
        System.out.println(result);

        /*
        运行结果：
        We were both young when I first saw you
        We were both young when I first saw you
        We were both young when I first saw youI close my eyes and the flashback starts
        We were both young when I first saw you
         */
    }
}
