package ru.otus;

import java.util.List;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ListIterator;


public class DIYArrayList<E> implements List<E> {

    private E[] values;
    private Class<E[]> typeArray;
    private int capaсity=3;
    private int length=0;

    public DIYArrayList(Class<E[]>typeArray){
      this.typeArray=typeArray;
      this.values = this.typeArray.cast(Array.newInstance(this.typeArray.getComponentType(), this.capaсity)); 
    }

// Плохой метод возможны ошибки 
//this.values=(E[]) new Object[0];

// метод лучше но блин нужен тип
// this.values = typeArray.cast(Array.newInstance(typeArray.getComponentType(), 0)); 
    private void setValueSize(int size){
      if (size>this.capaсity){
        this.capaсity=this.capaсity+(this.capaсity * 3) / 2 + 1;
        this.values = this.typeArray.cast(Array.newInstance(this.typeArray.getComponentType(), this.capaсity)); 
      }
    }



    @Override
    public int size() {
        return this.length;
    }
  
    @Override
    public boolean isEmpty() {
      if (this.length<1){
        return true;
      }
      return false;
    }
  
    @Override
    public boolean contains(Object o) {
      throw new UnsupportedOperationException();
    }
  
    @Override
    public DIYArrayIterator<E> iterator() {
        return new DIYArrayIterator<E>(this.values,this.length);
    }
  
    @Override
    public Object[] toArray() {
      E[] temp= this.typeArray.cast(Array.newInstance(this.typeArray.getComponentType(), this.length)); 
      System.arraycopy(this.values, 0, temp , 0, this.length);
      return temp;
    }
  
    @Override
    public <T> T[] toArray(T[] a) {
      return null;
    }
  
    @Override
    public boolean add(E e) {
        E[] temp=this.values;
        this.setValueSize(this.length+1);
        System.arraycopy(temp, 0, this.values, 0, this.length);
        this.values[this.length]=e;
        this.length++;
        return true;
    }
  
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
  
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
  
    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] temp=this.values;
//        this.values = this.typeArray.cast(Array.newInstance(this.typeArray.getComponentType(), temp.length+c.size())); 
        this.setValueSize(this.length+c.size());
        System.arraycopy(temp, 0, this.values, 0, this.length);
        System.arraycopy(c.toArray(), 0, this.values, this.length, c.size());
        this.length=this.length+c.size();
        return true;
    }
  
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        E[] temp=this.values;
        this.setValueSize(temp.length+c.size());
        System.arraycopy(temp, 0, this.values, 0, index);
        System.arraycopy(c.toArray(), 0, this.values, index, c.size());
        System.arraycopy(temp, index, this.values, index+c.size(), this.length-index);
        this.length=this.length+c.size();
        return true;
    }
  
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
  
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
  
    @Override
    public void clear() {
        this.length = 0; 
    }
  
    @Override
    public E get(int index) {
      return this.values[index];
    }
  
    @Override
    public E set(int index, E element) {
        this.values[index]=element;
        return null;
    }
  
    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }
  
    @Override
    public E remove(int index) {
      throw new UnsupportedOperationException();
    }
  
    @Override
    public int indexOf(Object o) {
      throw new UnsupportedOperationException();
    }
  
    @Override
    public int lastIndexOf(Object o) {
      throw new UnsupportedOperationException();
    }
  
    @Override
    public ListIterator<E> listIterator() {
        return new DIYArrayListIterator<E>(this.values,this.length,0);
    }
  
    @Override
    public ListIterator<E> listIterator(int index) {
      return new DIYArrayListIterator<E>(this.values,this.length,index);
    }
  
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }    
}
