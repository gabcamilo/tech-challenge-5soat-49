package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle.Bundle;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.bundle.BundlePersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.bundle.BundleServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.bundle.BundleValidationPort;

import java.util.List;

public class BundleServicePortImpl implements BundleServicePort {

    private static final String BUNDLE = "Bundle";

    private final BundlePersistencePort persistencePort;
    private final BundleValidationPort validationPort;

    public BundleServicePortImpl(BundlePersistencePort persistencePort, BundleValidationPort validationPort) {
        this.persistencePort = persistencePort;
        this.validationPort = validationPort;
    }


    @Override
    public Bundle create(Bundle domain) throws DomainConstraintException {
        validationPort.validateCreationalBusinessRules(domain, persistencePort);
        return persistencePort.save(domain);
    }

    @Override
    public Bundle update(Bundle updatedData, Bundle persistedData) throws DomainConstraintException {
        validationPort.validateUpdateBusinessRules(updatedData, persistedData, persistencePort);
        Bundle update = persistedData.update(updatedData);
        return persistencePort.update(update);
    }

    @Override
    public Bundle get(String id) throws DataValidationException {
        return persistencePort.get(id).orElseThrow(() -> new DataValidationException("Bundle not found"));
    }

    @Override
    public List<Bundle> list() {
        return persistencePort.list();
    }

}