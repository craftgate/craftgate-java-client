package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudCheckStatus;
import io.craftgate.request.SearchFraudChecksRequest;
import io.craftgate.response.FraudAllValueListsResponse;
import io.craftgate.response.FraudCheckListResponse;
import io.craftgate.response.FraudValueListResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_fraud_checks() {
        SearchFraudChecksRequest request = SearchFraudChecksRequest.builder()
                .minCreatedDate(LocalDateTime.now().minusDays(1))
                .maxCreatedDate(LocalDateTime.now())
                .action(FraudAction.REVIEW)
                .checkStatus(FraudCheckStatus.WAITING)
                .build();

        FraudCheckListResponse response = craftgate.fraud().searchFraudChecks(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_fraud_checks_with_payment_id() {
        Long paymentId = 5L;
        SearchFraudChecksRequest request = SearchFraudChecksRequest.builder()
                .paymentId(paymentId)
                .build();

        FraudCheckListResponse response = craftgate.fraud().searchFraudChecks(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void update_fraud_check_status() {
        long fraudCheckId = 1L;
        craftgate.fraud().updateFraudCheckStatus(fraudCheckId, FraudCheckStatus.FRAUD);
    }

    @Test
    void retrieve_fraud_value_list() {
        FraudValueListResponse valueList = craftgate.fraud().retrieveValueList("ipList");
        assertEquals("ipList", valueList.getName());
    }

    @Test
    void retrieve_all_fraud_value_lists() {
        FraudAllValueListsResponse allValueLists = craftgate.fraud().retrieveAllValueLists();
        assertTrue(allValueLists.getItems().size() > 0);
    }

    @Test
    void create_fraud_value_list() {
        craftgate.fraud().createValueList("ipList");
    }

    @Test
    void add_value_to_fraud_value_list() {
        craftgate.fraud().addValueToValueList("ipList", "127.0.0.1", null);
    }

    @Test
    void add_temporary_value_to_fraud_value_list() {
        craftgate.fraud().addValueToValueList("ipList", "127.0.0.2", 60);
    }

    @Test
    void remove_value_to_fraud_value_list() {
        craftgate.fraud().removeValueFromValueList("ipList", "127.0.0.1");
    }

    @Test
    void delete_fraud_value_list() {
        craftgate.fraud().deleteValueList("ipList");
    }

}
