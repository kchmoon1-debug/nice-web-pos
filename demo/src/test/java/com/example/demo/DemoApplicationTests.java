package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void 나이스결제_API_연동_테스트() {
		// 1. Spring 외부 통신용 객체 생성
		RestTemplate restTemplate = new RestTemplate();

		// 2. 실제 NICEPAY Sandbox(가상 테스트) 결제 API 주소
		String url = "https://sandbox-api.nicepay.co.kr/v1/payments";

		// 3. NICE 결제 가이드 표준에 맞춘 가짜 POS 주문 데이터 세팅
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("amount", 1004); // 테스트 결제 금액
		requestBody.put("orderId", "MOCK_POS_ORDER_2026"); // 가상 포스기 주문번호
		requestBody.put("goodsName", "NICE_WEB_POS_TEST_ITEM"); // 상품명

		System.out.println("\n>>> [START] NICE PAY 가상 결제 API 호출 시도...");

		try {
			// 4. NICE 서버로 실제 HTTP POST 요청 발송 및 응답 수신
			String response = restTemplate.postForObject(url, requestBody, String.class);

			// 5. 성공 시 결과 콘솔 출력
			System.out.println("\n==================================================");
			System.out.println("🎉 [SUCCESS] NICE 결제 API 통신에 성공했습니다!");
			System.out.println("==================================================");
			System.out.println(response);
			System.out.println("==================================================\n");

		} catch (Exception e) {
			// 6. 실패 시 에러 출력
			System.out.println("\n==================================================");
			System.out.println("❌ [FAIL] NICE API 통신 실패 원인 발생:");
			System.out.println(e.getMessage());
			System.out.println("==================================================\n");
		}
	}
}
