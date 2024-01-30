package br.com.camilo.gabriela.techchallenge5soat49.core.ports;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;

public interface PaymentServicePort {
    Order pay(Order order);
}
