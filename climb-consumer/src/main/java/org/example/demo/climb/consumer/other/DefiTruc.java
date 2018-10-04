package org.example.demo.climb.consumer.other;

import java.util.Scanner;

public class DefiTruc {

    public static void main(String[] args) {


        int io=0;
        while( io==0){
            System.out.println("type a number: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            System.out.println(i);
            if(i % 2 ==0){
                System.out.println("even");
            }else{
                System.out.println("odd");
            }
        }
    }
}
