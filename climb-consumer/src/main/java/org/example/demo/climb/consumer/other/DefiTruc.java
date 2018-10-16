package org.example.demo.climb.consumer.other;

import org.example.demo.climb.consumer.config.HibernateConf;
import org.hibernate.Session;

import java.util.List;

public class DefiTruc {


    public static void main(String[] args) {
        String s = "proco";
       if(s.equals("procol")){
           System.out.println("found1");
       }
        if(s.equals("procols")){
            System.out.println("found2");
        }
        if(s.equals("procole")){
            System.out.println("found3");
        }
        if(s.equals("proco")){
            System.out.println("found4");
        }
    }
}
