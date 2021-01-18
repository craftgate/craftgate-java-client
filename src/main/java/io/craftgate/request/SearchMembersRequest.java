package io.craftgate.request;

import io.craftgate.model.MemberType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SearchMembersRequest {

    @Builder.Default
    private Integer page = 0;
    @Builder.Default
    private Integer size = 10;

    private Boolean isBuyer;
    private Boolean isSubMerchant;
    private String name;
    private Set<Long> memberIds;
    private MemberType memberType;
    private String memberExternalId;
}
