package com.example.pengeluaranNew.util;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

public class UserRestUtil {
    private static final String CONTENT_TYPE = "Content-Type";

    public static <T> ResponseEntity<T> getJsonResponse(T scr) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<T>(scr, headers, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> getJsonResponse(T src, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<T>(src, headers, status);
    }

    public static <T> ResponseEntity<T> getJsonHttpStatus(HttpStatus status) {
        return new ResponseEntity<T>(status);
    }

    public static <T> ResponseEntity<List<T>> defaultJsonResponse(List<T> src) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<List<T>>(src, headers, HttpStatus.OK);
    }

    public static <T> T jsonToObject(String strJson, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(strJson, type);
    }

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> ResponseEntity<T> getJsonResponse(T src, HttpStatus status,
            Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
        if (null != mapHeaderMessage) {
            for (String key : mapHeaderMessage.keySet()) {
                headers.add(key, mapHeaderMessage.get(key));
            }
        }

        headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<T>(src, headers, status);
    }
}