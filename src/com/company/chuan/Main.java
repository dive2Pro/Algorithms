package com.company.chuan;

public class Main {

    public static void main(String[] args) {

        int divisor = getGreatestCommonDivisorIn(130, 25);

//      System.out.println(5 / 3);
        int[] ary = { 1, 2, 3};
        System.out.println(rank(2, ary));
    }

    public static int getGreatestCommonDivisorIn(int number1, int number2) {
        if (number2 == 0) {
            return 0;
        }

        int divisor = number1 % number2;

        if (divisor == 0) {
            return number2;
        }

        return getGreatestCommonDivisorIn(number2, divisor);
    }

    public static int rank(int key, int[] numbers) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (numbers[mid] < key) {
                lo = mid + 1;
            } else if (numbers[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
}


