package org.example.demo.climb.model;

public enum ClimbingType {
    RockClimb("RockClimb"),Boulder ("Boulder");

    private String name;

    private ClimbingType(String name){
        this.name=name;
    }


    public String getName(){
        return name;
    }
}
