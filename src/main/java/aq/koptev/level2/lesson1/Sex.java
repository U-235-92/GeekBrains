package aq.koptev.level2.lesson1;

public enum Sex {
    MALE("Мужчина"), FEMALE("Женщина");

    private String russianTitle;
    private Sex(String russianTitle)  {
        this.russianTitle = russianTitle;
    }

    public String getRussianTitle() {
        return russianTitle;
    }
}
