package br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.controllers;

import br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos.ApiResponse;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos.order.CreateOrderRequest;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.order.Order;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/orders")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    private final OrderServicePort port;

    private static final String ENTITY = "order";

    public OrderController(OrderServicePort port, CustomerServicePort customerPort, ProductServicePort productPort) {
        this.port = port;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOrder(@RequestBody CreateOrderRequest request) throws Throwable {
        Order order = port.createNewOrder(request.getCustomerCpf(), request.getCustomerName(), request.getProducts());
        return ResponseEntity.ok(ApiResponse.created(ENTITY, order));
    }
}
