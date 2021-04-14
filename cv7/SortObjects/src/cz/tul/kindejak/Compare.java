package cz.tul.kindejak;

import java.util.Arrays;

public class Compare {
    private static Student[] students = new Student[3];

    public static void main(String[] args) {
        students[0] = new Student("Alice", 423, 2.5);
        students[1] = new Student("Cyril",223,1.5);
        students[2] = new Student("Bob",323,2.1);

        System.out.println(Arrays.toString(students));

        Arrays.sort(students); //Arrays.sort tridi pole jakykoliv objektu interface comparble
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,new CompareStudentAverage());
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,new CompareStudentName());
        System.out.println(Arrays.toString(students));
    }
}
