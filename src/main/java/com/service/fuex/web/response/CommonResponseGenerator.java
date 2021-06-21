package com.service.fuex.web.response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseGenerator {
    public <T> CommonResponse successResponse(T content) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage("SUCCESS");
        commonResponse.setContet(content);

        return commonResponse;
    }
}
