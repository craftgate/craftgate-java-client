package io.craftgate.unit;

import io.craftgate.Craftgate;
import io.craftgate.request.CreateMerchantPosRequest;
import io.craftgate.request.RetrieveLoyaltiesRequest;
import io.craftgate.request.StoreCardRequest;
import io.craftgate.request.UpdateMerchantPosRequest;
import io.craftgate.request.common.Jsons;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.CreateMerchantPosUser;
import io.craftgate.request.dto.EncryptedCard;
import io.craftgate.request.dto.VerifyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SensitiveDataTest {

    private static final String CARD_NUMBER = "5258640000000001";
    private static final String CVC = "987";

    @Test
    void request_options_to_string_hides_secret_key() {
        RequestOptions options = RequestOptions.builder().apiKey("api-key").secretKey("top-secret").build();
        assertFalse(options.toString().contains("top-secret"));
    }

    @Test
    void card_to_string_hides_card_number_and_cvc_but_json_keeps_them() {
        Card card = Card.builder()
                .cardHolderName("Haluk Demir")
                .cardNumber(CARD_NUMBER)
                .cvc(CVC)
                .expireYear("2044")
                .expireMonth("07")
                .cardUserKey("card-user-key")
                .cardToken("card-token")
                .encryptedCard(EncryptedCard.builder().cardData("encrypted-data").build())
                .cardAlias("my-card")
                .build();
        String text = card.toString();
        for (String hidden : new String[]{CARD_NUMBER, CVC, "Haluk Demir", "2044", "07", "card-user-key", "card-token", "encrypted-data"}) {
            assertFalse(text.contains(hidden), hidden);
        }
        assertTrue(text.contains("my-card"));

        String json = Jsons.getGson().toJson(card);
        for (String sent : new String[]{CARD_NUMBER, CVC, "Haluk Demir", "2044", "card-user-key", "card-token", "encrypted-data"}) {
            assertTrue(json.contains(sent), sent);
        }
    }

    @Test
    void credentials_and_pos_usernames_are_hidden() {
        assertFalse(RequestOptions.builder().apiKey("my-api-key").build().toString().contains("my-api-key"));
        assertFalse(CreateMerchantPosUser.builder().posUsername("pos-user").build().toString().contains("pos-user"));
    }

    @Test
    void other_card_requests_hide_card_number_and_cvc() {
        String verifyCard = VerifyCard.builder().cardNumber(CARD_NUMBER).cvc(CVC).build().toString();
        String storeCard = StoreCardRequest.builder().cardNumber(CARD_NUMBER).build().toString();
        String loyalties = RetrieveLoyaltiesRequest.builder().cardNumber(CARD_NUMBER).cvc(CVC).build().toString();

        assertFalse(verifyCard.contains(CARD_NUMBER) || verifyCard.contains(CVC));
        assertFalse(storeCard.contains(CARD_NUMBER));
        assertFalse(loyalties.contains(CARD_NUMBER) || loyalties.contains(CVC));
    }

    @Test
    void pos_user_to_string_hides_password() {
        String posUser = CreateMerchantPosUser.builder().posUsername("user").posPassword("pos-secret").build().toString();
        assertFalse(posUser.contains("pos-secret"));
    }

    @Test
    void merchant_pos_requests_hide_threeds_key() {
        assertFalse(CreateMerchantPosRequest.builder().threedsKey("3ds-secret").build().toString().contains("3ds-secret"));
        assertFalse(UpdateMerchantPosRequest.builder().threedsKey("3ds-secret").build().toString().contains("3ds-secret"));
    }

    @Test
    void accepts_https_and_loopback_http_base_urls() {
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "HTTPS://api.craftgate.io"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "http://localhost:8000"));
        assertDoesNotThrow(() -> new Craftgate("api-key", "secret-key", "http://127.0.0.1:8000"));
    }

    @Test
    void rejects_insecure_or_invalid_base_urls() {
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "http://api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "http://localhost.evil.com"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "ftp://api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", "api.craftgate.io"));
        assertThrows(IllegalArgumentException.class, () -> new Craftgate("api-key", "secret-key", (String) null));
    }
}
