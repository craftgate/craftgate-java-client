package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateProductRequest;
import io.craftgate.request.SearchProductsRequest;
import io.craftgate.request.UpdateProductRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.ProductListResponse;
import io.craftgate.response.ProductResponse;

public class PayByLinkAdapter extends BaseAdapter {

    public PayByLinkAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        return createProduct(createProductRequest, null);
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest, RequestContext requestContext) {
        String path = "/craftlink/v1/products";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createProductRequest, path, requestContext),
                createProductRequest, ProductResponse.class);
    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        String path = "/craftlink/v1/products/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateProductRequest, path),
                updateProductRequest, ProductResponse.class);
    }

    public ProductResponse retrieveProduct(Long id) {
        String path = "/craftlink/v1/products/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), ProductResponse.class);
    }

    public void deleteProduct(Long id) {
        deleteProduct(id, null);
    }

    public void deleteProduct(Long id, RequestContext requestContext) {
        String path = "/craftlink/v1/products/" + id;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext));
    }

    public ProductListResponse searchProducts(SearchProductsRequest searchProductsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchProductsRequest);
        String path = "/craftlink/v1/products" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), ProductListResponse.class);
    }
}
