package com.shlomytr.open_legacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemModel {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amount;
    private  int inventoryCode;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(int inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", inventoryCode=" + inventoryCode +
                '}';
    }
}
