package aq.koptev.level2.lesson3;

import java.util.*;

public class TelephoneBook {

    private Map<String, List<String>> phoneBook;

    public TelephoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phone) {
        try {
            if(surname.equals("") | surname == null) {
                throw new EmptySurnameException();
            }

            if(phone == null) {
                throw new EmptyPhoneNumberException();
            }

            if(!phone.matches("\\d+")) {
                throw new FormatPhoneNumberException(phone);
            } else {
                addContact(surname, phone);
            }
        } catch (FormatPhoneNumberException | EmptyPhoneNumberException | EmptySurnameException e) {
            e.printStackTrace();
        }
    }

    private void addContact(String surname, String phone) {
        List<String> contactPhones;
        if(phoneBook.get(surname) == null) {
            contactPhones = new ArrayList<>();
        } else {
            contactPhones = phoneBook.get(surname);
        }
        contactPhones.add(phone);
        phoneBook.put(surname, contactPhones);
    }

    public void printContactInfo(String surname) {
        List<String> telephoneNumbers = get(surname);
        if(telephoneNumbers == null) {
            printEmptyContactInfo(surname);
        } else {
            printContactInfo(surname, telephoneNumbers);
        }
    }

    private void printEmptyContactInfo(String surname) {
        System.out.println("Контакт [" + surname + "] не найден");
    }

    private void printContactInfo(String surname, List<String> telephoneNumbers) {
        System.out.println(surname + ": " + telephoneNumbers);
    }

    public List<String> get(String surname) {
        return phoneBook.get(surname);
    }

    private class FormatPhoneNumberException extends Exception {
        private String exceptPhoneNumber;

        public FormatPhoneNumberException(String exceptPhoneNumber) {
            super();
            this.exceptPhoneNumber = exceptPhoneNumber;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + ": указанное значение телефона " +
                    exceptPhoneNumber + " недопустимо";
        }
    }

    private class EmptyPhoneNumberException extends Exception {
        @Override
        public String toString() {
            return getClass().getSimpleName() + ": поле телефона пустое или не указано";
        }
    }

    private class EmptySurnameException extends Exception {
        @Override
        public String toString() {
            return getClass().getSimpleName() + ": поле фамилии контакта пустое или не указано";
        }
    }
}
