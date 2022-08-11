package io.craftgate.adapter;

import io.craftgate.model.FraudCheckStatus;
import io.craftgate.net.HttpClient;
import io.craftgate.request.FraudValueListRequest;
import io.craftgate.request.SearchFraudCheckRequest;
import io.craftgate.request.UpdateFraudCheckRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.FraudAllValueListsResponse;
import io.craftgate.response.FraudCheckListResponse;
import io.craftgate.response.FraudValueListResponse;

public class FraudAdapter extends BaseAdapter {

    public FraudAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public FraudCheckListResponse searchFraudChecks(SearchFraudCheckRequest searchFraudCheckRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchFraudCheckRequest);
        String path = "/fraud/v1/fraud-checks" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), FraudCheckListResponse.class);
    }

    public void updateFraudCheckStatus(Long id, FraudCheckStatus fraudCheckStatus) {
        String path = "/fraud/v1/fraud-checks/" + id + "/check-status";
        UpdateFraudCheckRequest updateFraudCheckRequest = UpdateFraudCheckRequest.builder().checkStatus(fraudCheckStatus).build();
        HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateFraudCheckRequest, path, requestOptions),
                updateFraudCheckRequest, Void.class);
    }

    public FraudAllValueListsResponse retrieveAllValueLists() {
        String path = "/fraud/v1/value-lists/all";
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), FraudAllValueListsResponse.class);
    }

    public FraudValueListResponse retrieveValueList(String listName) {
        String path = "/fraud/v1/value-lists/"+listName;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), FraudValueListResponse.class);
    }

    public void createValueList(String listName) {
        addValueToValueList(listName, null, null);
    }

    public void deleteValueList(String listName) {
        String path = "/fraud/v1/value-lists/" + listName;

        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }

    public void addValueToValueList(String listName, String value, Integer expireInSeconds) {
        String path = "/fraud/v1/value-lists";
        FraudValueListRequest fraudValueListRequest = FraudValueListRequest.builder().listName(listName).value(value).durationInSeconds(expireInSeconds).build();
        HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(fraudValueListRequest, path, requestOptions),
                fraudValueListRequest, Void.class);
    }

    public void removeValueFromValueList(String listName, String value) {
        String path = "/fraud/v1/value-lists/" + listName + "/values/" + value;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }
}
