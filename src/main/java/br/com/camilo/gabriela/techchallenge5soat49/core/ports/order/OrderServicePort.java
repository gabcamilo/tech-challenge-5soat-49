package br.com.camilo.gabriela.techchallenge5soat49.core.ports.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

public interface OrderServicePort extends ServicePort<Order, OrderValidationPort, OrderPersistencePort> {
}
