package cz.tul.kindejak;

import java.util.Comparator;

public class Student implements Comparable<Student>{
    private String name;
    private int number;
    private double average;

    public Student(String name, int number, double average) {
        this.name = name;
        this.number = number;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", average=" + average +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return  Integer.compare(this.number,o.getNumber());
    }
}
