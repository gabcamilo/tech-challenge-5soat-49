package br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

public interface CustomerServicePort extends ServicePort<Customer, CustomerValidationPort, CustomerPersistencePort> {
    Customer getCustomerByCpf(String cpf) throws DataValidationException;
}
