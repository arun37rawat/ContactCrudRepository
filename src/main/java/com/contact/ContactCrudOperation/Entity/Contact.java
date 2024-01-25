package com.contact.ContactCrudOperation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String number;
    private String city;

    public Contact(String name, String number, String city) {
        this.name = name;
        this.number = number;
        this.city = city;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
