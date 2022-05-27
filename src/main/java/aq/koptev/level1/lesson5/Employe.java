package aq.koptev.level1.lesson5;

public class Employe {

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
    private String position;

    private int salary;
    private int age;

    public Employe(String name, String surname, String patronymic, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[Employee: %s %s %s, position: %s, age: %d, e-mail: %s, phone: %s, salary: %d]",
                surname, name, patronymic, position, age, email, phone, salary);
    }
}
