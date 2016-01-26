package com.tonyzhai.algorithm;
public class OneArrayThreeStack {
    private int stackOneSize;
    private int stackTwoSize;
    private int stackThreeSize;
    private int totalSize;
    private int stackOneIndex;
    private int stackTwoIndex;
    private int stackThreeLeftIndex;
    private int stackThreeRightIndex;

    private int[] dataArray;

    public OneArrayThreeStack(int size){
        this.dataArray = new int[size];
        this.totalSize = size;
        this.stackOneIndex = 0;
        this.stackTwoIndex = size - 1;
        this.stackThreeLeftIndex = size/2;
        this.stackThreeRightIndex = size/2+1;
    }

    public void push(int data, int stackNum){
        assert stackNum == 1 || stackNum == 2 || stackNum == 3;
        if(hasSpace()){
            System.out.println("data " + data + " entry stack " + stackNum);
            if(stackNum == 1){
                dataArray[stackOneIndex++] = data;
                stackOneSize++;
            } else if(stackNum == 2){
                dataArray[stackTwoIndex--] = data;
                stackTwoSize++;
            } else{
                if(stackThreeSize%2 == 0){
                    dataArray[stackThreeLeftIndex--] = data;
                } else{
                    dataArray[stackThreeRightIndex++] = data;
                }
                stackThreeSize++;
            }
        } else{
            System.out.println("array is full");
        }
    }

    public int pop(int stackNum){
        int data = 0;
        assert stackNum == 1 || stackNum == 2 || stackNum == 3;
        if(stackNum == 1){
            if(stackOneSize > 0){
                stackOneSize--;
                data = dataArray[--stackOneIndex];
            } else{
                System.out.println("stack one empty");
                return 0;
            }
        } else if(stackNum == 2){
            if(stackTwoSize > 0) {
                stackTwoSize--;
                data = dataArray[++stackTwoIndex];
            } else{
                System.out.println("stack two empty");
                return 0;
            }
        } else {
            if(stackThreeSize > 0){
                stackThreeSize--;
                if(stackThreeSize%2 == 0){
                    data = dataArray[++stackThreeLeftIndex];
                } else{
                    data = dataArray[--stackThreeRightIndex];
                }
            }else {
                System.out.println("stack three empty");
                return 0;
            }
        }
        System.out.println("stack " + stackNum + " pop data " + data);
        return data;
    }

    private boolean hasSpace(){
        return totalSize > stackOneSize + stackTwoSize + stackThreeSize;
    }

    public static void main(String[] args){
        OneArrayThreeStack oneArrayThreeStack = new OneArrayThreeStack(9);
        oneArrayThreeStack.push(1,1);
        oneArrayThreeStack.push(2,2);
        oneArrayThreeStack.push(3,3);
        oneArrayThreeStack.push(4,1);
        oneArrayThreeStack.push(5,2);
        oneArrayThreeStack.push(6,3);
        oneArrayThreeStack.push(7,2);
        oneArrayThreeStack.push(8,1);
        oneArrayThreeStack.push(9,2);
        oneArrayThreeStack.push(10,2);
        oneArrayThreeStack.push(11,2);
        oneArrayThreeStack.pop(1);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(3);
        oneArrayThreeStack.pop(1);
        oneArrayThreeStack.push(1,1);
        oneArrayThreeStack.push(2,2);
        oneArrayThreeStack.push(3,3);
        oneArrayThreeStack.push(4,1);
        oneArrayThreeStack.push(5,2);
        oneArrayThreeStack.push(6,3);
        oneArrayThreeStack.push(7,2);
        oneArrayThreeStack.push(8,1);
        oneArrayThreeStack.pop(1);
        oneArrayThreeStack.pop(1);
        oneArrayThreeStack.pop(1);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(2);
        oneArrayThreeStack.pop(3);
        oneArrayThreeStack.pop(3);
        oneArrayThreeStack.pop(3);
    }
}