package model;

public class SettingModel {
    private Integer playerCount;
    private Integer money;


    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public SettingModel() {
        super();
    }

    public SettingModel(Integer playerCount, Integer money) {
        super();
        this.playerCount = playerCount;
        this.money = money;
    }

    @Override
    public String toString() {
        return "SettingModel{" +
                "playerCount=" + playerCount +
                ", money=" + money +
                '}';
    }
}
