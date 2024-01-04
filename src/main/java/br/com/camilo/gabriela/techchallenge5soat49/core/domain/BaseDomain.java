package br.com.camilo.gabriela.techchallenge5soat49.core.domain;

import java.time.LocalDateTime;

public abstract class BaseDomain implements Domain {

    private final String id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    protected BaseDomain(String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}
