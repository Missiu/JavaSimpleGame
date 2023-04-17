import model.Card;
import model.SettingModel;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Tue Dec 13 16:00:57 CST 2022
 */



/**
 * @author MuQuanyu
 */
public class MainFarme extends JFrame {

    private SettingModel settingModel;

    public SettingModel getSettingModel() {
        return settingModel;
    }

    /**
     * 所有的玩家
     */
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }


    /**
     * 庄家
     */
    private Maker maker;

    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }


    /**
     * 游戏流程
     */
    private String[] process = new String[]{"切牌","押注","要牌"};

    /**
     * 当前的游戏流程
     */
    private int processIndex = -1;
    /**
     * 先发一轮牌
     */
    public void dealCard(){
        // 首轮发牌,没人两张
        for (int i = 0; i < 2; i++) {
            // 发玩家的牌
            for(Player player : players){
                if (!player.isGameOver()){
                    player.getCards(true);
                }
            }
            // 发庄家的牌
            maker.getCards(false);
        }
    }

    /**
     * 结算操作
     */
    public  void  account(){
        if (maker.getNumber() > 21){
            // 庄家爆了
            for (int i = players.size()-1; i>=0;i--){
                Player player = players.get(i);
                if (player.getNumber() <= 21){
                    maker.setMoney(maker.getMoney() - player.getBet());
                    player.setMoney(player.getMoney() + player.getBet());
                    maker.setLose(maker.getLose() + 1);//庄家输的次数+1
                    player.setWin(player.getWin() + 1);//闲家赢的次数+1
                }
            }
        }else {
            for (int i = players.size() - 1 ; i >= 0 ;i--) {// 遍历所有的闲家
                Player player = players.get(i);
                if (player.getNumber() > 21){ // 闲家爆了
                    maker.setWin(maker.getWin() + 1);//庄家输的次数+1
                    player.setLose(player.getLose() + 1);//闲家赢的次数+1
                    maker.setMoney(maker.getMoney() + player.getBet());
                    player.setMoney(player.getMoney() - player.getBet());
                } else if (player.getNumber() > maker.getNumber()){//闲家大于了庄家的点数
                    maker.setLose(maker.getLose() + 1);//庄家输的次数+1
                    player.setWin(player.getWin() + 1);//闲家赢的次数+1
                    maker.setMoney(maker.getMoney() - player.getBet());
                    player.setMoney(player.getMoney() + player.getBet());
                } else if (player.getNumber() < maker.getNumber()){
                    maker.setWin(maker.getWin() + 1);//庄家输的次数+1
                    player.setLose(player.getLose() + 1);//闲家赢的次数+1
                    maker.setMoney(maker.getMoney() + player.getBet());
                    player.setMoney(player.getMoney() - player.getBet());
                }
            }
        }
    }


    /**
     * 表示下一个流程
     */
    public void nextProcess(){
        processIndex++;
        if (processIndex == 2){
            // 先发一轮牌
            dealCard();
        }
        if (processIndex>=process.length){
            // 流程结束
            // 庄家要牌
            maker.getCard();
            account();
            // 如果没有玩家了 就意味着游戏结束了
            if (players.isEmpty()){
                JOptionPane.showConfirmDialog(this,"所有玩家都没钱了，游戏结束","提示",JOptionPane.DEFAULT_OPTION);
                System.exit(0);//退出程序
            }
            //还有玩家就需要开启新的一轮游戏
            maker.newRound();
            for (Player player : players) {
                player.newRound();
            }
            initCard();//重新拿一副新牌
            processIndex = -1;
            nextProcess();
            return;
        }
        JOptionPane.showConfirmDialog(this,"当前开始" + process[processIndex],"提示",JOptionPane.DEFAULT_OPTION);
        // 让第0个玩家显示对应的流程界面
        setPlayer(0);
    }

    /**
     * 让指定的玩家显示对应的流程界面
     */
    public void setPlayer(int index){
        if (index == players.size()){//下一个玩家已经是最后一个了 直接进行下一步
            nextProcess();
            return;
        }

        if (index + 1 < players.size()){
            //当前玩家不是最后一个了
            for (int i = index + 1; i < players.size(); i++) {
                Player player = players.get(i);
                if (!player.isGameOver()){
                    player.setDisable();
                }
            }
            //然后设置当前玩家为具体的流程
        }
        switch (processIndex){
            case 0:
                players.get(index).setCutCard();
                break;
            case 1:
                players.get(index).setStake();
                break;
            case 2:
                players.get(index).setRequest();
                break;
        }
    }
    /**
     * 初始化牌
     */
    public void initCard(){
        String [] suits = new String[]{"黑桃","梅花","方片","红桃"};
        String [] points = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //循环创建牌
        for (int i = 0; i < suits.length; i++) {
            for (int j = 1; j <= points.length ; j++) {
                Card card = new Card(suits[i],points[j-1],j > 10 ? 10 : j);
                cards.add(card);
            }
        }
        //牌初始化完成了
        //打乱这个牌
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家
     */
    public void initPlayer(){
        Integer playerCount = settingModel.getPlayerCount(); // 玩家数量
        for (Integer i = 0; i < 4; i++) {
            Player player = new Player(i<playerCount,this);
            if (i<playerCount){
                players.add(player); // 传入玩家人数
            }
            panel2.add(player);
        }
    }

    /**
     * 切牌操作
     */
    public void cutCard() {
        String number = JOptionPane.showInputDialog(this, "请输入切牌的数量(1-" + cards.size() + ")", "提示", JOptionPane.DEFAULT_OPTION);
        if (number == null || "".equals(number)){//如果输入的是空就重新输入
            JOptionPane.showConfirmDialog(this,"切牌的数量不能为空","提示",JOptionPane.DEFAULT_OPTION);
            cutCard();
            return;
        }
        while (!number.matches("\\d{1,2}")){//如果输入的不是一个数字就重新输入
            JOptionPane.showConfirmDialog(this,"切牌的数量必须是一个数字","提示",JOptionPane.DEFAULT_OPTION);
            cutCard();
            return;
        }
        cards = cards.subList(Integer.parseInt(number),cards.size());//删除前面的那些牌
    }
    private void initComponents() {
        Dimension d = getSize();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {

            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setPreferredSize(new Dimension(1920, 1080));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setPreferredSize(new Dimension(10, 400));
                contentPanel.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setPreferredSize(new Dimension(0, 250));
                    panel1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    panel1.setLayout(new BorderLayout());

                    maker = new Maker(this);
                    panel1.add(maker);
                }
                contentPanel.add(panel1, BorderLayout.NORTH);

                //======== panel2 ========
                {
//                    panel2.setPreferredSize(new Dimension(0, 0));
                    panel2.setLayout(new GridLayout(1, 4));
                    panel1.setPreferredSize(new Dimension(0, 250));

                }
                contentPanel.add(panel2, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(925, 825);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public MainFarme(SettingModel settingModel) {
        this.settingModel = settingModel;
        initComponents(); // 初始化界面
        initPlayer(); // 初始化玩家
        initCard(); // 初始化牌
        nextProcess(); // 下一步流程

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JPanel panel2; //玩家的面板容器

    public JPanel getPanel2() {
        return panel2;
    }

    public JPanel getDialogPane() {
        return dialogPane;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

