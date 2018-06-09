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
    private SimpleStringProperty SNo,Name,Username,Address,ContactNo,Gender,CreatedBy,CreatedAt;
    private LocalDate dob;

    public CashierDetails(String SNo, String Name, String Username, 
                          String Address, String ContactNo, String Gender,
                          String CreatedBy,String CreatedAt ,LocalDate dob) 
    {
        this.SNo = new SimpleStringProperty(SNo);
        this.Name =  new SimpleStringProperty(Name);
        this.Username =  new SimpleStringProperty(Username);
        this.Address =  new SimpleStringProperty(Address);
        this.ContactNo =  new SimpleStringProperty(ContactNo);
        this.Gender =  new SimpleStringProperty(Gender);
        this.CreatedBy =  new SimpleStringProperty(CreatedBy);
        this.CreatedAt =  new SimpleStringProperty(CreatedAt);
        this.dob = dob;
    }

    public String getSNo() {
        return SNo.get();
    }

    public void setSNo(SimpleStringProperty SNo) {
        this.SNo = SNo;
    }

    public String getName() {
        return Name.get();
    }

    public void setName(SimpleStringProperty Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return Username.get();
    }

    public void setUsername(SimpleStringProperty Username) {
        this.Username = Username;
    }

    public String getAddress() {
        return Address.get();
    }

    public void setAddress(SimpleStringProperty Address) {
        this.Address = Address;
    }

    public String getContactNo() {
        return ContactNo.get();
    }

    public void setContactNo(SimpleStringProperty ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getGender() {
        return Gender.get();
    }

    public void setGender(SimpleStringProperty Gender) {
        this.Gender = Gender;
    }

    public String getCreatedBy() {
        return CreatedBy.get();
    }

    public void setCreatedBy(SimpleStringProperty CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public String getCreatedAt() {
        return CreatedAt.get();
    }

    public void setCreatedAt(SimpleStringProperty CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    
    
}
