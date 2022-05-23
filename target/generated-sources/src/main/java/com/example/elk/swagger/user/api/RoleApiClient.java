package com.example.elk.swagger.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.elk.swagger.user.config.ClientConfiguration;

@FeignClient(name="${role.name:role}", url="${role.url:http://localhost:8081}", configuration = ClientConfiguration.class)
public interface RoleApiClient extends RoleApi {
}
