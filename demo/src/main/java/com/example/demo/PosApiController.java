package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PosApiController {

    @PostMapping("/api/pay")
    public String payRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://nicepay.co.kr";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("amount", 1004);
        requestBody.put("orderId", "WEB_POS_KTK_2026");
        requestBody.put("goodsName", "태균 웹포스 상품");

        try {
            // NICE 서버와 실제 통신한 결과를 바로 웹 화면으로 던져줍니다.
            String response = restTemplate.postForObject(url, requestBody, String.class);
            return response;
        } catch (Exception e) {
            // 에러가 나면 401 에러 메시지를 웹 화면에 로그로 띄워줍니다.
            return "❌ 백엔드 예외 처리기 작동!!\n원인: " + e.getMessage();
        }
    }
}
