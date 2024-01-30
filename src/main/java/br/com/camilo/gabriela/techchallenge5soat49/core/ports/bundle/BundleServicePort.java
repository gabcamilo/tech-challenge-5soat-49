package br.com.camilo.gabriela.techchallenge5soat49.core.ports.bundle;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle.Bundle;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

public interface BundleServicePort extends ServicePort<Bundle, BundleValidationPort, BundlePersistencePort> {
}
