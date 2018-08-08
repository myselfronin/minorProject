
package Cashier;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



public class bill_table 
{
    private SimpleStringProperty billName;
    private SimpleIntegerProperty billSN,billQuantity,billRate,billAmount,billPid;
    private LocalDate billexp;

    public bill_table(Integer billSN,Integer billPid,String billName,Integer billQuantity,Integer billRate,Integer billAmount,LocalDate billexp) 
    {
        this.billName = new SimpleStringProperty(billName);
        this.billPid= new SimpleIntegerProperty(billPid);
        this.billSN = new SimpleIntegerProperty(billSN);
        this.billQuantity = new SimpleIntegerProperty(billQuantity);
        this.billRate =  new SimpleIntegerProperty(billRate);
        this.billAmount =  new SimpleIntegerProperty(billAmount);
        this.billexp= billexp;
    }

    public int getBillPid() {
        return billPid.get();
    }

    public String getBillName() {
        return billName.get();
    }

    public int getBillSN() {
        return billSN.get();
    }

   

    public int getBillQuantity() {
        return billQuantity.get();
    }

    public LocalDate getBillexp() {
        return billexp;
    }

   

    public int getBillRate() {
        return billRate.get();
    }

    public int getBillAmount() {
        return billAmount.get();
    }
     
    
    public void setBillexp(LocalDate billexp) {
        this.billexp = billexp;
    }

    public void setBillName(SimpleStringProperty billName) {
        this.billName = billName;
    }

    public void setBillPid(SimpleIntegerProperty billPid) {
        this.billPid = billPid;
    }
    
    public void setBillSN(SimpleIntegerProperty billSN) {
        this.billSN = billSN;
    }

    public void setBillQuantity(SimpleIntegerProperty billQuantity) {
        this.billQuantity = billQuantity;
    }

    public void setBillRate(SimpleIntegerProperty billRate) {
        this.billRate = billRate;
    }

    public void setBillAmount(SimpleIntegerProperty billAmount) {
        this.billAmount = billAmount;
    }
    
    
    
    
}
