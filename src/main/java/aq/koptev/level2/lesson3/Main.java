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

        System.out.println();

        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add("Коптев", "88009995522");
        telephoneBook.add("Коптев", "89008887744");
        telephoneBook.add("Коптев", "a89008887744");
        telephoneBook.add("Коптев", "890088877ff44");
        telephoneBook.add("Коптев", "89008887744.");
        telephoneBook.add("Иванов", "89755533214");
        telephoneBook.add("Иванов", "89755533214й");
        telephoneBook.printContactInfo("Коптев");
    }
}
