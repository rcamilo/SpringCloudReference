package br.com.rcamilo.app.api;

import br.com.rcamilo.app.model.Account;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccontController {

    private List<Account> accounts;

    protected Logger logger = Logger.getLogger(AccontController.class);

    public AccontController(){

        accounts = new ArrayList<>();
        accounts.add( new Account(1 , 1, "111"));
        accounts.add( new Account(2 , 2, "222"));
        accounts.add( new Account(3 , 3, "333"));
        accounts.add( new Account(4 , 4, "444"));
        accounts.add( new Account(5 , 5, "555"));
    }


    @RequestMapping("/accounts/{numero}")
    public Account findByNumber(@PathVariable("numero") String numero){
        logger.info(String.format("Account.findById (%s)", numero));
        return accounts.stream().filter(it -> it.getNumero().equals(numero)).findFirst().get();
    }

    @RequestMapping("/accounts/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") Integer customerId){
        logger.info(String.format("Account.findByCustomer (%s)",customerId));
        return accounts.stream().filter(it -> it.getId() == customerId).collect(Collectors.toList());
    }

    @RequestMapping("/accounts")
    public List<Account> findAll(){
        logger.info("Account.findAll");
        return accounts;
    }
}
