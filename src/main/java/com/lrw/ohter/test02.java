package com.lrw.ohter;

import java.util.Scanner;

public class test02 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String nextLine = sc.nextLine();
        int[] get  = new int[4];
        String[] getString = nextLine.split(" ");
        for (int i=0;i<4;i++){
            get[i] = Integer.parseInt(getString[i]);
        }
        int a = get[0],b=get[1],m=get[2],n=get[3];
        int init =4 ;
        int sum  = 1;
        fun(sum,a,b,m,init,n);
    }
   public  static  void fun(int sum,int a,int b, int m,int init ,int x) {
       if (init == (a * x + b) % x) {
           System.out.println(sum);
           return ;
       } else {
           sum++;
           x=(a*x+b)%x;
           fun(sum,a,b,m,init,x);
       }

   }

}
