package br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.PersistencePort;

import java.util.Optional;

public interface CustomerPersistencePort extends PersistencePort<Customer> {
    Optional<Customer> getCustomerByCpf(String cpf);
    Optional<Customer> getCustomerByEmail(String email);
}
