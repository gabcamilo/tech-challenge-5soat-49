package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerValidationPort;

import java.util.List;

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
    public Customer update(Customer domain, String id) throws DomainConstraintException {
        return null;
    }

    @Override
    public Customer get(String id) throws DataValidationException {
        return null;
    }

    @Override
    public void delete(String id) throws DataValidationException {

    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Customer getCustomerByCpf(String cpf) throws DataValidationException {
        return null;
    }
}

