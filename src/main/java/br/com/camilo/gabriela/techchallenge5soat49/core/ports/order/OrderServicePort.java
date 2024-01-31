package br.com.camilo.gabriela.techchallenge5soat49.core.ports.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

import java.util.HashMap;

public interface OrderServicePort extends ServicePort<Order, OrderValidationPort, OrderPersistencePort> {

    Order createNewOrder(String customerCpf, String customerName, HashMap<String, Integer> products) throws DomainConstraintException;
}
