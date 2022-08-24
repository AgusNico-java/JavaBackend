package javabackend.entities;

import java.util.Calendar;
import javabackend.enums.Brand;

/**
 * This entity class will contain the attributes for the Credit Cards, as well as
 * the methods that don´t require the application of logic.
 * @author Nico
 */
public class CreditCard {
    private Brand brand;
    private String number; //Despite it can be handled as a long int, the String class provides methods that will be helpfull for verification.
    private CardHolder cardHolder;
    private Calendar expirityDate;

    public CreditCard() {
    }

    public CreditCard(Brand brand, String number, CardHolder cardHolder, Calendar expirityDate) {
        this.brand = brand;
        this.number = number;
        this.cardHolder = cardHolder;
        this.expirityDate = expirityDate;
    }

    public Calendar getExpirityDate() {
        return expirityDate;
    }

    public void setExpirityDate(Calendar expirityDate) {
        this.expirityDate = expirityDate;
    }

        public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return "Credit Card data:\n"
                + "Brand: " + brand 
                + "\nNumber: " + number 
                + "\nName: " + cardHolder.getName() 
                + "\nLast name: " + cardHolder.getLastName()
                + "\nExpirity date: " + expirityDate.get(Calendar.MONTH) + "/" + expirityDate.get(Calendar.YEAR);
    }
    
    
}
