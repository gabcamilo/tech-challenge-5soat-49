package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderValidationPort;


public class OrderValidationPortImpl implements OrderValidationPort {
    @Override
    public void validateCreationalBusinessRules(Order domainItem, OrderPersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public void validateUpdateBusinessRules(Order updatedData, Order persistedData, OrderPersistencePort persistencePort) throws DataValidationException {

    }
}
