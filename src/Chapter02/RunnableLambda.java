package Chapter02;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用Lambda创建线程
 */

public class RunnableLambda {

    // 普通线程创建方法
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("执行线程1……");
        }
    });

    // 使用Lambda创建线程
    static Thread thread2 = new Thread(() -> System.out.println("执行线程2……"));

    public static void main(String[] args) {
        thread1.start();
        thread2.start();
    }

}
