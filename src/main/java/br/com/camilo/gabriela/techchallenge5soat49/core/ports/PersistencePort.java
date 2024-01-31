package br.com.camilo.gabriela.techchallenge5soat49.core.ports;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;

import java.util.List;
import java.util.Optional;

public interface PersistencePort<T extends BaseDomain> {
    T save(T item);

    List<T> list();

    Optional<T> get(String id);

    T update(T item);
}
