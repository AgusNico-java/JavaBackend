package javabackend;

import java.util.Date;
import javabackend.entities.CardHolder;
import javabackend.entities.CreditCard;

public class JavaBackend {
    
    public static void main(String[] args) {
        
        //Creates 3 CardHolder instances (Notar que se trata de nombres ficticios)
        CardHolder user1 = new CardHolder("Juan", "Perez");
        CardHolder user2 = new CardHolder("Pedro", "Picapiedra");
        CardHolder user3 = new CardHolder("Homero", "Simpson");
        
        //Creates 3 Date instances
        Date date1 = new Date();
        Date date2 = new Date(25, 07, 122);
        Date date3 = new Date(07, 12, 125);
        
        //Creates 3 CreditCard instances
        CreditCard credit1 = new CreditCard ("VISA", "1234 5678 9101 1121", user1 , date1);
        CreditCard credit2 = new CreditCard ("NARA", "1234 5678 9101 1122", user2, date2);
        CreditCard credit3 = new CreditCard ("AMEX", "1234 5678 9101 1123", user3, date3);
        
        //Shows the information of the first Card
        System.out.println(credit1.toString());
    }
    
}
