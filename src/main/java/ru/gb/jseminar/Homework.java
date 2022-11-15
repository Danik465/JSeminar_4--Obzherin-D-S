package ru.gb.jseminar;

import java.util.*;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(2,5,8));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,8,-2));
//        hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)));
//        // result [0,0,1]
//        hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
//        // result [0,-2]

        System.out.println(hw.sum(d1,d2));



    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){

        Deque<Integer> result = new ArrayDeque<>();

        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int temp = 0;
        int dif = 0;
        int ost = 0;

        boolean sign1 = false;
        boolean sign2 = false;
        if (d1.getLast()<0){
            sign1 = true;
        }
        if (d2.getLast()<0){
            sign2 = true;
        }

        if((d1.getLast() > 0  && d2.getLast()> 0) || (d1.getLast()< 0 && d2.getLast() < 0)){
            while (d1.size() != 0 || d2.size() !=0){

                int sum = 0;
                if (d1.size() != 0){
                    sum+= d1.pollFirst();

                }
                if (d2.size() != 0){
                    sum+= d2.pollFirst();
                }

                if(sum > 9){
                    result.add(((temp + sum)%10));
                    temp = 1;
                    sum = 1;
                }
                else {
                    result.add(temp+(sum));
                    temp = 0;
                    sum = 0;
                }

            }
            if(temp == 1 && sign1 != true && sign2 != true){
                result.add(temp);
            }
            else if (temp == 1 && sign1 == true && sign2 == true){
                result.add(-temp);
            }

        }
        else if(Math.abs(d1.getLast()) > Math.abs(d2.getLast())){

                while (d1.size() != 0 || d2.size() !=0){

                    if(Math.abs(d1.getFirst()) > Math.abs(d2.getFirst())){
                        dif = ost+temp + (Math.abs(d1.pollFirst()) - Math.abs(d2.pollFirst()));
                        if(dif >= 10){
                             ost = 1;
                        }
                        else {
                            result.add(-dif);
                        }
                        temp = 0;
                        ost = 0;

                    }
                    else {
                        dif = ost + temp+(Math.abs(d1.pollFirst()+10)- Math.abs(d2.pollFirst()));

                        if(dif >= 10){
                            ost = 1;
                            result.add(-dif%10);

                        }
                        result.add(-dif);

                        temp = -1;
                        dif = 0;


                    }
                }

            }
        else {
            while (d1.size() != 0 || d2.size() !=0){
                if(Math.abs(d1.getFirst()) < Math.abs(d2.getFirst())){
                    dif = temp + (Math.abs(d2.pollFirst()) - Math.abs(d1.pollFirst()));

                    if(dif >= 10){
                        ost = 1;
                    }

                    else {
                        result.add(dif);
                    }
                    temp = 0;
                    ost = 0;
                    temp = 0;

                }
                else {
                    dif = temp+(Math.abs(d2.pollFirst()+10)- Math.abs(d1.pollFirst()));


                    if(dif >= 10){
                        ost = 1;
                        result.add(dif%10);

                    }
                    result.add(dif);

                    temp = -1;
                    dif = 0;

                }
            }

        }
//        Deque<Integer> result = new ArrayDeque<>();
//
//        int n1 = 0;
//        int n2 = 0;
//
//        Boolean negativ_flag_1 = false;
//        Boolean negativ_flag_2 = false;
//
//        while (!d1.isEmpty()) {
//            if (d1.getLast() < 0){
//                n1 = 10 * n1 - d1.pollLast();
//                negativ_flag_1 = true;
//            }
//            else {
//                n1 = 10 * n1 + d1.pollLast();
//            }
//
//        }
//
//        while (!d2.isEmpty()) {
//            if (d2.getLast() < 0){
//                n2 = 10 * n2 - d2.pollLast();
//                negativ_flag_2 = true;
//            }
//            else {
//                n2 = 10 * n2 + d2.pollLast();
//            }
//        }
//
//        if (negativ_flag_1) {
//            n1 = -n1;
//        }
//        if (negativ_flag_2) {
//            n2 = -n2;
//        }
//
//        int sum = n1 + n2;
//
//        if (sum > 0) {
//            do{
//                result.add(sum % 10);
//                sum /= 10;
//            } while  (sum > 0);
//        } else {
//            do{
//                result.add(sum % 10);
//                sum /= 10;
//            } while  (sum < 0);
//        }
//

        return result;

    }
}
