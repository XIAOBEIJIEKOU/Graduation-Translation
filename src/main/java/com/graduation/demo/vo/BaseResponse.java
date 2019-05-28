package com.graduation.demo.vo;

import org.springframework.stereotype.Repository;

@Repository
public class BaseResponse {

    private String status;

    private Object content;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
