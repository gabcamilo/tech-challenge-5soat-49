package br.com.camilo.gabriela.techchallenge5soat49.core.ports.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.ValidationPort;

public interface OrderValidationPort extends ValidationPort<Order, OrderPersistencePort> {
}
