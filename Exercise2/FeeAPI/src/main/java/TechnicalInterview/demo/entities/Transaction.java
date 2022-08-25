package TechnicalInterview.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String cardBrand;
    private Float transactionImport;
    private Float transactionFee;
    
}
