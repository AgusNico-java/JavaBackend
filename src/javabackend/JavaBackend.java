package javabackend;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javabackend.entities.CardHolder;
import javabackend.entities.CreditCard;
import static javabackend.enums.Brand.AMEX;
import static javabackend.enums.Brand.NARA;
import static javabackend.enums.Brand.VISA;
import javabackend.services.CardService;

public class JavaBackend {
    public static void main(String[] args) {
        Scanner readInt = new Scanner(System.in);
        Scanner readString = new Scanner(System.in);
        
        //Creates 3 CardHolder instances (Notar que se trata de nombres ficticios)
        CardHolder user1 = new CardHolder("Juan", "Perez");
        CardHolder user2 = new CardHolder("Pedro", "Picapiedra");
        CardHolder user3 = new CardHolder("Homero", "Simpson");
        
        //Create an instance of the CardService that will implement the logic needed for the credit card.
        CardService cardService = new CardService();
        
        //Creates 3 Date instances
        //Date date1 = new Date();
        Calendar date1 = new GregorianCalendar(2023, 03, 18);
        Calendar date2 = new GregorianCalendar(2022, 07, 20);
        Calendar date3 = new GregorianCalendar(2025, 04, 25);
        
        //Creates 3 CreditCard instances
        CreditCard credit1 = new CreditCard (VISA, "1234 5678 9101 1121", user1 , date1);
        CreditCard credit2 = new CreditCard (NARA, "1234 5678 9101 1122", user2, date2);
        CreditCard credit3 = new CreditCard (AMEX, "1234 5678 9101 1123", user3, date3);
        
        System.out.println("Seleccione una opción: "
                + "\n1. Obtener toda la info de una tarjeta."
                + "\n2. Decidir si una operación es válida."
                + "\n3. Decidir si una tarjeta es válida para operar."
                + "\n4. Identificar si una tarjeta es igual a otra(En base a su numero"
                + "\n5. Obtener la tasa de una operación mediante su marca y el importe.)"
                + "\n6. Salir");
        
        int option = readInt.nextInt();
        
        do {
            switch (option) {
            case 1:
                //Shows the information of the first Card
                System.out.println(credit1.toString());
                break;
            case 2:
                //Make and verify a transaction
                cardService.makeTransaction();
                break;
            case 3:
                //Verify if a Credit card is operative.
                cardService.validityInform(credit3);
                break;
            case 4:
                //Check if two cards are different
                cardService.differentCards(credit1, credit2);
                break;
            case 5:
                //Get the transaction fee
                System.out.println("Ingrese la marca de su tarjeta: ");
                String brand = readString.next();
                System.out.println("Ingrese el monto de la transacción: ");
                int transactionImport = readInt.nextInt();
                cardService.totalFee(brand, transactionImport);
                break;
            case 6:
                break;
            default:
                System.out.println("La opción ingresada es incorrecta.");
            }
        } while (option != 6);
    }
    
}
