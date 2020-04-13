package javaexercise;

import java.util.function.Supplier;

public class Person {

    private String name;
    private String addr;
    private String phone;
    private String email;

    public Person() {

    }

    public Person(String name, String addr, String phone, String email) {
        super();
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
