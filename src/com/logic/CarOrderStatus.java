package com.logic;
import com.IO.DB;
import java.util.HashSet;

public class CarOrderStatus {
    private String plattform;
    private HashSet<String> packages = new HashSet<>();
    private DB usedPricesDB;
    private CalculateCost calc = new CalculateCost();

    public CarOrderStatus(DB DB){
        this.usedPricesDB = DB;
    }

    public int getPrice(){
        return calc.calcPrice(this);
    }

    public int getNewPackagePrice(String pack){
        return calc.calcPrice(this,pack);
    }

    String getPlattform() {
        return this.plattform;
    }

    HashSet<String> getPackages() {
        return this.packages;
    }

    DB getUsedPricesDB() {
        return this.usedPricesDB;
    }
}