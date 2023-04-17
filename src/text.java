import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class text {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(800,800); //
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x关闭程序

        JButton butten1 = new JButton("1");
        JButton butten2 = new JButton("2");
        JButton butten3 = new JButton("3");
        JButton butten4 = new JButton("4");

        butten1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击之后");
            }
        });
//        四方布局
//        butten1.setPreferredSize(new Dimension(50,50));  // 设置大小
//        jFrame.add(butten1,BorderLayout.WEST);  // 调整方位
//        jFrame.add(butten2,BorderLayout.EAST);

//        流式布局
//        FlowLayout flowLayout = new FlowLayout();  // 实例流式布局对象
//        flowLayout.setAlignment(FlowLayout.LEFT);  // 流式布局左对齐
//        jFrame.setLayout(flowLayout);  // 在JFrame中设置流式布局
//        butten1.setPreferredSize(new Dimension(50,50)); // 设置大小
//        jFrame.add(butten1);
//        jFrame.add(butten2);
//        jFrame.add(butten3);
//        jFrame.add(butten4);

//        表格布局
//        GridLayout gridBagLayout = new  GridLayout(2,2); // 实例化2行2列表格布局
//        jFrame.setLayout(gridBagLayout); //  在JFrame中设置表格布局
//        jFrame.add(butten1);
//        jFrame.add(butten2);
//        jFrame.add(butten3);
//        jFrame.add(butten4);

//         绝对布局
//        jFrame.setLayout(null);
//        jFrame.add(butten1);
//        butten1.setBounds(10,10,100,100);  // 绝布局需要设置坐标以及大小
//        jFrame.add(butten2);
//        butten2.setBounds(50,50,100,100);
//        jFrame.add(butten3);
//        butten3.setBounds(100,100,100,100);
//
//        butten3.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2){
//                    System.out.println("鼠标双击");
//                }
//                System.out.println("鼠标单击");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                if (e.getButton() == MouseEvent.BUTTON3){
//                    JPopupMenu jPopupMenu = new JPopupMenu();
//                    JMenuItem item = new JMenuItem("删除");
//                    jPopupMenu.add(item);
//                    jPopupMenu.show(butten3,e.getX(),e.getY());
//                }
//            }
//        });

//        JTextArea jTextArea = new JTextArea("这是个文本框");
//        jFrame.add(jTextArea);
//        jTextArea.addKeyListener(new KeyAdapter() {
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_J){// ctrl + j
//                    System.out.println("按下了 ctrl + j ");
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//            }
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//            }
//        });//键盘事件
        jFrame.setVisible(true); // 可见

    }
}
