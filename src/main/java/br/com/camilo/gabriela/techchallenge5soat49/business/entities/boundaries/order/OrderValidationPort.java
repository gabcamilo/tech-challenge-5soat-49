package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.order;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.validation.ValidationPort;

import java.util.HashMap;

public interface OrderValidationPort extends ValidationPort<Order, OrderPersistencePort> {

    Order validateData(String customerCpf, HashMap<String, Integer> products, ProductPersistencePort productPersistencePort, CustomerPersistencePort customerPersistencePort) throws DomainConstraintException;
}
