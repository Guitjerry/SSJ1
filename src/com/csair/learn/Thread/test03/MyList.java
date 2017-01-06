package com.csair.learn.Thread.test03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 17/1/3.
 */
public class MyList {
    private static List list =  new ArrayList();
    public static void add(){
        list.add("aa");
    }
    public static int size(){
        return list.size();
    }
}
