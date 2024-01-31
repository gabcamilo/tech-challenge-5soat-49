package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductPersistencePort;

import java.util.HashMap;
import java.util.List;


public class OrderValidationPortImpl implements OrderValidationPort {
    @Override
    public void validateCreationalBusinessRules(Order domainItem, OrderPersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public void validateUpdateBusinessRules(Order updatedData, Order persistedData, OrderPersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public Order validateData(String customerCpf, HashMap<String, Integer> products, ProductPersistencePort productPersistencePort, CustomerPersistencePort customerPersistencePort) throws DomainConstraintException {
        List<String> productIds = products.keySet().stream().toList();
        List<Product> orderProducts = productPersistencePort.listProductsByIds(productIds);

        if (productIds.size() != orderProducts.size()) {
            throw new DataValidationException("There are invalid products in the order");
        }

        Customer customer = customerPersistencePort.get(customerCpf).orElseThrow(() -> new DataValidationException("Customer not found"));

        return Order.createNew(customer, orderProducts, products);
    }
}
