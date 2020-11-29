package ru.otus;

import  java.lang.System;


class Benchmark implements BenchmarkMBean {
    private final int loopCounter;
    private volatile int size = 0;
    private Object[] noneDeleteArray=new Object[0]; 
    private int countNoneDeteleteArray=0;
    private double koeficientDelete=0.2;

    public Benchmark(int loopCounter) {
        this.loopCounter = loopCounter;
    }

    public void run() throws InterruptedException {
        for (int idx = 0; idx < loopCounter; idx++) {
            int local = size;
            Object[] array = new Object[local];

            this.increaseArray(local);

            for (int i = 0; i < local; i++) {
                array[i] = new String(new char[0]);
                this.noneDeleteArray[i+this.countNoneDeteleteArray]=new String(new char[0]);
            }
            this.decreaseArray(local);
            Thread.sleep(10); //Label_1
        }
    }


    private void increaseArray(int local){
        Object[] temp=this.noneDeleteArray;
        this.noneDeleteArray=new Object[this.countNoneDeteleteArray+local];
        System.arraycopy(temp,0,this.noneDeleteArray,0,temp.length);
    }

    private void decreaseArray(int local){
        Object[] temp=this.noneDeleteArray;
        int countDeltaDelete=(int)(local*this.koeficientDelete);
        temp=this.noneDeleteArray;
        this.noneDeleteArray=new Object[this.countNoneDeteleteArray+local-countDeltaDelete];
        System.arraycopy(temp,0,this.noneDeleteArray,0,temp.length-countDeltaDelete);
        this.countNoneDeteleteArray+=(local-countDeltaDelete);
    
    }

    public int getElementCounterAdd() {
        return countNoneDeteleteArray;
    } 

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }
}