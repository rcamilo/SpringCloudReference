package br.com.rcamilo.customer.api;

import br.com.rcamilo.customer.client.AccountClient;
import br.com.rcamilo.customer.model.Account;
import br.com.rcamilo.customer.model.Customer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private AccountClient accountClient;


    private List<Customer> customers;

    public CustomerController(){

        customers = new ArrayList<Customer>();
        customers.add( new Customer(1, "12345", "Leonardo"));
        customers.add( new Customer(2, "54321", "Rafael"));
        customers.add( new Customer(3, "67890", "Murilo"));
    }

    @RequestMapping("/customers/rcamilo/{customerName}")
    public Customer findByName(@PathVariable("customerName") String customerName){
        logger.info(String.format("Customer.customerByName(%s)",customerName));
        return customers.stream().filter(it -> it.getCustomerName().equals(customerName)).findFirst().get();
    }

    @RequestMapping("/customers")
    public List<Customer> findAll(){
        logger.info("Customer.findAll");
        return customers;
    }

    @RequestMapping("/customers/{id}")
    public Customer findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Customer.findById(%s)", id));
        Customer customer = customers.stream().filter(it -> it.getCustomerId().intValue()==id.intValue()).findFirst().get();
        logger.info(String.format("Call Service accountClient.getAccounts(%s) >>>>>", id));
        List<Account> accounts = accountClient.getAccounts(id);
        customer.setAccounts(accounts);
        return customer;
    }



}
