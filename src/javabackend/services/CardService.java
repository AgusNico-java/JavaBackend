package javabackend.services;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import javabackend.entities.CreditCard;

/**
 * This class will contain the algorithms that will handle the cards entities
 * @author Nico
 */
public class CardService {
    final int MAX = 1000;
    Scanner read = new Scanner(System.in);
    
    /**
     * Implements a method that makes and verifies a transaction
     */
    public void makeTransaction(){
        System.out.println("Ingrese el monto de la operación: ");
        try {
            int transaction = read.nextInt();
            if (verifyTransaction(transaction)) {
                System.out.println("Operación realizada con éxito");
            } else{
                System.out.println("Una operación no puede alcanzar los $" + MAX );
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Implement a method that determines if a transaction is valid.
     * @param transaction
     * @return 
     */
    private boolean verifyTransaction(int transaction){
        if(transaction < 1000){
            return true;
        }
        return false;
    }
    /**
     * Informs to the user if the card is (or is not) valid to operate
     * @param creditCard 
     */
    public void validityInform(CreditCard creditCard){
        if (operativeCard(creditCard)) {
            System.out.println("La tarjeta es válida para operar.");
        } else {
            System.out.println("La tarjeta no es válida para operar");
        }
    }
    /**
     * Implement a method that determines if the credit card is valid to make an operation
     * @param creditCard
     * @return 
     */
    private boolean operativeCard(CreditCard creditCard){
        Calendar today = Calendar.getInstance();
        if(creditCard.getExpirityDate().after(today)){
            return true;
        }
        return false;
    }
    
    /**
     * I make the assumption that is possible for two cards to have the same
     * CardHolder, expirity date and brand. So, the only way to determine
     * if two cards are different, is based on their numbers, so I compare them.
     * 
     * @param card1
     * @param card2
     * @return 
     */
    public boolean differentCards (CreditCard card1, CreditCard card2){
        if (card1.getNumber().equals(card2.getNumber())) {
            System.out.println("The cards are the same.");
            return true;
        } else{
            System.out.println("The cards are different.");
            return false;
        }
    }
}
