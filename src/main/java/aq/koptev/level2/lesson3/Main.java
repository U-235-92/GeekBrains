package aq.koptev.level2.lesson3;

public class Main {

    public static void main(String[] args) {
        String text = "...Отчаяние свойственно тем," +
                " кто не понимает причин зла," +
                " тем, кто не видит выхода," +
                " тем, кто не способен бороться.";
        WordParser wordParser = new WordParser(text);
        wordParser.printUniqueWords();
        wordParser.printUniqueWordsCountStatistic();
    }
}
