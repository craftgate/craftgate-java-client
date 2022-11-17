package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import io.craftgate.request.CreateProductRequest;
import io.craftgate.request.SearchProductsRequest;
import io.craftgate.request.UpdateProductRequest;
import io.craftgate.response.ProductListResponse;
import io.craftgate.response.ProductResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayByLinkSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_product() {
        HashSet<Integer> enabledInstallments = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(6);
        }};

        CreateProductRequest request = CreateProductRequest.builder()
                .name("A new Product")
                .channel("API")
                .price(BigDecimal.TEN)
                .currency(Currency.TRY)
                .conversationId("my-conversationId")
                .externalId("my-externalId")
                .enabledInstallments(enabledInstallments)
                .build();

        ProductResponse response = craftgate.payByLink().createProduct(request);

        assertEquals(response.getStatus(), Status.ACTIVE);
        assertEquals(response.getName(), request.getName());
        assertEquals(response.getPrice(), request.getPrice());
        assertEquals(response.getChannel(), request.getChannel());
        assertEquals(response.getCurrency(), request.getCurrency());
        assertEquals(response.getEnabledInstallments(), request.getEnabledInstallments());
        assertNotNull(response.getUrl());
        assertNotNull(response.getToken());
        assertNotNull(response.getQrCodeUrl());
    }

    @Test
    void update_product() {
        Long productId = 1L;
        HashSet<Integer> enabledInstallments = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(6);
        }};
        UpdateProductRequest request = UpdateProductRequest.builder()
                .status(Status.ACTIVE)
                .name("A new Product - version 2")
                .channel("API")
                .price(BigDecimal.TEN)
                .currency(Currency.TRY)
                .enabledInstallments(enabledInstallments)
                .build();

        ProductResponse response = craftgate.payByLink().updateProduct(productId, request);

        assertEquals(response.getStatus(), Status.ACTIVE);
        assertEquals(response.getName(), request.getName());
        assertEquals(response.getPrice(), request.getPrice());
        assertEquals(response.getChannel(), request.getChannel());
        assertEquals(response.getCurrency(), request.getCurrency());
        assertEquals(response.getEnabledInstallments(), request.getEnabledInstallments());
        assertNotNull(response.getUrl());
        assertNotNull(response.getToken());
        assertNotNull(response.getQrCodeUrl());
    }

    @Test
    void retrieve_product() {
        Long productId = 1L;

        ProductResponse response = craftgate.payByLink().retrieveProduct(productId);

        assertEquals(productId, response.getId());
        assertNotNull(response.getName());
        assertNotNull(response.getPrice());
        assertNotNull(response.getUrl());
        assertNotNull(response.getToken());
        assertNotNull(response.getQrCodeUrl());
    }

    @Test
    void delete_product() {
        Long productId = 1L;

        craftgate.payByLink().deleteProduct(productId);
    }

    @Test
    void search_products() {
        SearchProductsRequest request = SearchProductsRequest.builder()
                .name("A new Product")
                .channel("API")
                .currency(Currency.TRY)
                .build();

        ProductListResponse productListResponse = craftgate.payByLink().searchProducts(request);

        assertNotNull(productListResponse);
    }
}
