package ru.otus;


import java.util.Collections;
import java.util.ArrayList;
import ru.otus.annotations.*;

public class ArrayListTest {

    private ArrayList<String> mCatNames = new ArrayList<>();

    @Before
    public void beforeTest(){
        mCatNames.add ("Tom");
        mCatNames.add ("Merry");

    }

    @Test
    public void testTest1(){
        mCatNames.clear();
    }

    @Test
    public void testTest2(){
        System.out.println(mCatNames.get(1));
    }


    @Test
    public void testTest3(){
        mCatNames.get(5);
    }

    @After
    public void afterTest(){
        mCatNames.clear();
    }

    
}
