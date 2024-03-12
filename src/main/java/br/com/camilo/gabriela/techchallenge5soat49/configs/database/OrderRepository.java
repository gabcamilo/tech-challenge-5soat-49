package br.com.camilo.gabriela.techchallenge5soat49.configs.database;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
