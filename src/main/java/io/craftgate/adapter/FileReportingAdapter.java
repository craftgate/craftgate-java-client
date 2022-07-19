package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.RetrieveDailyTransactionReportRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;

import java.util.Map;

public class FileReportingAdapter extends BaseAdapter {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";

    public FileReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public byte[] retrieveDailyTransactionReport(RetrieveDailyTransactionReportRequest retrieveDailyTransactionReportRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(retrieveDailyTransactionReportRequest);
        String path = "/file-reporting/v1/transaction-reports" + query;
        Map<String, String> headers = createHeaders(path, requestOptions);
        headers.put(CONTENT_TYPE, APPLICATION_OCTET_STREAM);
        return HttpClient.get(requestOptions.getBaseUrl() + path, headers, byte[].class);
    }
}
