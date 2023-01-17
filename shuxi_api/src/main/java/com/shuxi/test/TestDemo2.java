package com.shuxi.test;

public class TestDemo2 {
    public static void main(String[] args) {
        //定义数组并初始化
        int[] arr=new int[]{12,20,7,-3,0};
        int max=arr[0];//将数组的第一个元素赋给max
        int min=arr[0];//将数组的第一个元素赋给min
        for(int i=1;i<arr.length;i++){//从数组的第二个元素开始赋值，依次比较
            if(arr[i]>max){//如果arr[i]大于最大值，就将arr[i]赋给最大值
                max=arr[i];
            }
            if(arr[i]<min){//如果arr[i]小于最小值，就将arr[i]赋给最小值
                min=arr[i];
            }
        }
        System.out.println("最大值是:"+max);
        System.out.println("最小值是:"+min);
    }
}
