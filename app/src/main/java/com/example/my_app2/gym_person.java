package com.example.my_app2;

public class gym_person {
    private int noOfPerson;
    private double length;
    private double wt;
    private String age;
    private String gender;
    private String day,machine;


    public gym_person() {
    }

    public gym_person(int noOfPerson, double length, double wt, String age, String gender, String day, String machine) {
        this.noOfPerson = noOfPerson;
        this.length = length;
        this.wt = wt;
        this.age = age;
        this.gender = gender;
        this.day = day;
        this.machine = machine;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWt() {
        return wt;
    }

    public void setWt(double wt) {
        this.wt = wt;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return "gym_person{" +
                "noOfPerson=" + noOfPerson +
                ", length=" + length +
                ", wt=" + wt +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", day='" + day + '\'' +
                ", machine='" + machine + '\'' +
                '}';
    }
}
