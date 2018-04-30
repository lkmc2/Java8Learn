package Chapter03;

import java.sql.SQLOutput;

/**
 * Created by lkmc2 on 2018/4/30.
 * Lambda对局部变量的限制
 */

public class LambdaFieldLimit {

    static String globalField = "Something";

    public static void main(String[] args) {
        int portNumber = 124;
        Runnable r = () -> System.out.println(portNumber);

        /*
         以下代码若修改portNumber会报错，
         在Lambda中出现的局部变量不能
         在lambda中使用的局部变量应该是final类型的，
         或者是等效于final类型的
          */
//        portNumber = 666;

        Runnable globalR = () -> System.out.println(globalField);
        // 在Lambda中出现的全局变量可以修改
        globalField = "I can change";
    }


}
