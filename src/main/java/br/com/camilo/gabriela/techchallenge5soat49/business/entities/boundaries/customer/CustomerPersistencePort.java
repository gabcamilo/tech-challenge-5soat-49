package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.PersistencePort;

import java.util.Optional;

public interface CustomerPersistencePort extends PersistencePort<Customer> {
    Optional<Customer> getCustomerByCpf(String cpf);
    Optional<Customer> getCustomerByEmail(String email);
}
