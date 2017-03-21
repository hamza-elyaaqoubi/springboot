package fr.ws.bean;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int age;
    private String vsaCountry;
    private Set<String> cancelCountries = new HashSet<String>();

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, int age, String vsaCountry, Set<String> cancelCountries) {
        this(id);
        this.name = name;
        this.age = age;
        this.vsaCountry = vsaCountry;
        this.cancelCountries.addAll(cancelCountries);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getVsaCountry() {
        return vsaCountry;
    }

    public void setVsaCountry(String vsaCountry) {
        this.vsaCountry = vsaCountry;
    }

    public Set<String> getCancelCountries() {
        return cancelCountries;
    }

    public void setCancelCountries(Set<String> cancelCountries) {
        this.cancelCountries = cancelCountries;
    }
}
