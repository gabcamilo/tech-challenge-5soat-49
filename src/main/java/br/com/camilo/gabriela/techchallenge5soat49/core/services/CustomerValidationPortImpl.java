package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerValidationPort;

public class CustomerValidationPortImpl implements CustomerValidationPort {
    @Override
    public void validateUniqueCpf(String cpf, CustomerPersistencePort customerPersistencePort) throws DataValidationException {
        mustNotExist(customerPersistencePort.getCustomerByCpf(cpf), "CPF");
    }

    @Override
    public void validateUniqueEmail(String email, CustomerPersistencePort customerPersistencePort) throws DataValidationException {
        mustNotExist(customerPersistencePort.getCustomerByEmail(email), "Email");
    }

    @Override
    public void validateCreationalBusinessRules(Customer customer, CustomerPersistencePort persistencePort) throws IllegalArgumentException {
        validateUniqueCpf(customer.getCpf(), persistencePort);
        validateUniqueEmail(customer.getEmail(), persistencePort);
    }

    @Override
    public void validateUpdateBusinessRules(Customer updatedData, Customer customer, CustomerPersistencePort persistencePort) throws IllegalArgumentException {
        if (!customer.getCpf().equals(updatedData.getCpf())) {
            throw new DataValidationException("CPF cannot be changed");
        }

        if (!customer.getEmail().equals(updatedData.getEmail())) {
            validateUniqueEmail(updatedData.getEmail(), persistencePort);
        }
    }
}
