package model;

public class Card {
    private String suit;//花色
    private String point;//点数
    private int number;//计算的数字

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Card() {
        super();
    }

    public Card(String suit, String point, int number) {
        this.suit = suit;
        this.point = point;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", point='" + point + '\'' +
                ", number=" + number +
                '}';
    }
}
