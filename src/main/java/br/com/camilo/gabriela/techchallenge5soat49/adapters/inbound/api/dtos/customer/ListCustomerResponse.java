package br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;

import java.io.Serializable;
import java.util.List;

public class ListCustomerResponse implements Serializable {
    private List<CustomerResponse> customers;

    public ListCustomerResponse(List<Customer> customers) {
        this.customers = customers.stream().map(CustomerResponse::new).toList();
    }

    public List<CustomerResponse> getCustomers() {
        return customers;
    }

}
