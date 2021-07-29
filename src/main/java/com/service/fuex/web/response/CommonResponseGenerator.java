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
    public <T> CommonResponse<T> responseEmailNotFound(Date content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("EMAIL NOT FOUND");
        commonResponse.setContent(content);

        return commonResponse;
    }
}
