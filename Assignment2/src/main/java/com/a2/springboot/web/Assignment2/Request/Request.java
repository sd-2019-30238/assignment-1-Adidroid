package com.a2.springboot.web.Assignment2.Request;

public class Request {

    private String request;
    private Object parameter;
    private RequestType type;


    public Request(String request,Object parameter, RequestType type) {
        this.request=request;
        this.parameter = parameter;
        this.type = type;
    }


    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
