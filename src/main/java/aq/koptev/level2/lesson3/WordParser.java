package aq.koptev.level2.lesson3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {
    private List<String> listWords = null;
    private Set<String> setWords = null;
    private Map<String, Integer> mapWordsCount = null;
    private Pattern wordPattern = null;
    private Matcher wordMatcher = null;
    private String text;

    public WordParser(String text) {
        this.text = text;
        listWords = new ArrayList<>();
        setWords = new LinkedHashSet<>();
        mapWordsCount = new LinkedHashMap<>();
        wordPattern = Pattern.compile("[А-Яа-яA-Za-z]+");
        wordMatcher = wordPattern.matcher(text);
        fillListWords();
        fillSetWords();
    }

    private void fillListWords() {
        while(wordMatcher.find()) {
            listWords.add(wordMatcher.group());
        }
    }

    private Set<String> fillSetWords() {
        setWords.addAll(listWords);
        return setWords;
    }

    public void printUniqueWordsCountStatistic() {
        if(listWords.size() > 0) {
            getMapCountWord();
            printMapCountWord();
        } else {
            printEmptyMapCountWord();
        }
    }

    private void getMapCountWord() {
        List<String> copyListWords = new ArrayList<>(listWords);
        Collections.sort(copyListWords);
        String countedWord = copyListWords.get(0);
        int countSameWord = 1;
        for(int i = 1; i < copyListWords.size(); i++) {
            if(countedWord.equals(copyListWords.get(i))) {
                countSameWord++;
            } else {
                mapWordsCount.put(countedWord, countSameWord);
                countSameWord = 1;
                countedWord = copyListWords.get(i);
            }
        }
        mapWordsCount.put(countedWord, countSameWord);
    }

    private void printMapCountWord() {
        System.out.println("Статистика по количеству слов в тексте:");
        for(Map.Entry<String, Integer> entry : mapWordsCount.entrySet()) {
            System.out.printf("слово: %-15s количество: %d\n", entry.getKey(), entry.getValue());
        }
    }

    private void printEmptyMapCountWord() {
        System.out.println("Список слов пуст!");
    }

    public void printUniqueWords() {
        System.out.println("Уникальные слова текста:");
        System.out.println(setWords);
    }

    public Set<String> getSetWords() {
        return setWords;
    }
}
