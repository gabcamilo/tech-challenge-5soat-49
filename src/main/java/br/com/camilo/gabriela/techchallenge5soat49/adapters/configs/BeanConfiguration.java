package br.com.camilo.gabriela.techchallenge5soat49.adapters.configs;

import br.com.camilo.gabriela.techchallenge5soat49.TechChallenge5soat49Application;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.customer.CustomerValidationPort;
import br.com.camilo.gabriela.techchallenge5soat49.core.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TechChallenge5soat49Application.class)
public class BeanConfiguration {

    @Bean
    CustomerServicePortImpl customerServicePortImpl(CustomerPersistencePort persistence, CustomerValidationPort validation) {
        return new CustomerServicePortImpl(persistence, validation);
    }

    @Bean
    CustomerValidationPortImpl customerValidationPortImpl() {
        return new CustomerValidationPortImpl();
    }

    @Bean
    ProductServicePortImpl productServicePortImpl() {
        return new ProductServicePortImpl();
    }

    @Bean
    BundleServicePortImpl bundleServicePortImpl() {
        return new BundleServicePortImpl();
    }

    @Bean
    OrderServicePortImpl orderServicePortImpl() {
        return new OrderServicePortImpl();
    }
}
