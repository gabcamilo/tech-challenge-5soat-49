package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductPersistencePort;

import java.util.HashMap;
import java.util.List;

public class OrderServicePortImpl implements OrderServicePort {

    private static final String ORDER = "Order";

    private final OrderPersistencePort persistencePort;
    private final OrderValidationPort validationPort;

    private final ProductPersistencePort productPersistencePort;

    private final CustomerPersistencePort customerPersistencePort;


    public OrderServicePortImpl(OrderPersistencePort persistencePort, OrderValidationPort validationPort, ProductPersistencePort productPersistencePort, CustomerPersistencePort customerPersistencePort) {
        this.persistencePort = persistencePort;
        this.validationPort = validationPort;
        this.productPersistencePort = productPersistencePort;
        this.customerPersistencePort = customerPersistencePort;
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

    @Override
    public Order createNewOrder(String customerCpf, String customerName, HashMap<String, Integer> products) throws DomainConstraintException {
        Order order = validationPort.validateData(customerCpf, products, productPersistencePort, customerPersistencePort);
        return persistencePort.save(order);
    }
}
