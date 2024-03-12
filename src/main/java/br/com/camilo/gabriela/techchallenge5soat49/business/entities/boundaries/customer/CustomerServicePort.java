package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.ServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;

public interface CustomerServicePort extends ServicePort<Customer, CustomerValidationPort, CustomerPersistencePort> {
    Customer getCustomerByCpf(String cpf) throws DataValidationException;
}
