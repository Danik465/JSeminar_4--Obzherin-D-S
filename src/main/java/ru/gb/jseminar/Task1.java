package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,5));
        // result [1,0,6,6]
        Logger log =  Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(new Task1().sum(d1,d2)));

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int temp = 0;
        while (d1.size() != 0 || d2.size() !=0){
            if(d1.getLast() + d2.getLast() > 9){
                result.addFirst((temp + d1.getLast() + d2.getLast())%10);
                temp = 1;
            }
            else {
                result.addFirst(temp+(d1.getLast() + d2.getLast()));
                temp = 0;
            }
            d1.pollLast();
            d2.pollLast();

        }
        if(temp == 1){
            result.addFirst(temp);
        }
        return  result;
    }
}
