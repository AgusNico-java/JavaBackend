package TechnicalInterview.demo.rest;

import TechnicalInterview.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import TechnicalInterview.demo.dao.TransactionRepository;
import TechnicalInterview.demo.entities.Transaction;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/transaction")
public class TransactionREST {
    
    private TransactionService transactionService;
    private TransactionRepository transactionRepository;
    
    @Autowired
    public TransactionREST(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }
    /*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Transaction> getTransactions(@RequestParam String brand, @RequestParam Float transactionImport){
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    */
    
    @RequestMapping(value = "getFee", method = RequestMethod.GET)
    public Float returnFee(@RequestParam(required = false) String brand, @RequestParam(required = false) Float transactionImport){
        return transactionService.totalFee(brand, transactionImport);
    }
            
    @PostMapping
    public ResponseEntity<Transaction> generateTransaction(@RequestBody Transaction transaction){
        Transaction newTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(newTransaction);
    }
    
}
