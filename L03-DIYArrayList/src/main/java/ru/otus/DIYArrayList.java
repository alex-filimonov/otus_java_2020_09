package ru.otus;

import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Iterator;




public class DIYArrayList<E> implements List<E> {

//    private E[] values;
    private Object[] values;
    private int capaсity=10;
    private int length=0;

    public DIYArrayList(){
//      this.values = this.typeArray.cast(Array.newInstance(this.typeArray.getComponentType(), this.capaсity)); 
      this.values=new Object[this.capaсity];
    }

    private boolean setValueSize(int size){
      if (size>this.capaсity){
        this.capaсity=this.capaсity+(this.capaсity * 3) / 2 + 1;
          this.values=new Object[this.capaсity];
        return true;
      }
      return false;
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
    public Iterator<E> iterator() {
        return new DIYIterator();
    }

    private class DIYIterator implements Iterator<E> {
      private int index=0;
      @Override
      public boolean hasNext(){
        return index<DIYArrayList.this.length;
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next(){
        return (E)DIYArrayList.this.values[index++];
      }
    }
  
    @Override
    public Object[] toArray() {
      Object[] temp=new Object[this.length];
      System.arraycopy(this.values, 0, temp , 0, this.length);
      return temp;
    }
  
    @Override
    public <T> T[] toArray(T[] a) {
      throw new UnsupportedOperationException();
    }
  
    @Override
    public boolean add(E e) {
      //E[] temp=this.values;
      Object[] temp=this.values;
      if (this.setValueSize(this.length+1)==true){
          System.arraycopy(temp, 0, this.values, 0, this.length);
      }
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
        Object[] temp=this.values;
        this.setValueSize(this.length+c.size());
        System.arraycopy(temp, 0, this.values, 0, this.length);
        System.arraycopy(c.toArray(), 0, this.values, this.length, c.size());
        this.length=this.length+c.size();
        return true;
    }
  
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        //E[] temp=this.values;
        Object[] temp=this.values;
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

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
      return (E)this.values[index];
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
      return new DIYArrayListIterator();
    }
  
    @Override
    public ListIterator<E> listIterator(int index) {
      return new DIYArrayListIterator();
    }

    private class DIYArrayListIterator implements ListIterator<E> {

            private int index=0;
            
            private void rangeCheck(int index) {

                if (this.index >= DIYArrayList.this.length)
                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
                if (this.index<0)
                    throw new IndexOutOfBoundsException("index < 0");
            }
        
        
            private String outOfBoundsMsg(int index) {
                return "Index: "+this.index+", Size: "+DIYArrayList.this.length;
            }    
        
            @Override
            public boolean hasNext() {
                return index<DIYArrayList.this.length;
            }
        
            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                this.rangeCheck(index+1);
                return (E)DIYArrayList.this.values[index++];
            }
        
            @Override
            public boolean hasPrevious() {
                return index>0;
            }
        
            @SuppressWarnings("unchecked")
            @Override
            public E previous() {
                // TODO Auto-generated method stub
                this.rangeCheck(index-1);
                return (E)DIYArrayList.this.values[index--];
            }
        
            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }
        
            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }
        
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
        
            }
        
            @Override
            public void set(E e) {
              DIYArrayList.this.values[index-1]=e;
            }
        
            @Override
            public void add(E e) {
                throw new UnsupportedOperationException();
            }
    }


  
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }    
}
