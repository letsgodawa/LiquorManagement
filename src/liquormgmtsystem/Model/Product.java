/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquormgmtsystem.Model;

import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Product {
    String name;
    String distributors;
    int id;
    int quantity;
    LocalDate date;

    public Product() {
    }

    public Product(String name, String distributors, int id, int quantity, LocalDate date) {
        this.name = name;
        this.distributors = distributors;
        this.id = id;
        this.quantity = quantity;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistributors() {
        return distributors;
    }

    public void setDistributors(String distributors) {
        this.distributors = distributors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
    
}
