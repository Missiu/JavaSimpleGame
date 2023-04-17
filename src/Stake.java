import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*
 * Created by JFormDesigner on Tue Dec 13 17:40:22 CST 2022
 */



/**
 * @author MuQuanyu
 */
public class Stake extends JPanel {
    private Player player;
    public Stake(Player player) {
        this.player = player;
        initComponents();
        slider1.setMinimum(1);
        slider1.setMaximum(player.getMoney());
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label2.setText(slider1.getValue() + "");
            }
        });

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setBet(slider1.getValue()); // 设置押注
                player.setDisable();
                player.nextPlayer();
            }
        });



    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label1 = new JLabel();
        slider1 = new JSlider();
        button1 = new JButton();
        label2 = new JLabel();

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText(bundle.getString("Stake.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 3f));
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(-5, 5), label1.getPreferredSize()));
            panel1.add(slider1);
            slider1.setBounds(0, 40, 125, 15);

            //---- button1 ----
            button1.setText(bundle.getString("Stake.button1.text"));
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(35, 70), button1.getPreferredSize()));

            //---- label2 ----
            label2.setText("1");
            panel1.add(label2);
            label2.setBounds(125, 35, 30, label2.getPreferredSize().height);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
            add(panel1);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JSlider slider1;
    private JButton button1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
