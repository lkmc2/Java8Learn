package Chapter05.ModelPractice;

import Chapter05.Entity.Trader;
import Chapter05.Entity.Transaction;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream映射单元练习
 */

public class Practice {

    public static void main(String[] args) {
        // 交易者信息
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        // 交易列表
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 找出2011年发生的所有交易，并按交易额排序（从低到高）
        filterTransactionIn2011AndSortAsc(transactions);

        // 找出交易员都在哪些不同的城市工作过
        filterTraderWorkCity(transactions);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        filterTradeInCambridgeSortByName(transactions);

        // 返回所有交易员的姓名字符串，按字母顺序排序
        filterByAllTraderNameSortByAlpha(transactions);

        // 判断有没有在米兰工作的交易者
        ifHaveTraderInMilan(transactions);

        // 打印生活在剑桥的交易员的所有交易额
        printAllTranstionMoney(transactions);

        // 获取所有交易中最高的交易额
        filterMaxTransactionValue(transactions);

        // 找到交易额最小的交易
        filterMinTransactionValue(transactions);
    }

    // 找出2011年发生的所有交易，并按交易额排序（从低到高）
    private static void filterTransactionIn2011AndSortAsc(List<Transaction> transactions) {
        System.out.println("-----找出2011年发生的所有交易，并按交易额排序（从低到高）-----");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    // 找出交易员都在哪些不同的城市工作过
    private static void filterTraderWorkCity(List<Transaction> transactions) {
        System.out.println("-----找出交易员都在哪些不同的城市工作过-----");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    // 查找所有来自于剑桥的交易员，并按姓名排序
    private static void filterTradeInCambridgeSortByName(List<Transaction> transactions) {
        System.out.println("-----查找所有来自于剑桥的交易员，并按姓名排序-----");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);
    }

    // 返回所有交易员的姓名字符串，按字母顺序排序
    private static void filterByAllTraderNameSortByAlpha(List<Transaction> transactions) {
        System.out.println("-----返回所有交易员的姓名字符串，按字母顺序排序-----");
        String result = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(result);
    }

    // 判断有没有在米兰工作的交易者
    private static void ifHaveTraderInMilan(List<Transaction> transactions) {
        System.out.println("----判断有没有在米兰工作的交易者----");
        boolean ifAnyTraderInMilan = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(ifAnyTraderInMilan);
    }

    // 打印生活在剑桥的交易员的所有交易额
    private static void printAllTranstionMoney(List<Transaction> transactions) {
        System.out.println("-----打印生活在剑桥的交易员的所有交易额-----");
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    // 获取所有交易中最高的交易额
    private static void filterMaxTransactionValue(List<Transaction> transactions) {
        System.out.println("-----获取所有交易中最高的交易额----");
        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max)
            .ifPresent(System.out::println);
    }

    // 找到交易额最小的交易
    private static void filterMinTransactionValue(List<Transaction> transactions) {
        System.out.println("-----找到交易额最小的交易----");
        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::min)
            .ifPresent(System.out::println);
        // 另一种简单写法
        transactions.stream()
                .min(comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }

    /*
    运行结果：
    -----找出2011年发生的所有交易，并按交易额排序（从低到高）-----
    {Trader:Brian in Cambridge, year: 2011, value:300}
    {Trader:Raoul in Cambridge, year: 2011, value:400}
    -----找出交易员都在哪些不同的城市工作过-----
    Cambridge
    Milan
    -----查找所有来自于剑桥的交易员，并按姓名排序-----
    Trader:Alan in Cambridge
    Trader:Brian in Cambridge
    Trader:Raoul in Cambridge
    -----返回所有交易员的姓名字符串，按字母顺序排序-----
    AlanBrianMarioRaoul
    ----判断有没有在米兰工作的交易者----
    true
    -----打印生活在剑桥的交易员的所有交易额-----
    300
    1000
    400
    950
    -----获取所有交易中最高的交易额----
    1000
    -----找到交易额最小的交易----
    300
    {Trader:Brian in Cambridge, year: 2011, value:300}
     */
}
