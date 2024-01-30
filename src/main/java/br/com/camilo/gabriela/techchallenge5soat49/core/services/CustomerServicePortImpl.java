package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerValidationPort;

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

