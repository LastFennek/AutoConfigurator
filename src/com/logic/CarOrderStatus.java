package com.logic;
import com.IO.DB;
import java.util.HashSet;

public class CarOrderStatus {
    private String plattform;
    private HashSet<String> packages = new HashSet<>();
    private DB usedPricesDB;
    private CalculateCost calcPrice = new CalculateCost();
    private CalculateTime calcTime = new CalculateTime();

    public CarOrderStatus(DB DB){
        this.usedPricesDB = DB;
    }

    public int getPrice(){
        return calcPrice.calcPrice(this);
    }

    public int getNewPackagePrice(String pack){
        return calcPrice.calcPrice(this, pack);
    }

    public int getTime(){
        return calcTime.calcTime(this);
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