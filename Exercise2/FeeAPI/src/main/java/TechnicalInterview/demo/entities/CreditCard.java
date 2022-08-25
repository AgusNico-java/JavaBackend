package TechnicalInterview.demo.entities;

import TechnicalInterview.demo.enums.Brand;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private Brand brand;
    @Id
    private String number; //Despite it can be handled as a long int, the String class provides methods that will be helpfull for verification.
    private String holderName;
    private String holderLastName;
    private Calendar expirityDate;
}
