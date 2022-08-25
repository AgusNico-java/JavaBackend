package TechnicalInterview.demo.rest;

import TechnicalInterview.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import TechnicalInterview.demo.dao.TransactionRepository;

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
    
    /**
     * This method gets the brand and the transaction import from the url,
     * and return it to the navigator.
     * @param brand
     * @param transactionImport
     * @return 
     */
    @RequestMapping(value = "getFee", method = RequestMethod.GET)
    public String returnFee(@RequestParam(required = false) String brand, @RequestParam(required = false) Float transactionImport){
        return "Transaction fee: " + transactionService.totalFee(brand, transactionImport);
    }
    
}
