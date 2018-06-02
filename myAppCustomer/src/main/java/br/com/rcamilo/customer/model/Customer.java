package br.com.rcamilo.customer.model;

import java.util.List;

public class Customer {

    private Integer customerId;
    private String customerDocument;
    private String customerName;
    private List<Account> accounts;

    public Customer(Integer customerId, String customerDocument, String customerName) {
        this.customerId = customerId;
        this.customerDocument = customerDocument;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerDocument='" + customerDocument + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(String customerDocument) {
        this.customerDocument = customerDocument;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
