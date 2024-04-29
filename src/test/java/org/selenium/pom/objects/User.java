package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class User {


     String userName;
    String password;

    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

//    public User(String userName) throws IOException {
//        User user=JacksonUtils.deserializeJson("user.json",User.class);
//        if (user.getUserName()==userName){
//            this.userName=userName;
//            this.password=getPassword();
//        }
//    }

    public User() throws IOException {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
