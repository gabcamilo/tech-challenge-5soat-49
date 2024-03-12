package br.com.camilo.gabriela.techchallenge5soat49.business.services;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerValidationPort;

import java.util.List;
import java.util.Optional;

public class CustomerServicePortImpl implements CustomerServicePort {

    private static final String CUSTOMER = "Customer";
    private static final String CPF = "CPF";

    private final CustomerPersistencePort persistencePort;
    private final CustomerValidationPort validationPort;

    public CustomerServicePortImpl(CustomerPersistencePort persistencePort, CustomerValidationPort customerValidationPort) {
        this.persistencePort = persistencePort;
        this.validationPort = customerValidationPort;
    }


    @Override
    public Customer create(Customer domain) throws DomainConstraintException {
        validationPort.validateCreationalBusinessRules(domain, persistencePort);
        return persistencePort.save(domain);
    }

    @Override
    public Customer update(Customer updatedData, Customer persistedData) throws DomainConstraintException {
        validationPort.validateUpdateBusinessRules(updatedData, persistedData, persistencePort);
        Customer update = persistedData.update(updatedData);
        return persistencePort.save(update);
    }


    @Override
    public Customer get(String id) throws DataValidationException {
        Optional<Customer> customer = persistencePort.get(id);
        customer.orElseThrow(() -> new DataValidationException("Customer not found"));
        return customer.get();
    }

    @Override
    public List<Customer> list() {
        return persistencePort.list();
    }

    @Override
    public Customer getCustomerByCpf(String cpf) throws DataValidationException {
        Optional<Customer> customer = persistencePort.getCustomerByCpf(cpf);
        customer.orElseThrow(() -> new DataValidationException("Customer not found"));
        return customer.get();
    }
}

