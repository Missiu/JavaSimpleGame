import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import model.SettingModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*
 * Created by JFormDesigner on Mon Dec 12 15:49:18 CST 2022
 */

/**
 * @author unknown
 */
public class jftete extends JFrame {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        jftete jftete = new jftete();
        jftete.setVisible(true);
    }
    public jftete() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel();
        panel3 = new JPanel();
        label1 = new JLabel();
        panel4 = new JPanel();
        Integer [] arrays = new Integer[]{1,2,3,4};
        comboBox2 = new JComboBox(arrays);
        panel5 = new JPanel();
        label3 = new JLabel();
        panel6 = new JPanel();
        slider1 = new JSlider();
        label4 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //======== panel1 ========
                {
                    panel1.setLayout(new GridLayout());
                }
                contentPanel.add(panel1);
                panel1.setBounds(new Rectangle(new Point(210, 20), panel1.getPreferredSize()));

                //======== panel2 ========
                {
                    panel2.setLayout(new FlowLayout());

                    //---- label2 ----
                    label2.setText(bundle.getString("jftete.label2.text"));
                    label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 17f));
                    label2.setFocusTraversalPolicyProvider(true);
                    panel2.add(label2);
                }
                contentPanel.add(panel2);
                panel2.setBounds(0, 0, 495, 50);

                //======== panel3 ========
                {

                    //---- label1 ----
                    label1.setText(bundle.getString("jftete.label1.text"));
                    label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(label1)
                                .addContainerGap(84, Short.MAX_VALUE))
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                contentPanel.add(panel3);
                panel3.setBounds(0, 60, 250, 60);

                //======== panel4 ========
                {

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(comboBox2)
                                .addGap(68, 68, 68))
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(comboBox2)
                                .addContainerGap())
                    );
                }
                contentPanel.add(panel4);
                panel4.setBounds(245, 60, 250, 60);

                //======== panel5 ========
                {

                    //---- label3 ----
                    label3.setText(bundle.getString("jftete.label3.text"));
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(label3)
                                .addContainerGap(61, Short.MAX_VALUE))
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                contentPanel.add(panel5);
                panel5.setBounds(0, 140, 250, 60);

                //======== panel6 ========
                {

                    //---- label4 ----
                    label4.setText("100");

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(slider1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
                    );

                    slider1.setMinimum(100);
                    slider1.setMaximum(1000);
                    slider1.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            label4.setText(slider1.getValue()+"");  //滑动条滑动，标签内容改变
                        }
                    });
                }
                contentPanel.add(panel6);
                panel6.setBounds(245, 140, 250, 60);

                //======== buttonBar ========
                {
                    buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                    buttonBar.setLayout(new GridBagLayout());
                    ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                    ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                    //---- okButton ----
                    okButton.setText("\u786e\u5b9a");
                    buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    okButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SettingModel settingModel = new SettingModel(arrays[comboBox2.getSelectedIndex()],slider1.getValue());
                            //再把对象通过构造方法传入了主界面
                            MainFarme mainFarme = new MainFarme(settingModel);
                            jftete.this.setVisible(false);
                            mainFarme.setVisible(true);
                        }
                    });

                    //---- cancelButton ----
                    cancelButton.setText("\u53d6\u6d88");
                    buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(buttonBar);
                buttonBar.setBounds(0, 225, 494, buttonBar.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label2;
    private JPanel panel3;
    private JLabel label1;
    private JPanel panel4;
    private JComboBox comboBox2;
    private JPanel panel5;
    private JLabel label3;
    private JPanel panel6;
    private JSlider slider1;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
