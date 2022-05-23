package com.example.elk.swagger.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.elk.swagger.user.config.ClientConfiguration;

@FeignClient(name="${user.name:user}", url="${user.url:http://localhost:8081}", configuration = ClientConfiguration.class)
public interface UserApiClient extends UserApi {
}
