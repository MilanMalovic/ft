package model;

public class User {

    private long id;
    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;


    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setId(long id) {
        this.id = id;
    }


}
