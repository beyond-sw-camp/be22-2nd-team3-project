package com.ohgiraffers.mainservice.common.client;

import com.ohgiraffers.mainservice.common.dto.ApiResponse;
import com.ohgiraffers.mainservice.common.dto.UserDetailResponse;
import com.ohgiraffers.mainservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8000", configuration = FeignClientConfig.class)
public interface UserServiceClient {

    @GetMapping("/api/v1/user-service/users/{user_no}")
    ApiResponse<UserDetailResponse> getUserByUserNo(@PathVariable("user_no") Long userNo);

    @GetMapping("/api/v1/user-service/users/{userId}")
    ApiResponse<UserDetailResponse> getUserByUserId(@PathVariable String userId);

}
