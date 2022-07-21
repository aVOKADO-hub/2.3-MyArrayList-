package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(4);
        list.boxes[0]= new Box(3,3,3);
        list.boxes[1]= new Box(3,3,3);
        list.boxes[2]= new Box(3,3,3);
        list.boxes[3]= new Box(3,3,3);
        Box[] list2 = new Box[4] ;
        list2[0]= new Box(22,32,213);
        list2[1]= new Box(323,3312,331);
        list2[2]= new Box(3312321,3312,3321);
        list2[3]= new Box(33121,3312,3311);
        list.add(new Box(4,22,24));
        list.add(new Box(2,22,24));
        list.addAll(list2,2);
        System.out.println(list);
        System.out.println(list.boxes.length);
        System.out.println(Arrays.stream(list.boxes).toList().size());
        list.ensureCapacity(2);
        System.out.println(list.boxes.length);
        Box newBox = list.get(2);
        System.out.println(newBox);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());



    }

}