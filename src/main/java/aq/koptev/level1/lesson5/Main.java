package aq.koptev.level1.lesson5;

public class Main {

    public static void main(String[] args) {

        int size = 5;
        Employe[] employes = new Employe[size];
        employes[0] = new Employe("Nikolai", "Koptev", "Alexandrovich", "Programmer",
                "nikolay@my.aq", "88005553535", 250000, 27);
        employes[1] = new Employe("Vladimir", "Ivanov", "Viktorowich", "Engineer",
                "vlad@my.aq", "89515753544", 250000, 47);
        employes[2] = new Employe("Olesya", "Gulyeva", "Alexandrovna", "Doctor",
                "evaa@my.aq", "89053481881", 250000, 22);
        employes[3] = new Employe("Svetlana", "Usanova", "Borisovna", "Accountant",
                "usanova@my.aq", "89078883974", 250000, 40);
        employes[4] = new Employe("Sergei", "Chestnow", "Olegovich", "Pilot",
                "pilot@my.aq", "89025758844", 250000, 42);

        for(Employe employe : employes) {

            if(employe.getAge() >= 40) {

                employe.printInfo();
            }
        }
    }
}
