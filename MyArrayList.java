package org.example;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
    Box[] boxes;
    public MyArrayList(){
        boxes = new Box[10];
    }
    public MyArrayList(int initialCapacity){
        boxes = new Box[initialCapacity];
    }
    Box get(int index){
        return boxes[index];
    }
    int size(){
        int count =0;
        for (int i = 0;i<boxes.length;i++){
            if (boxes[i]!=null){
                count++;
            }
        }
        return count;
    }
    void set(int index, Box element){
        boxes[index] = element;
    }
    void remove(int index){
        Box[] result = new Box[boxes.length];
        for (int i = 0; i < index; i++) {
            result[i] = boxes[i];
        }
        for (int i = index; i < boxes.length-1; i++) {
            result[i] = boxes[i];
        }
        boxes = copy(result,result.length);
    }
    void add (Box e){
        int posForAdd = position(boxes);
        if (posForAdd==-1){
            posForAdd = boxes.length;
            boxes = copy(boxes, boxes.length*2);
            boxes[posForAdd] = e;
        }
        else{
            boxes = copy(boxes, boxes.length);
            boxes[posForAdd] = e;
        }
    }
    void add(Box e, int index)
    {
        Box[] result = new Box[boxes.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = boxes[i];
        }
        result[index] = e;
        for (int i = index + 1; i <= boxes.length; i++) {
            result[i] = boxes[i - 1];
        }
        boxes = copy(result,result.length);
    }
    void addAll(Box[] e){
        int posForAdd = position(boxes);
        if (posForAdd==-1){
            posForAdd = boxes.length;
            boxes = copy(boxes, boxes.length*2);
            for (int count = 0;count<e.length;count++){
                boxes[posForAdd++]=e[count];
            }
        }
        else{
            boxes = copy(boxes, boxes.length);
            for (int count = 0;count<e.length;count++){
                boxes[posForAdd++]=e[count];
            }
        }
    }
    void addAll(Box[] e, int index)
    {
        Box[] result = new Box[boxes.length + e.length];
        for (int i = 0; i < index; i++) {
            result[i] = boxes[i];
        }
        for (int i = index,count=0;count<e.length;i++){
            result[i]=e[count++];
        }
        for (int i = index + 1; i <= boxes.length; i++) {
            result[i] = boxes[i - 1];
        }
        boxes = copy(result,result.length);
    }
    private Box[] copy(Box[] oldArray,int newSize){
        Box[] newArray = new Box[newSize];
        System.arraycopy(oldArray,0,newArray,0,oldArray.length);
        return newArray;
    }
    void ensureCapacity(int minCapacity){
        boxes = copy(boxes, boxes.length+minCapacity);
    }
    private int position(Box[] array){
        int position = 0;
        for (int i = 0;i<array.length;i++){
            if (array[i] == null){
                position = i;
            }else{
                position = -1;
            }
        }
        return position;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var item:boxes){
            sb.append(item+"\n");
        };
        return sb.toString();
    }
}
