package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
