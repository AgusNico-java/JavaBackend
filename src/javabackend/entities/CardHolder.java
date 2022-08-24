package javabackend.entities;

/**
 * This entity class will contain the attributes for the card holder,
 * as well as the methods that don´t require the application of logic.
 * @author Nico
 */
public class CardHolder {
    private String name;
    private String lastName;

    public CardHolder() {
    }

    public CardHolder(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
