package com.omid.api.apitest;

class Person1{
    String name;
    String family;

    public Person1() {
    }

    public Person1(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}