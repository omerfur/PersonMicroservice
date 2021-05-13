package Hapoalim.SpringBootAssignment.entities;


import Hapoalim.SpringBootAssignment.entities.enums.Gender;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

    @MongoId
    @NotNull
    @Size(min = 3,max = 40)
    private String id;

    @NotNull
    @Size(min=3,max=20)
    private String name;

    @NotNull
    @Min(0)
    @Max(200)
    private int age;

    @NotNull
    private Gender gender;

    @NotNull
    @Min(0)
    private double hight;

    @Min(0)
    private double weight;

    @NotNull
    private Address address;

    public Person() {
    }

    public Person(String id, String name, int age, Gender gender, double hight, double weight, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hight = hight;
        this.weight = weight;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hight=" + hight +
                ", weight=" + weight +
                ", address=" + address +
                '}';
    }
}

