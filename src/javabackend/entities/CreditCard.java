package javabackend.entities;

import java.util.Date;

/**
 * This entity class will contain the attributes for the Credit Cards, as well as
 * the methods that don´t require the application of logic.
 * @author Nico
 */
public class CreditCard {
    private String brand;
    private String number; //Despite it can be handled as a long int, the String class provides methods that will be helpfull for verification.
    private CardHolder cardHolder;
    private Date expirityDate;

    public CreditCard() {
    }

    public CreditCard(String brand, String number, CardHolder cardHolder, Date expirityDate) {
        this.brand = brand;
        this.number = number;
        this.cardHolder = cardHolder;
        this.expirityDate = expirityDate;
    }

    public Date getExpirityDate() {
        return expirityDate;
    }

    public void setExpirityDate(Date expirityDate) {
        this.expirityDate = expirityDate;
    }

        public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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
                + "\nCardHolder name: " + cardHolder.getName() 
                + "\nCardHolder last name" + cardHolder.getLastName()
                + "\nExpirity date: " + expirityDate;
    }
    
    
}
