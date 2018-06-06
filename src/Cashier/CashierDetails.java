/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cashier;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rabinson
 */
public class CashierDetails {
    private SimpleStringProperty s_No,name,username,address,contact_no,gender;
    private LocalDate dob;

    public CashierDetails(String s_No, String name, String username, String address, String contact_no, String gender, LocalDate dob) {
        this.s_No = new SimpleStringProperty(s_No);
        this.name =  new SimpleStringProperty(name);
        this.username =  new SimpleStringProperty(username);
        this.address =  new SimpleStringProperty(address);
        this.contact_no =  new SimpleStringProperty(contact_no);
        this.gender =  new SimpleStringProperty(gender);
        this.dob = dob;
    }

    public SimpleStringProperty getS_No() {
        return s_No;
    }

    public void setS_No(SimpleStringProperty s_No) {
        this.s_No = s_No;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleStringProperty getUsername() {
        return username;
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public SimpleStringProperty getAddress() {
        return address;
    }

    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    public SimpleStringProperty getContact_no() {
        return contact_no;
    }

    public void setContact_no(SimpleStringProperty contact_no) {
        this.contact_no = contact_no;
    }

    public SimpleStringProperty getGender() {
        return gender;
    }

    public void setGender(SimpleStringProperty gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    
    
}
