package ru.otus;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import ru.otus.annotations.*;
import ru.otus.reflection.*;


public class DIYTestUnit {

    private ArrayList<String> beforeMethodsName=new ArrayList<>();
    private ArrayList<String> afterMethodsName=new ArrayList<>();

    private int count_test=0;
    private int count_test_ok=0;
    private int count_test_error=0;

    public DIYTestUnit(){
        this.beforeMethodsName.clear();
        this.afterMethodsName.clear();
    }

    public void run(String className){
        this.count_test=0;
        this.count_test_ok=0;
        this.count_test_error=0;
        this.findBeforAfterMethodNames(className);
        try{
            Class<?> testClass = Class.forName(className);
            System.out.println("Run tests.....");
            System.out.println("---------------------------------------------------");
            for (Method method:testClass.getDeclaredMethods()){
                for (Annotation annotation:method.getDeclaredAnnotations()){
                    if (annotation instanceof ru.otus.annotations.Test){

                        Object instance=ReflectionHelper.instantiate(testClass);
                        this.count_test++;
                        System.out.print(method.getName());
                        try{
                            this.run_before_methods(instance);
                            ReflectionHelper.callMethod(instance,method.getName());
                            this.run_after_methods(instance);
                            this.count_test_ok++;
                            System.out.println("...OK");
                        } catch (Exception e) {
                            this.count_test_error++;
                            System.out.println("...ERROR");
                        }

                    }
                }
            }


        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        this.print_statistic();
    }

    public void print_statistic(){
        System.out.println("---------------------------------------------------");
        System.out.println("Test statistic");
        System.out.println("Test count: "+String.valueOf(count_test));
        System.out.println("Test successfully count: "+String.valueOf(count_test_ok));
        System.out.println("Test failed count: "+String.valueOf(count_test_error));
        System.out.println("---------------------------------------------------");
    }

    private void run_before_methods(Object instance){
        for (String method_name:this.beforeMethodsName){
            ReflectionHelper.callMethod(instance,method_name);
        }
    }

    private void run_after_methods(Object instance){
        for (String method_name:this.afterMethodsName){
            ReflectionHelper.callMethod(instance,method_name);
        }
    }


    private void findBeforAfterMethodNames(String className){
        try{
            Class<?> testClass = Class.forName(className);
            for (Method method:testClass.getDeclaredMethods()){
                for (Annotation annotation:method.getDeclaredAnnotations()){
                    if (annotation instanceof ru.otus.annotations.Before){
                        this.beforeMethodsName.add(method.getName());
                    }
                    if (annotation instanceof ru.otus.annotations.After){
                        this.afterMethodsName.add(method.getName());
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }

    }



}
