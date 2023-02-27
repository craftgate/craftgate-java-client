package io.craftgate.adapter;

import io.craftgate.net.HttpClient;
import io.craftgate.request.CreateMemberRequest;
import io.craftgate.request.CreateMerchantRequest;
import io.craftgate.request.SearchMembersRequest;
import io.craftgate.request.UpdateMemberRequest;
import io.craftgate.request.common.RequestOptions;
import io.craftgate.request.common.RequestQueryParamsBuilder;
import io.craftgate.response.CreateMerchantResponse;
import io.craftgate.response.MemberListResponse;
import io.craftgate.response.MemberResponse;

public class OnboardingAdapter extends BaseAdapter {

    public OnboardingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public CreateMerchantResponse createMerchant(CreateMerchantRequest createMerchantRequest) {
        String path = "/onboarding/v1/merchants";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createMerchantRequest, path, requestOptions), createMerchantRequest, CreateMerchantResponse.class);
    }

    public MemberResponse createMember(CreateMemberRequest createMemberRequest) {
        String path = "/onboarding/v1/members";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createMemberRequest, path, requestOptions),
                createMemberRequest, MemberResponse.class);
    }

    public MemberResponse updateMember(Long id, UpdateMemberRequest updateMemberRequest) {
        String path = "/onboarding/v1/members/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateMemberRequest, path, requestOptions),
                updateMemberRequest, MemberResponse.class);
    }

    public MemberResponse retrieveMember(Long id) {
        String path = "/onboarding/v1/members/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), MemberResponse.class);
    }

    public MemberListResponse searchMembers(SearchMembersRequest searchMembersRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchMembersRequest);
        String path = "/onboarding/v1/members" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), MemberListResponse.class);
    }
}
