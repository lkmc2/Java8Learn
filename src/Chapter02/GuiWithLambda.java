package Chapter02;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lkmc2 on 2018/4/30.
 * 在GUI中使用Lambda声明点击事件
 */

public class GuiWithLambda extends JFrame {

    // 按钮组件
    private JButton button;
    // 标签组件
    private JLabel label; 

    public GuiWithLambda() {
        setLayout(null);
        setBounds(350, 350, 400, 300);

        label = new JLabel("标签");
        label.setBounds(100, 30, 80, 50);

        button = new JButton("按钮");
        button.setBounds(150, 105, 80, 50);

        // 普通方式设置点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("点击了按钮");
            }
        });

        // 使用Lambda设置点击事件（指定参数类型）
        button.addActionListener((ActionEvent listener) -> label.setText("点击了按钮"));

        // 使用Lambda设置点击事件（省略参数类型）
        button.addActionListener(listener -> label.setText("点击了按钮"));

        // 添加组件到界面
        add(label);
        add(button);

        // 设置界面可见
        setVisible(true);
        // 设置点击右上角X按钮彻底关闭程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GuiWithLambda();
    }
}
