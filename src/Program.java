import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Developer dev = new Developer("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        Technology t = new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);
        Tester tester = new Tester("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);
        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        Goal g = new Goal(2010, 10, 15, "Implementing FB login", 1000);
        manager.addGoals(g);
        employees.add(manager);
        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}

class Tester extends Employee {
    private ArrayList<String> testTypes;

    public Tester(String imie, String nazwisko, String adres, String email, String pesel, int rokZatrudnienia) {
        super(imie, nazwisko, adres, email, pesel, rokZatrudnienia);
        testTypes = new ArrayList<>();
    }

    public void addTestType(String s) {
        testTypes.add(s);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        return baseSalary + (testTypes.size() * 300);
    }
}

class Developer extends Employee {
    private ArrayList<Technology> technologies;

    public Developer(String imie, String nazwisko, String adres, String email, String pesel, int rokZatrudnienia) {
        super(imie, nazwisko, adres, email, pesel, rokZatrudnienia);
        technologies = new ArrayList<>();
    }

    public void addTechnology(Technology t) {
        technologies.add(t);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        for (Technology tech : technologies) {
            bonus += tech.getBonus();
        }
        return baseSalary + bonus;
    }
}

class Technology {
    private String name;
    private int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Manager extends Employee {
    private ArrayList<Goal> goals;

    public Manager(String imie, String nazwisko, String adres, String email, String pesel, int rokZatrudnienia) {
        super(imie, nazwisko, adres, email, pesel, rokZatrudnienia);
        goals = new ArrayList<>();
    }

    public void addGoals(Goal g) {
        goals.add(g);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        for (Goal goal : goals) {
            if (goal.isAchieved()) {
                bonus += goal.getBonus();
            }
        }
        return baseSalary + bonus;
    }
}

class Goal {
    private int year;
    private int month;
    private int day;
    private String name;
    private int bonus;

    public Goal(int year, int month, int day, String name, int bonus) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        this.bonus = bonus;
    }

    public boolean isAchieved() {
        // Add logic to determine if the goal is achieved, for example, based on current date
        return false;
    }

    public int getBonus() {
        return bonus;
    }
}

class Employee {
    private String imie;
    private String nazwisko;
    private String adres;
    private String email;
    private String pesel;
    private int rokZatrudnienia;

    public Employee(String imie, String nazwisko, String adres, String email, String pesel, int rokZatrudnienia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.email = email;
        this.pesel = pesel;
        this.rokZatrudnienia = rokZatrudnienia;
    }

    public int calculateSalary() {
        int baseSalary = 3000 + ((2024 - rokZatrudnienia) * 1000);
        return baseSalary;
    }
}
