package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderValidationPort;

import java.util.List;

public class OrderServicePortImpl implements OrderServicePort {

    private static final String ORDER = "Order";

    private final OrderPersistencePort persistencePort;
    private final OrderValidationPort validationPort;

    public OrderServicePortImpl(OrderPersistencePort persistencePort, OrderValidationPort validationPort) {
        this.persistencePort = persistencePort;
        this.validationPort = validationPort;
    }

    @Override
    public Order create(Order domain) throws DomainConstraintException {
        validationPort.validateCreationalBusinessRules(domain, persistencePort);
        return persistencePort.save(domain);
    }

    @Override
    public Order update(Order updatedData, Order persistedData) throws DomainConstraintException {
        validationPort.validateUpdateBusinessRules(updatedData, persistedData, persistencePort);
        Order update = persistedData.update(updatedData);
        return persistencePort.save(update);
    }

    @Override
    public Order get(String id) throws DataValidationException {
        return persistencePort.get(id).orElseThrow(() -> new DataValidationException("Order not found"));
    }

    @Override
    public List<Order> list() {
        return persistencePort.list();
    }
}
