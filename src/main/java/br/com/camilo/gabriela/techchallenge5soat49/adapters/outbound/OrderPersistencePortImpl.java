package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderPersistencePortImpl implements OrderPersistencePort {
    @Override
    public Order save(Order item) {
        return null;
    }

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public Optional<Order> get(String id) {
        return Optional.empty();
    }

    @Override
    public Order update(Order item) {
        return null;
    }
}
