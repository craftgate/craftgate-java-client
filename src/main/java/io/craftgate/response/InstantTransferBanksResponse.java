package io.craftgate.response;

import lombok.Data;

import java.util.List;

@Data
public class InstantTransferBanksResponse {

    private List<InstantTransferBank> items;

}