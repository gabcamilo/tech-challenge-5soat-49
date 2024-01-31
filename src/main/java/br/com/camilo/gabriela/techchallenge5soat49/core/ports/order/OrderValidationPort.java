package br.com.camilo.gabriela.techchallenge5soat49.core.ports.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.ValidationPort;

import java.util.HashMap;

public interface OrderValidationPort extends ValidationPort<Order, OrderPersistencePort> {

    Order validateData(String customerCpf, HashMap<String, Integer> products, ProductPersistencePort productPersistencePort, CustomerPersistencePort customerPersistencePort) throws DomainConstraintException;
}
