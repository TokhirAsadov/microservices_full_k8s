package com.javatuz.accounts.service.client;

import com.javatuz.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * default holatda 30s eureka dagi cards serverga ulanishni kutadi
 * */
@FeignClient("cards")
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader(value = "eazybank-correlation-id") String correlationId, @RequestParam String mobileNumber);

}
