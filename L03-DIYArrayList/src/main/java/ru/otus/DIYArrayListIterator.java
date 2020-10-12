package ru.otus;

import java.util.ListIterator;

public  class DIYArrayListIterator <T>  implements ListIterator<T> {

    private T[] objects;
    private int index=0;
    private int length;


    public DIYArrayListIterator(T[] objects,int length,int index){
        this.objects=objects;
        this.length=length;
        this.index=index;
    }

    
    private void rangeCheck(int index) {
        if (this.index >= this.length)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if (this.index<0)
            throw new IndexOutOfBoundsException("index < 0");
    }


    private String outOfBoundsMsg(int index) {
        return "Index: "+this.index+", Size: "+this.length;
    }    

    @Override
    public boolean hasNext() {
        return index<this.length;
    }

    @Override
    public T next() {
        this.rangeCheck(index+1);
        return objects[index++];
    }

    @Override
    public boolean hasPrevious() {
        return index>0;
    }

    @Override
    public T previous() {
        // TODO Auto-generated method stub
        this.rangeCheck(index-1);
        return objects[index--];
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
        // TODO Auto-generated method stub
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
        // TODO Auto-generated method stub
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    @Override
    public void set(T e) {
        objects[index-1]=e;

    }

    @Override
    public void add(T e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    
}
