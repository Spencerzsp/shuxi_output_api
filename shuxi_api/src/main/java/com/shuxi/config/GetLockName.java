package com.shuxi.config;

public class GetLockName {

    public static void main(String[] args) {
        String lockName = getLockName("长洲");
        System.out.println(lockName);
    }

    public static String getLockName(String lockName){

        String test = "";
        String lockName1 = "贵港,长洲,大藤峡";
        String[] lockNames = lockName1.split(",");
        for (String name : lockNames) {
            if (
                    (lockName.equals("贵港")
                            || lockName.equals("长洲")
                            || lockName.equals("大藤峡")
                            || lockName.equals("桥巩")
                            || lockName.equals("桂平")
                            || lockName.equals("金鸡")
                            || lockName.equals("鱼梁")
                            || lockName.equals("那吉")
                            || lockName.equals("邕宁")
                            || lockName.equals("老口")
                            || lockName.equals("红花")
                            || lockName.equals("西津")) && lockName.equals(name)
            ){
                test = lockName + '-' + name;
            }
        }
        return test;
    }

}
