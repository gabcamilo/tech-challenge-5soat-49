package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.validation.ValidationPort;

public interface CustomerValidationPort extends ValidationPort<Customer, CustomerPersistencePort>{
    void validateUniqueCpf(String cpf, CustomerPersistencePort customerPersistencePort) throws DataValidationException;

    void validateUniqueEmail(String email, CustomerPersistencePort customerPersistencePort) throws DataValidationException;

    void validateCreationalBusinessRules(Customer customer, CustomerPersistencePort persistencePort) throws DataValidationException;
}
