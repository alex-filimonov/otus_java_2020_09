package ru.otus;

import java.util.Iterator;

public class DIYArrayIterator <T> implements Iterator<T> {

    private T[] objects;
    private int index=0;
    private int length;

    public DIYArrayIterator(T[] objects,int length){
        this.objects=objects;
        this.length=length;
    }

    @Override
    public boolean hasNext(){
        return index<this.length;
    }

    @Override
    public T next(){
        return objects[index++];
    }
    

}
