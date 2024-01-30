package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle.Bundle;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.bundle.BundlePersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BundlePersistencePortImpl implements BundlePersistencePort {

    private final BundleRepository bundleRepository;

    public BundlePersistencePortImpl(BundleRepository bundleRepository) {
        this.bundleRepository = bundleRepository;
    }

    @Override
    public Bundle save(Bundle bundle) {
        return bundleRepository.save(bundle);
    }

    @Override
    public List<Bundle> list() {
        return bundleRepository.findAll();
    }

    @Override
    public Optional<Bundle> get(String id) {
        return bundleRepository.findById(id);
    }

    @Override
    public Bundle update(Bundle bundle) {
        return bundleRepository.save(bundle);
    }

}
