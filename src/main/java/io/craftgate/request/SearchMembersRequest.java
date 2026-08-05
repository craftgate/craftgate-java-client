package io.craftgate.request;

import io.craftgate.model.MemberType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchMembersRequest extends BaseRequest {

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
