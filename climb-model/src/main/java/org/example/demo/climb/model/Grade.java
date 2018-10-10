package org.example.demo.climb.model;

public enum Grade {
    G1(" 1"),G2(" 2"),G3(" 3"),G4("4a"),G5("4b"),G6("4c"),G7("5a"),G8("5b"),G9("5c"),G10("6a"),
    G11("6a+"),G12("6b"),G13("6b+"),G14("6c"),G15("6c+"),G16("7a"),G17("7a+"),G18("7b"),G19("7b+"),
    G20("7c"),G21("7c+"),G22("8a"),G23("8a+"),G24("8b"),G25("8b+"),G26("8c"),G27("8c+"),G28("9a"),
    G29("9a+"),G30("9b"),G31("9b+"),G32("9c");
    private String value;

    private Grade(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
