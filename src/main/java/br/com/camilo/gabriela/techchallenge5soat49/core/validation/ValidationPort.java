package br.com.camilo.gabriela.techchallenge5soat49.core.validation;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.PersistencePort;

import java.util.Optional;

public interface ValidationPort<D extends BaseDomain, P extends PersistencePort> {

    default D mustExist(Optional<D> item, String fieldName) throws IllegalArgumentException {
        return item.orElseThrow(() -> new IllegalArgumentException(fieldName));
    }

    default void mustNotExist(Optional<D> item, String fieldName) throws IllegalArgumentException {
        item.ifPresent((domainItem) -> {
            throw new IllegalArgumentException(fieldName);
        });
    }

    void validateCreationalBusinessRules(D domainItem, P persistencePort) throws IllegalArgumentException;
    void validateUpdateBusinessRules(D updatedData, D domainData, P persistencePort) throws IllegalArgumentException;
}
