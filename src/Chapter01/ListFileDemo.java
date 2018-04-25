package Chapter01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by lkmc2 on 2018/4/25.
 */

public class ListFileDemo {

    /**
     * 普通方法过滤隐藏文件
     */
    public static void listFile() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        printInfoInArray(hiddenFiles);
    }

    /**
     * 使用lambda过滤隐藏文件
     */
    public static void listFileWithLambda() {
        File[] hiddenFiles = new File(".").listFiles(file -> file.isHidden());

        printInfoInArray(hiddenFiles);
    }

    /**
     * 使用方法引用过滤隐藏文件
     */
    public static void listFileWithMethodReference() {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        printInfoInArray(hiddenFiles);
    }


    /**
     * 打印数组中的信息
     * @param array 数组
     * @param <T> 数组的类型
     */
    public static <T> void printInfoInArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        listFile();
        listFileWithLambda();
        listFileWithMethodReference();
    }

    /*
    运行结果：（说明：该目录下只有NothingInTheWorld.txt一个隐藏文件）
        .\NothingInTheWorld.txt
        .\NothingInTheWorld.txt
        .\NothingInTheWorld.txt
     */
}
