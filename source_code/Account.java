/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package foody;

/**
 *
 * @author lenovo
 */
public class Account {
    private String name;
    private String gender;
    private String job;
    private String username;
    private String email;
    private String password;
    private String photo;

    Account() {

    }

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    Account(String name, String gender, String job, String username, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.job = job;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public String[] getAll(){
        String[] account = {this.name, this.gender, this.job, this.username, this.email, this.password};
        return account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

