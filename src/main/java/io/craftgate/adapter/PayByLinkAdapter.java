package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.*;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.*;

public class PayByLinkAdapter extends BaseAdapter {

    public PayByLinkAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        String path = "/craftlink/v1/products";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createProductRequest, path, requestOptions),
                createProductRequest, ProductResponse.class);
    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        String path = "/craftlink/v1/products/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateProductRequest, path, requestOptions),
                updateProductRequest, ProductResponse.class);
    }

    public ProductResponse retrieveProduct(Long id) {
        String path = "/craftlink/v1/products/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ProductResponse.class);
    }

    public void deleteProduct(Long id) {
        String path = "/craftlink/v1/products/" + id;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }

    public ProductListResponse searchProducts(SearchProductsRequest searchProductsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchProductsRequest);
        String path = "/craftlink/v1/products" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), ProductListResponse.class);
    }
}
