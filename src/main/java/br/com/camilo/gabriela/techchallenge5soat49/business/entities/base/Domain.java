package br.com.camilo.gabriela.techchallenge5soat49.business.entities.base;

import java.time.LocalDateTime;

public interface Domain {
    String getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();
}
