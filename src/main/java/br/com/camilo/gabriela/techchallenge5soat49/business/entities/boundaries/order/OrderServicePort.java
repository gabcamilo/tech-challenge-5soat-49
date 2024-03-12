package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.order;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.ServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;

import java.util.HashMap;

public interface OrderServicePort extends ServicePort<Order, OrderValidationPort, OrderPersistencePort> {

    Order createNewOrder(String customerCpf, String customerName, HashMap<String, Integer> products) throws DomainConstraintException;
}
