package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order.Order;

public interface PaymentServicePort {
    Order pay(Order order);
}
