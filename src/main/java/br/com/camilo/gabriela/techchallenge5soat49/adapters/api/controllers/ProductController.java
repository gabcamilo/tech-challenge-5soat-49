package br.com.camilo.gabriela.techchallenge5soat49.adapters.api.controllers;

import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.product.CreateProductRequest;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.product.ListProductResponse;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.product.ProductResponse;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.ApiResponse;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    private final ProductServicePort port;
    private static final String ENTITY = "Product";

    public ProductController(ProductServicePort port) {
        this.port = port;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody @Valid CreateProductRequest request) throws Throwable {
        Product product = port.create(Product.createNew(request.name(), request.type(), request.description(), request.price()));
        var response = ApiResponse.created(ENTITY, product);
        return ResponseEntity.created(new URI("/api/v1/products/" + product.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable String id) throws Throwable {
        Product product = port.get(id);
        var response = ApiResponse.get(ENTITY, new ProductResponse(product));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/types/{type}")
    public ResponseEntity<ApiResponse> listProductsByType(@PathVariable String type) {
        ProductType typeEnum = ProductType.valueOf(type.toUpperCase());
        List<Product> products = port.listProductsByType(typeEnum);
        var data = new ListProductResponse(products);
        var response = ApiResponse.list(ENTITY, data);
        return ResponseEntity.ok(response);
    }

}
