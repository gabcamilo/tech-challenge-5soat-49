package br.com.camilo.gabriela.techchallenge5soat49.core.domain;

import java.time.LocalDateTime;

public interface Domain {
    String getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();
}
