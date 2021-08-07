package com.service.fuex.web.response;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CommonResponseGenerator {
    public <T> CommonResponse successResponse(T content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("SUCCESS");
        commonResponse.setContent(content);

        return commonResponse;
    }
    public <T> CommonResponse<T> responseEmailNotFound(String content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("ERROR");
        commonResponse.setContent(content);

        return commonResponse;
    }
    public <T> CommonResponse<T> failResponse(String content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("ERROR");
        commonResponse.setContent(content);

        return commonResponse;
    }
}
