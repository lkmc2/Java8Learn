package Chapter05.Entity;

/**
 * Created by lkmc2 on 2018/5/2.
 * 交易实体类
 */

public class Transaction {
    private final Trader trader; // 交易者
    private final int year; // 年份
    private final int value; // 价钱

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}
