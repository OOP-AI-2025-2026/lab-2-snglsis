package ua.opnu;

import java.util.ArrayList;

public class Student {
    // Поля класу
    private String name;
    private int year;
    private ArrayList<String> courses;

    private static final int TUITION_PER_YEAR = 20000;

    // Конструктор
    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім.");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути від 1 до 4.");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додає дисципліну
    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            System.out.println("Назва дисципліни не може бути порожньою.");
            return;
        }
        courses.add(courseName);
    }

    // Видаляє всі дисципліни
    public void dropAll() {
        courses.clear();
    }

    // Повертає кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Повертає ім'я студента
    public String getName() {
        return name;
    }

    // Повертає рік навчання
    public int getYear() {
        return year;
    }

    // Повертає суму грошей за навчання
    public int getTuition() {
        return year * TUITION_PER_YEAR;
    }
}
