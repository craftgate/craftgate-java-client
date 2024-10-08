package io.craftgate.adapter;

import io.craftgate.model.ApmStatus;
import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateMerchantApmRequest;
import io.craftgate.request.UpdateMerchantApmRequest;
import io.craftgate.request.UpdateMerchantApmStatusRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.response.MerchantApmListResponse;
import io.craftgate.response.MerchantApmResponse;

public class MerchantApmAdapter extends BaseAdapter {

    public MerchantApmAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MerchantApmResponse createMerchantApm(CreateMerchantApmRequest createMerchantApmRequest) {
        String path = "/merchant/v1/merchant-apms";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createMerchantApmRequest, path, requestOptions),
                createMerchantApmRequest, MerchantApmResponse.class);
    }

    public MerchantApmResponse updateMerchantApm(Long merchantApmId, UpdateMerchantApmRequest updateMerchantApmRequest) {
        String path = "/merchant/v1/merchant-apms/" + merchantApmId;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateMerchantApmRequest, path, requestOptions),
                updateMerchantApmRequest, MerchantApmResponse.class);
    }

    public void updateMerchantApmStatus(Long merchantApmId, UpdateMerchantApmStatusRequest updateMerchantApmStatusRequest) {
        String path = "/merchant/v1/merchant-apms/" + merchantApmId + "/status";
        HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateMerchantApmStatusRequest,path, requestOptions), updateMerchantApmStatusRequest,Void.class);
    }

    public MerchantApmListResponse retrieveAll() {
        String path = "/merchant/v1/merchant-apms";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), MerchantApmListResponse.class);
    }

    public void deleteMerchantApm(Long merchantApmId) {
        String path = "/merchant/v1/merchant-apms/" + merchantApmId;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }
}