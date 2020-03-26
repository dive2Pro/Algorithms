package com.company.chuan.string;

class Student {
    private String name;
    private int clazz;

    public Student(String name, int clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    int key() {
        return this.clazz;
    }

    String name() {
        return name;
    }
}

public class KeyIndexSort {
    public static void main(String[] args) {
        int R = 6;
        int N = 30;
        Student[] students = new Student[N];


        for(int i = 0 ; i < 30 ; i ++) {
            students[i] = new Student("name-" + i, i % R );
        }

        int[] count = new int[R + 1];

        for(Student student: students) {
            count[student.key() + 1] ++;
        }

        for(int r = 0 ; r < R ; r ++) {
            count[ r + 1 ] += count[r];
        }

        Student[] aux = new Student[N];

        for(int i = 0 ; i < N ; i ++) {
            aux[count[students[i].key()] ++] = students[i];
        }

        System.out.println(R);
    }
}
