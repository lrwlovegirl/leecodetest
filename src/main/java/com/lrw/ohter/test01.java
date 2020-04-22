package com.lrw.ohter;

import java.util.Scanner;

public class test01 {

    public  static  int function(int []arr,int k){
        int n =arr.length;
        int index =1;
        if(arr[(n+1)/2]==k){
            return 0;
        }
        for (int i=0;i<=n;i++){
            if (arr[i]==k){
                index=i+1;
                break;
            }
        }
        while (index!=(n+1)/2){
            if (index<(n+1)/2){
                n++;
                index++;
            }else {
                n++;
            }
        }
        return n-arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ,k;
        n= sc.nextInt();
        k=sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(function(arr,k));
    }


}
