package daily;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private int id;

    public User() {

    }


    public User(String name, String password, int id) {
        super();
        this.name = name;
        this.password = password;
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", id=" + id + "]";
    }


}
