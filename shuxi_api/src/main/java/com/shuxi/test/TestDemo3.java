package com.shuxi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo3 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("CZ");
        list.add("DTX");
        list.add("QG");
        list.add("GP");

        List<String> ship_locks = Arrays.asList("GG"
                , "CZ"
                , "DTX"
                , "QG"
                , "GP"
                , "JJ"
                , "YL"
                , "NJ"
                , "YN"
                , "LK"
                , "HH"
                , "XJ"
        );

        for (String ship_lock : ship_locks) {
            if (!list.contains(ship_lock)) {
                System.out.println(ship_lock);
            }
        }

    }
}
