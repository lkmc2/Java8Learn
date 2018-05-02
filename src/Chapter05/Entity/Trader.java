package Chapter05.Entity;

/**
 * Created by lkmc2 on 2018/5/2.
 * 交易者实体类
 */

public class Trader {
    private final String name; // 交易者名
    private final String city; // 城市

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
