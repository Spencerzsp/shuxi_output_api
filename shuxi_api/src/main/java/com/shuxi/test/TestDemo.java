package com.shuxi.test;

import org.json.JSONArray;

import java.util.ArrayList;

public class TestDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(20);
        list.add(7);
        list.add(-3);
        list.add(2);
        list.add(32);

        // 1、求最大最小值
        Integer max = list.get(0);
        Integer min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max){
                max = list.get(i);
            }
            if (list.get(i) < min){
                min = list.get(i);
            }
        }

        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        jsonArray.put("年月");
        jsonArray.put("上行货物");
        jsonArray.put("下行货物");
        jsonArray.put("最大值");
        jsonArray.put("最小值");

        jsonArray1.put(jsonArray);

        for (Integer lis : list) {
            JSONArray jsonArray3 = new JSONArray();
            jsonArray3.put(lis);
            jsonArray3.put(max.toString());
            jsonArray3.put(min.toString());

            jsonArray1.put(jsonArray3);
        }


        String a = "0.9410000000000001";
        Double anInt = Double.parseDouble(a);
        System.out.println(anInt);

//        System.out.println(jsonArray1);
    }
}
