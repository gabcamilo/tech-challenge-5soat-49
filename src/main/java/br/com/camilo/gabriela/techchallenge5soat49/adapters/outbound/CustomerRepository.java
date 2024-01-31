package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;


import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}
