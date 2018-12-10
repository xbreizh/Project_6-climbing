package org.example.demo.climb.webapp.action;

import org.apache.commons.lang3.EnumUtils;
import org.example.demo.climb.model.Grade;

import java.awt.*;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {


        boolean answer=false;
        while(1!=0) {
            System.out.println("Enter a value:");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            answer = EnumUtils.isValidEnum(Grade.class, str);
            for (Grade g : Grade.values()) {
                System.out.println(Grade.values()[Integer.parseInt(str)].getValue());
               /* if(g.getValue().equals(str)){
                    answer=true;
                    break;
                }*/
            }
        }
           /*  if(answer){
            System.out.println(str+" is valid");
        }else{
                 System.out.println(str+" is invalid");
             }
        }*/

    }
}