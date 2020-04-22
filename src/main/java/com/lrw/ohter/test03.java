package com.lrw.ohter;

import java.util.Arrays;
import java.util.Scanner;

public class test03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        int n  = Integer.parseInt(nextLine.split(" ")[0]);
        int k  = Integer.parseInt(nextLine.split(" ")[1]);
        nextLine = sc.nextLine();
        int [] get = new int[n];
        String [] getString  =nextLine.split(" ");
        for (int j=0;j<n;j++){
            get[j] = Integer.parseInt(getString[j]);
        }
        Arrays.sort(get);
        int first = n*n/k-1;
        int second = n*n%k-1;
        System.out.println("("+get[first]+","+get[second]+")");
    }
}
