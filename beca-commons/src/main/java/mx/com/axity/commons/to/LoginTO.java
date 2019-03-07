package mx.com.axity.commons.to;

import java.io.Serializable;

public class LoginTO implements Serializable {

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getLastName() {
        return password;
    }

    public void setLastName(String lastName) {
        this.password = lastName;
    }
}
