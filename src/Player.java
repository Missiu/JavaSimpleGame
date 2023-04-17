import model.Card;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import static sun.audio.AudioPlayer.player;
/*
 * Created by JFormDesigner on Tue Dec 13 09:11:07 CST 2022
 */



/**
 * @author MuQuanyu
 */
public class Player extends JPanel {
    public JPanel getContentPanel() {
        return contentPanel;
    }

    public MainFarme getMainFarme() {
        return mainFarme;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public JPanel getPanel5() {
        return panel5;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    private Player player;
    private MainFarme mainFarme;

    public int getMoney() {
        return money;
    }

    private int money;//玩家剩余的钱

    public void setMoney(int money) {
        this.money = money;
        if ( !(this instanceof Maker) && money <= 0){
            mainFarme.getPlayers().remove(this); // 自己退游
            setout(); // 玩家出局
        }
        initPlayer();
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    private int bet;//押注金额

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
        initPlayer();
    }

    private int win;//赢的次数

    private int lose;//输的次数

    private int number;// 记录当前总点数

    public int getNumber() {
        return number;
    }

    private boolean gameOver = false; // 游戏结束

    private List<Card> cards = new ArrayList<>(); // 每人手里的牌

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void newRound(){
        this.bet = 0;
        this.cards.clear();
        this.initPlayer();
        this.showCards(true);
        setDisable();
    }
    /**
     * 实现切牌功能
     */
    public void cutCard() {
        mainFarme.cutCard();
    }

    /**
     * 当前是第几个玩家
     * @return
     */
    public int getIndex(){
        return mainFarme.getPlayers().indexOf(this);
    }

    /**
     * 让下一个玩家开始操作
     */
    public void nextPlayer() {
        mainFarme.setPlayer(getIndex() + 1);
    }
    /**
     * 玩家要牌
     *
     */
    public void getCards(boolean show) {
        List<Card> chars = mainFarme.getCards();
        if (cards.isEmpty()){ // 没有牌的时候在初始化一副牌
            mainFarme.initCard();
        }
        // 把牌库删除的第1张牌给添加到玩家的牌库里
        this.cards.add(chars.remove(0));
        showCards(show);
    }

    /**
     * 显示牌
     */
    public void showCards(boolean show){
        number =0;
        panel1.removeAll();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            JLabel label = new JLabel(card.getSuit() + card.getPoint());
            label.setOpaque(true);//设置为不透明
            label.setBorder(BorderFactory.createLineBorder(Color.black));
            label.setFont(new Font("黑体",Font.PLAIN,20));
            panel1.add(label);
            if (i == cards.size()-1 && !show){
                label.setBackground(Color.black);//设置背景颜色为黑色就可以隐藏牌的内容
            }
            number += card.getNumber();
        }
        if (number <= 21){
            if (show){
                label6.setText("当前的点数为:"+number);
            }else {
                label6.setText("当前的点数为:" + cards.get(0).getNumber() + "+ ?");
            }
        }else {
            label6.setText("你超过了21点，爆掉了");
            setDisable();
            nextPlayer();
        }
        panel5.add(label6);
        panel5.updateUI();
    }

    /**
     * 无人游玩
     */
    public void setout(){
        JPanel panel4 = getPanel4();
        panel4.removeAll();
        JLabel jLabel = new JLabel("无人游玩");
        jLabel.setFont(new Font("黑体",Font.BOLD,40));
        jLabel.setOpaque(true);
        jLabel.setForeground(Color.WHITE);
        jLabel.setBackground(Color.gray);
        panel4.add(jLabel);
        panel4.updateUI();
    }

    /**
     * 是否切牌操作
     */
    public void setCutCard(){
        JPanel panel4 = getPanel4();
        CutCardPanel cutCardPanel = new CutCardPanel(this);
        panel4.removeAll();
        panel4.add(cutCardPanel);
        panel4.updateUI();
    }

    /**
     * 是否加注
     */
    public void setStake(){
        JPanel panel4 = getPanel4();
        Stake stake = new Stake(this);
        panel4.removeAll();
        panel4.add(stake);
    }
    /**
     * 是否要牌
     */
    public void setRequest(){
        JPanel panel4 = getPanel4();
        Request request = new Request(this);
        panel4.removeAll();
        panel4.add(request);
    }

    /**
     * 设置操作界面什么都不显示
     */
    public void setDisable(){
        getPanel4().removeAll();
        panel4.updateUI();
    }

    public void initPlayer(){
        label2.setText("当前金额:" + money);
        label4.setText("押注金额:" + bet);
        label5.setText("赢的次数:" + win);
        label3.setText("输的次数:" + lose);
        panel4.updateUI();
    }
    /**
     * 创建玩家面板
     */
    public Player(boolean hava, MainFarme mainFarme) {
        this.mainFarme = mainFarme;
        setLayout(new BorderLayout(0,5));
        if (!hava){
            JLabel jLabel = new JLabel("无人游玩");
            jLabel.setFont(new Font("黑体",Font.BOLD,40));
            jLabel.setOpaque(true);
            jLabel.setForeground(Color.WHITE);
            jLabel.setBackground(Color.gray);
            this.add(jLabel);
            return;
        }
        this.money = mainFarme.getSettingModel().getMoney();
        initComponents();
        initPlayer();
        setCutCard();
        setRequest();
        setStake();
        setDisable();
    }

 
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        panel5 = new JPanel();
        panel1 = new JPanel();
        label7 = new JLabel();
        label6 = new JLabel();
        panel4 = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(14, 50));
        Container contentPane = this;
        contentPane.setLayout(new BorderLayout(0, 5));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setMinimumSize(new Dimension(92, 400));
            dialogPane.setLayout(new BorderLayout(5, 5));

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(4, 1, 0, 5));

                    //---- label2 ----
                    label2.setPreferredSize(new Dimension(23, 35));
                    label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
                    panel3.add(label2);

                    //---- label4 ----
                    label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
                    panel3.add(label4);

                    //---- label5 ----
                    label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
                    panel3.add(label5);

                    //---- label3 ----
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
                    panel3.add(label3);
                }
                contentPanel.add(panel3, BorderLayout.PAGE_START);

                //======== panel5 ========
                {
                    panel5.setLayout(new GridLayout(2, 0));

                    //======== panel1 ========
                    {
                        panel1.setLayout(new FlowLayout());

                        //---- label7 ----
                        label7.setText(bundle.getString("player.label7.text"));
                        panel1.add(label7);
                    }
                    panel5.add(panel1);

                    //---- label6 ----
                    label6.setText(bundle.getString("player.label6.text"));
                    panel5.add(label6);
                }
                contentPanel.add(panel5, BorderLayout.CENTER);

                //======== panel4 ========
                {
                    panel4.setLayout(new BorderLayout());
                }
                contentPanel.add(panel4, BorderLayout.PAGE_END);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel3;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label3;
    private JPanel panel5;
    private JPanel panel1;
    private JLabel label7;
    private JLabel label6;
    private JPanel panel4;
// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
