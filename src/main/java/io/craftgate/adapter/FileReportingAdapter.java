package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateReportRequest;
import io.craftgate.request.RetrieveDailyPaymentReportRequest;
import io.craftgate.request.RetrieveDailyTransactionReportRequest;
import io.craftgate.request.RetrieveReportRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.ReportDemandResponse;

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

    public byte[] retrieveDailyPaymentReport(RetrieveDailyPaymentReportRequest retrieveDailyPaymentReportRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(retrieveDailyPaymentReportRequest);
        String path = "/file-reporting/v1/payment-reports" + query;
        Map<String, String> headers = createHeaders(path, requestOptions);
        headers.put(CONTENT_TYPE, APPLICATION_OCTET_STREAM);
        return HttpClient.get(requestOptions.getBaseUrl() + path, headers, byte[].class);
    }

    public ReportDemandResponse createReport(CreateReportRequest request) {
        String path = "/file-reporting/v1/report-demands";
        Map<String, String> headers = createHeaders(request, path, requestOptions);
        return HttpClient.post(requestOptions.getBaseUrl() + path,
                headers,
                request,
                ReportDemandResponse.class);
    }

    public byte[] retrieveReport(RetrieveReportRequest retrieveReportRequest, Long reportId) {
        String query = RequestQueryParamsBuilder.buildQueryParam(retrieveReportRequest);
        String path = "/file-reporting/v1/reports/" + reportId + query;
        Map<String, String> headers = createHeaders(path, requestOptions);
        headers.put(CONTENT_TYPE, APPLICATION_OCTET_STREAM);
        return HttpClient.get(requestOptions.getBaseUrl() + path, headers, byte[].class);
    }
}
