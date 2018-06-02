package br.com.rcamilo.customer.client;

import br.com.rcamilo.customer.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("account-service")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/customer/{customer}")
    List<Account> getAccounts(@PathVariable("customer") Integer customer);
}