package br.com.camilo.gabriela.techchallenge5soat49.configs.database;


import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}
