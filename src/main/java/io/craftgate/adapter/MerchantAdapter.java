package io.craftgate.adapter;

import io.craftgate.model.PosStatus;
import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateMerchantPosRequest;
import io.craftgate.request.SearchMerchantPosRequest;
import io.craftgate.request.UpdateMerchantPosCommissionsRequest;
import io.craftgate.request.UpdateMerchantPosRequest;
import io.craftgate.request.common.RequestContext;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.MerchantPosCommissionListResponse;
import io.craftgate.response.MerchantPosListResponse;
import io.craftgate.response.MerchantPosResponse;

public class MerchantAdapter extends BaseAdapter {

    public MerchantAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public MerchantPosResponse createMerchantPos(CreateMerchantPosRequest createMerchantPosRequest) {
        return createMerchantPos(createMerchantPosRequest, null);
    }

    public MerchantPosResponse createMerchantPos(CreateMerchantPosRequest createMerchantPosRequest, RequestContext requestContext) {
        String path = "/merchant/v1/merchant-poses";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createMerchantPosRequest, path, requestContext),
                createMerchantPosRequest, MerchantPosResponse.class);
    }

    public MerchantPosResponse updateMerchantPos(Long merchantPosId, UpdateMerchantPosRequest updateMerchantPosRequest) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateMerchantPosRequest, path),
                updateMerchantPosRequest, MerchantPosResponse.class);
    }

    public void updateMerchantPosStatus(Long merchantPosId, PosStatus posStatus) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId + "/status/" + posStatus.name();
        HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(path), Void.class);
    }

    public MerchantPosListResponse searchMerchantPos(SearchMerchantPosRequest searchMerchantPosRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchMerchantPosRequest);
        String path = "/merchant/v1/merchant-poses" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), MerchantPosListResponse.class);
    }

    public MerchantPosResponse retrieve(Long merchantPosId) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), MerchantPosResponse.class);
    }

    public void deleteMerchantPos(Long merchantPosId) {
        deleteMerchantPos(merchantPosId, null);
    }

    public void deleteMerchantPos(Long merchantPosId, RequestContext requestContext) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestContext));
    }

    public MerchantPosCommissionListResponse retrieveMerchantPosCommissions(Long merchantPosId) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId + "/commissions";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path), MerchantPosCommissionListResponse.class);
    }

    /*
     * This endpoint using for creating and updating merchant pos commissions. The HTTP method is POST due to this requirement.
     * */
    public MerchantPosCommissionListResponse updateMerchantPosCommissions(Long merchantPosId, UpdateMerchantPosCommissionsRequest updateMerchantPosCommissionsRequest) {
        return updateMerchantPosCommissions(merchantPosId, updateMerchantPosCommissionsRequest, null);
    }

    public MerchantPosCommissionListResponse updateMerchantPosCommissions(Long merchantPosId, UpdateMerchantPosCommissionsRequest updateMerchantPosCommissionsRequest, RequestContext requestContext) {
        String path = "/merchant/v1/merchant-poses/" + merchantPosId + "/commissions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(updateMerchantPosCommissionsRequest, path, requestContext), updateMerchantPosCommissionsRequest, MerchantPosCommissionListResponse.class);
    }
}
