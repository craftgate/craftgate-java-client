package io.craftgate.adapter;

import io.craftgate.model.FraudCheckStatus;
import io.craftgate.model.FraudValueType;
import io.craftgate.net.HttpClient;
import io.craftgate.request.AddCardFingerprintFraudValueListRequest;
import io.craftgate.request.FraudValueListRequest;
import io.craftgate.request.SearchFraudChecksRequest;
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

    public FraudCheckListResponse searchFraudChecks(SearchFraudChecksRequest searchFraudChecksRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchFraudChecksRequest);
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
        String path = "/fraud/v1/value-lists/" + listName;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), FraudValueListResponse.class);
    }

    public void createValueList(String listName, FraudValueType type) {
        FraudValueListRequest createRequest = FraudValueListRequest.builder().type(type).listName(listName).value(null).durationInSeconds(null).build();
        addValueToValueList(createRequest);
    }

    public void deleteValueList(String listName) {
        String path = "/fraud/v1/value-lists/" + listName;

        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }

    public void addValueToValueList(FraudValueListRequest fraudValueListRequest) {
        String path = "/fraud/v1/value-lists";
        HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(fraudValueListRequest, path, requestOptions),
                fraudValueListRequest, Void.class);
    }

    public void addCardFingerprint(AddCardFingerprintFraudValueListRequest request, String listName) {
        String path = "/fraud/v1/value-lists/"+ listName + "/card-fingerprints";
        HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, Void.class);
    }

    public void removeValueFromValueList(String listName, String valueId) {
        String path = "/fraud/v1/value-lists/" + listName + "/values/" + valueId;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions));
    }
}
