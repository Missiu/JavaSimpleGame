import javax.swing.*;
import java.awt.*;

public class Maker extends Player{
    public Maker(MainFarme mainFarme) {
        super(true, mainFarme);
        // 西边玩家面板
        JPanel panel3 = getPanel3(); // 实例化玩家面版
        getContentPanel().remove(panel3);
        panel3.setPreferredSize(new Dimension(150,35));
        getContentPanel().add(panel3, BorderLayout.WEST);
        // 东边操作面板
        JPanel panel4 = getPanel4();
        getContentPanel().remove(panel4);
        getContentPanel().add(panel4,BorderLayout.EAST);
    }

    public  void getCard(){
        while ((getNumber() < 16) || (getNumber() >= 16 && getNumber() < 18 && Math.random() <= 0.3) || (getNumber() >= 18 && getNumber() < 20 && Math.random() <= 0.1)){
            getCards(true);
        }
        showCards(true);
        JOptionPane.showConfirmDialog(getMainFarme(),"庄家选择了不要牌", "提示",JOptionPane.DEFAULT_OPTION);
    }
}
