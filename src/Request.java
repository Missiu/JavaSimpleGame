import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Tue Dec 13 17:40:41 CST 2022
 */



/**
 * @author MuQuanyu
 */
public class Request extends JPanel {
    private Player player;

    public void butRequest(){
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.getCards(true);
            }
        });

        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDisable();
                player.nextPlayer();
            }
        });
    }
    public Request(Player player) {
        this.player = player;
        initComponents();
        butRequest();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText(bundle.getString("Request.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize()));
            panel1.add(label1);
            label1.setBounds(15, 5, 120, 30);

            //---- button1 ----
            button1.setText(bundle.getString("Request.button1.text"));
            panel1.add(button1);
            button1.setBounds(10, 40, 50, 30);

            //---- button2 ----
            button2.setText(bundle.getString("Request.button2.text"));
            panel1.add(button2);
            button2.setBounds(70, 40, 50, 30);

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
        }
        add(panel1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
