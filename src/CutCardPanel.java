import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Tue Dec 13 17:31:38 CST 2022
 */



/**
 * @author MuQuanyu
 */


public class CutCardPanel extends JPanel {
    private Player player;
    public CutCardPanel(Player player) {
        this.player = player;
        initComponents();
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.cutCard();
                player.setDisable();
                player.nextPlayer();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel4 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());

            //---- button1 ----
            button1.setText(bundle.getString("CutCardPanel.button1.text"));
            panel4.add(button1, BorderLayout.WEST);

            //---- button2 ----
            button2.setText(bundle.getString("CutCardPanel.button2.text"));
            panel4.add(button2, BorderLayout.EAST);

            //---- label1 ----
            label1.setText(bundle.getString("CutCardPanel.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 4f));
            panel4.add(label1, BorderLayout.NORTH);
        }
        add(panel4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel4;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
