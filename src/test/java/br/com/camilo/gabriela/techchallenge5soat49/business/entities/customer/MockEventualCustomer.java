package br.com.camilo.gabriela.techchallenge5soat49.business.entities.customer;

import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import static org.instancio.Select.field;

public class MockEventualCustomer {
    private String name;

    private MockEventualCustomer() {
        throw new IllegalStateException("Utility class");
    }

    public static MockEventualCustomer generateMockData() {
        return Instancio.of(MockEventualCustomer.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .create();
    }

    public String getName() {
        return name;
    }


    public MockEventualCustomer withEmptyName() {
        this.name = "";
        return this;
    }

    public MockEventualCustomer withNullName() {
        this.name = null;
        return this;
    }

}
