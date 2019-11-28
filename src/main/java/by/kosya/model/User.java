package by.kosya.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String password;
    private String login;
    private String phone;
    private Role role;

    public User(Integer id, String name, Integer age, String password, Role role, String login) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
        this.login = login;
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Role getRole() {
        return role;
    }
}
