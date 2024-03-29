package com.bryan.mvc.pojo;

public class User {
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String email;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{"
            + "username='" + username + '\'' + ", password='" + password + '\'' + ", sex='" + sex
            + '\'' + ", age=" + age + ", email='" + email + '\'' + '}';
    }
}
