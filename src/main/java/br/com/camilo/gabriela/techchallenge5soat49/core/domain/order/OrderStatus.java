package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

public enum OrderStatus {
    COOKING(true),
    READY(true),
    DELIVERED(false),
    PENDING(true),
    CANCELED(false);

    private final Boolean isActiveOrder;

    OrderStatus(Boolean isActiveOrder) {
        this.isActiveOrder = isActiveOrder;
    }
}
