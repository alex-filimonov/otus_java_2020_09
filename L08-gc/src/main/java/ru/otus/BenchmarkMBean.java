package ru.otus;

public interface BenchmarkMBean {

  void run() throws InterruptedException;


  int getSize();

  int getElementCounterAdd();

  void setSize(int size);
}