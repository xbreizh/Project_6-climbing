package org.example.demo.climb.model;

public enum ClimbingType {
    RockClimb("ROPECLIMB"),Boulder ("BOULDER");

    private String name;

    private ClimbingType(String name){
        this.name=name;
    }


    public String getName(){
        return name;
    }
}
