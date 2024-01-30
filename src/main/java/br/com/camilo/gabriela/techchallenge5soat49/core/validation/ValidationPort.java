package br.com.camilo.gabriela.techchallenge5soat49.core.validation;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.PersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;

import java.util.Optional;

public interface ValidationPort<D extends BaseDomain, P extends PersistencePort> {

    default D mustExist(Optional<D> item, String fieldName) throws DataValidationException {
        return item.orElseThrow(() -> new DataValidationException(fieldName));
    }

    default void mustNotExist(Optional<D> item, String fieldName) throws DataValidationException {
        item.ifPresent((domainItem) -> {
            throw new DataValidationException(fieldName);
        });
    }

    void validateCreationalBusinessRules(D domainItem, P persistencePort) throws DataValidationException;
    void validateUpdateBusinessRules(D updatedData, D persistedData, P persistencePort) throws DataValidationException;
}
