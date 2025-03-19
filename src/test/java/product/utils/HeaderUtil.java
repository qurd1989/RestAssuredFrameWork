package product.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.Map;
import java.util.stream.Collectors;

public class HeaderUtil {
    public static Headers getAuthHeaders(String token) {
        Map<String, String> headersMap = Map.of(
                "Authorization", "Bearer " + token,
                "Content-Type", "application/json"
        );
        return new Headers(headersMap.entrySet().stream()
                .map(entry -> new Header(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList()));
    }
}

