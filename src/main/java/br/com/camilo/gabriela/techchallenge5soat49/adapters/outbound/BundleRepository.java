package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle.Bundle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BundleRepository extends MongoRepository<Bundle, String> {
}
