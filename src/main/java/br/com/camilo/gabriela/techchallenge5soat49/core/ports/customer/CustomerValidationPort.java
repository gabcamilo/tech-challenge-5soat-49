package br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.ValidationPort;

public interface CustomerValidationPort extends ValidationPort<Customer, CustomerPersistencePort>{
    void validateUniqueCpf(String cpf, CustomerPersistencePort customerPersistencePort) throws DataValidationException;

    void validateUniqueEmail(String email, CustomerPersistencePort customerPersistencePort) throws DataValidationException;

    void validateCreationalBusinessRules(Customer customer, CustomerPersistencePort persistencePort) throws DataValidationException;
}
