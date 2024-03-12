package br.com.camilo.gabriela.techchallenge5soat49.business.validation;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerValidationPort;

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
    public void validateCreationalBusinessRules(Customer customer, CustomerPersistencePort persistencePort) throws DataValidationException {
        validateUniqueCpf(customer.getCpf(), persistencePort);
        validateUniqueEmail(customer.getEmail(), persistencePort);
    }

    @Override
    public void validateUpdateBusinessRules(Customer updatedData, Customer customer, CustomerPersistencePort persistencePort) throws DataValidationException {
        if (!customer.getCpf().equals(updatedData.getCpf())) {
            throw new DataValidationException("CPF cannot be changed");
        }

        if (!customer.getEmail().equals(updatedData.getEmail())) {
            validateUniqueEmail(updatedData.getEmail(), persistencePort);
        }
    }
}
