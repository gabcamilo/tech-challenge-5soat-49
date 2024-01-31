package br.com.camilo.gabriela.techchallenge5soat49.adapters.configs;

import br.com.camilo.gabriela.techchallenge5soat49.TechChallenge5soat49Application;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.order.OrderValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TechChallenge5soat49Application.class)
public class BeanConfiguration {

    @Bean
    CustomerServicePortImpl customerServicePortImpl(CustomerPersistencePort persistencePort, CustomerValidationPort validationPort) {
        return new CustomerServicePortImpl(persistencePort, validationPort);
    }

    @Bean
    CustomerValidationPortImpl customerValidationPortImpl() {
        return new CustomerValidationPortImpl();
    }

    @Bean
    ProductServicePortImpl productServicePortImpl(ProductPersistencePort persistencePort, ProductValidationPort validationPort) {
        return new ProductServicePortImpl(persistencePort, validationPort);
    }

    @Bean
    ProductValidationPortImpl productValidationPortImpl() {
        return new ProductValidationPortImpl();
    }


    @Bean
    OrderServicePortImpl orderServicePortImpl(OrderPersistencePort persistencePort, OrderValidationPort validationPort, ProductPersistencePort productPersistencePort, CustomerPersistencePort customerPersistencePort) {
        return new OrderServicePortImpl(persistencePort, validationPort, productPersistencePort, customerPersistencePort);
    }

    @Bean
    OrderValidationPortImpl orderValidationPortImpl() {
        return new OrderValidationPortImpl();
    }
}
