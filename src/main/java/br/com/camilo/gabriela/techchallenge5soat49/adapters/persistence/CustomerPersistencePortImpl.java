package br.com.camilo.gabriela.techchallenge5soat49.adapters.persistence;

import br.com.camilo.gabriela.techchallenge5soat49.configs.database.CustomerRepository;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerPersistencePortImpl implements CustomerPersistencePort {
    private final CustomerRepository customerRepository;

    public CustomerPersistencePortImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> get(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
