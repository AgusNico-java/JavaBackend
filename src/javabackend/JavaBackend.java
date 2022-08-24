package javabackend;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javabackend.entities.CardHolder;
import javabackend.entities.CreditCard;
import javabackend.services.CardService;

public class JavaBackend {
    public static void main(String[] args) {
        
        //Creates 3 CardHolder instances (Notar que se trata de nombres ficticios)
        CardHolder user1 = new CardHolder("Juan", "Perez");
        CardHolder user2 = new CardHolder("Pedro", "Picapiedra");
        CardHolder user3 = new CardHolder("Homero", "Simpson");
        
        //Create an instance of the CardService that will implement the logic needed for the credit card.
        CardService cardService = new CardService();
        
        //Creates 3 Date instances
        //Date date1 = new Date();
        Calendar date1 = new GregorianCalendar(2023, 03, 18, 0, 0, 0);
        Calendar date2 = new GregorianCalendar(2022, 07, 20, 0, 0, 0);
        Calendar date3 = new GregorianCalendar(2025, 04, 25, 0, 0, 0);
        
        //Creates 3 CreditCard instances
        CreditCard credit1 = new CreditCard ("VISA", "1234 5678 9101 1121", user1 , date1);
        CreditCard credit2 = new CreditCard ("NARA", "1234 5678 9101 1122", user2, date2);
        CreditCard credit3 = new CreditCard ("AMEX", "1234 5678 9101 1123", user3, date3);
        
        //Shows the information of the first Card
        System.out.println(credit1.toString());
        
        //Make and verify a transaction
        //cardService.makeTransaction();
        
        //Verify if a Credit card is operative.
        cardService.validityInform(credit3);
    }
    
}
