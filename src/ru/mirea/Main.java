package ru.mirea;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    static Scanner scan;

    public static void main(String[] args) {
        // write your code here
        scan = new Scanner(System.in);
        exercise1(10);
        exercise2(10);
        exercise3(10, 20);
        exercise3(20, 10);
        exercise4(10, 3);//30,12,21
        exercise5(109);//1+9=10
        exercise6(12);//непростое NO
        exercise6(19);//простое YES
        exercise7(39); //3 13 39
        exercise7(41); //41
        exercise8("poop");//YES
        exercise8("poos");//NO
        exercise8("pop");//YES
        exercise8("mag");//NO
        exercise9(3, 3);
        exercise10(123);
        exercise11();
        exercise12();
        exercise13();
        exercise14(123); // 1 2 3
        exercise15(123); // 3 2 1
        exercise16();
        exercise17();
    }

    static void exercise1(int n) {
        System.out.println("Exercise1:" + n);
        exercise1realize(n,1);
    }

    static int exercise1realize(int n,int fact) {


        if(n!=1){
          fact=exercise1realize(n-1,0);
        }

        for(int i=1; i<fact+1;i++){
            System.out.print(fact +" ");

        }
        return n;

    }

    static void exercise2(int n) {
        System.out.println("\n\nExercise2:" + n);
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");

        }
    }

    static void exercise3(int n1, int n2) {
        System.out.println("\nExercise3:" + n1 + " " + n2);
        if (n1 <= n2) {
            for (int i = n1; i <= n2; i++) {
                System.out.print(i + " ");

            }
        } else {
            for (int i = n1; i >= n2; i--) {
                System.out.print(i + " ");
            }

        }

    }

    static void exercise4(int k, int d) {
        System.out.println("\nExercise4:" + k + " " + d);
        int length = (int) (Math.log10(k) + 1);

        int answer = 0;
        int sumNumber = 0;
        int downNumber = (int) Math.pow(10, length - 1);
        int upNumber = (int) Math.pow(10, length);
        System.out.println(downNumber + " " + upNumber);
        for (int i = downNumber; i < upNumber; i++, sumNumber = 0) {
            for (int j = i; j > 0; j /= 10)
                sumNumber += j % 10;
            if (sumNumber == d) answer++;
        }
        System.out.println(answer);
    }

    static void exercise5(int n) {
        System.out.println("\nExercise5:" + n);
        System.out.println(exercise5_realize(n, 0));
    }

    static int exercise5_realize(int n, int sum) {
        if (n == 0) return sum;//условие выхода
        sum += n % 10;
        sum = exercise5_realize(n / 10, sum);
        return sum;
    }


    static void exercise6(int n) {
        System.out.println("\nExercise6:" + n);
        System.out.println(exercise6_realize(n, n - 1));
    }

    private static String exercise6_realize(int n, int del) {
        if (n % del == 0 && del > 1) return "NO";//10%9
        if (del == 1) return "YES";
        return exercise6_realize(n, del - 1);//10%9
    }

    static void exercise7(int n) {
        ArrayList<Integer> mnosh1 = new ArrayList<>();
        ArrayList<Integer> mnosh2 = new ArrayList<>();
        Set<Integer> a = new TreeSet<>();
        System.out.println("\nExercise7:" + n);
        for (int i = 2; i < Math.ceil(Math.sqrt(n)) + 1; i++) {
            if (n % i == 0) mnosh1.add(i);
        }
        for (int i = 0; i < mnosh1.size(); i++) {
            mnosh2.add(n / mnosh1.get(i));
        }
        a.addAll(mnosh1);
        a.addAll(mnosh2);
        a.add(n);

        System.out.println(a);

    }

    static void exercise8(String palindrom) {
        System.out.println("\nExercise8:" + palindrom);
        String palindromBegin;
        String palindromEnd;

        if (palindrom.length() % 2 == 0) {
            palindromBegin = palindrom.substring(0, palindrom.length() / 2);
            palindromEnd = palindrom.substring(palindrom.length() / 2, palindrom.length());
            palindromEnd = new StringBuffer(palindromEnd).reverse().toString();

            if (palindromBegin.equals(palindromEnd)) System.out.println("YES");
            else System.out.println("NO");
        } else {
            palindromBegin = palindrom.substring(0, palindrom.length() / 2);
            palindromEnd = palindrom.substring(palindrom.length() / 2 + 1, palindrom.length());
            palindromEnd = new StringBuffer(palindromEnd).reverse().toString();
            if (palindromBegin.equals(palindromEnd)) System.out.println("YES");
            else System.out.println("NO");
        }


    }

    static void exercise9(int a, int b) {
        System.out.println("\nExercise9:" + a + " " + b);
        System.out.println(exercise9realize(a, b));
    }

    static int exercise9realize(int a, int b) {
        if (a-1> b) return 0;
        if (a==0 || b==0) return 1;
        return exercise9realize(a,b-1)+exercise9realize(a-1,b-1);

    }

    static void exercise10(int a) {
        System.out.println("\nExercise9:" + a);
        System.out.println(exercise10realize(a, 0));
    }

    private static int exercise10realize(int n, int a) {
        if (n == 0) {
            return a;
        } else {
            return exercise10realize(n / 10, 10 * a + n % 10);//прошлый результат + нынешний остаток
        }
    }

    static void exercise11() {
        String c="1 1 0 1 0 1 1 1 0 0 1 1";
        System.out.println("\nExercise11:" + c);

        String [] cmass=c.split(" "); //разбитая строка
        int []mass=new int[cmass.length]; // целые числа

        for(int i=0; i<cmass.length;i++){
           mass[i]=Integer.parseInt(cmass[i]); //переводим строку в целые числа
        }

        int j=0;
        int answer=0;
        while(mass[j]!=0 || mass[j+1]!=0){
            if(mass[j]==1) answer++;
            j++;
        }
        System.out.println(answer);
    }

    static void exercise12() {
        String c="34 37 100 25 1 23 100 3323 0";
        System.out.println("\nExercise12:" + c);

        String [] cmass=c.split(" "); //разбитая строка
        int []mass=new int[cmass.length]; // целые числа

        for(int i=0; i<cmass.length;i++){
            mass[i]=Integer.parseInt(cmass[i]); //переводим строку в целые числа

        }

        int j=0;
        while(mass[j]!=0){
            if(mass[j]%2==0) System.out.print(mass[j]+" ");
            j++;
        }
    }
    static void exercise13() {
        String c="34 37 100 25 1 23 100 3323 0";
        System.out.println("\n\nExercise13:" + c);

        String [] cmass=c.split(" "); //разбитая строка
        int []mass=new int[cmass.length]; // целые числа

        for(int i=0; i<cmass.length;i++){
            mass[i]=Integer.parseInt(cmass[i]); //переводим строку в целые числа
        }

        int j=0;

        while(mass[j]!=0){
            if(j%2!=0) System.out.print(mass[j]+" ");
            j++;
        }
    }

    static void exercise14(int n) {
        System.out.println("\n\nExercise14:" + n);
        exercise14realize(n,0);

    }

    static int exercise14realize(int n, int step){
        if(n/10!=0) {
            step++;
            exercise14realize(n/10,step);
        }
        System.out.print(n%10 +" ");

        return 0;
    }

    static void exercise15(int n) {
        System.out.println("\n\nExercise15:" + n);
        exercise15realize(n);

    }

    static int exercise15realize(int n){
        if(n==0) return 0;
        System.out.print(n%10 +" ");
        return exercise15realize(n/10);
    }
    static void exercise17(){
        String c="34 37 100 25 1 23 100 3323 0";
        System.out.println("\n\nExercise17:" + c);

        String [] cmass=c.split(" "); //разбитая строка
        int []mass=new int[cmass.length]; // целые числа

        for(int i=0; i<cmass.length;i++){
            mass[i]=Integer.parseInt(cmass[i]); //переводим строку в целые числа
        }

        int j=0;
        int max=0;
        while(mass[j]!=0){
            if(mass[j]>max) max=mass[j];


            j++;
        }
        System.out.println(max);



    }

    static void exercise16(){
        String c="34 37 100 25 1 23 100 332 900 1 1 2 3 900 900 0";
        System.out.println("\n\nExercise16:" + c);

        String [] cmass=c.split(" "); //разбитая строка
        int []mass=new int[cmass.length]; // целые числа

        for(int i=0; i<cmass.length;i++){
            mass[i]=Integer.parseInt(cmass[i]); //переводим строку в целые числа
        }

        int j=0;
        int max=0;
        int quantityMax=0;
        while(mass[j]!=0){
            if(mass[j]==max){
                quantityMax++;
            }

            if(mass[j]>max) {
                max=mass[j];
                quantityMax=1;
            }



            j++;
        }
        System.out.println(quantityMax);



    }

}
