package model;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private Object objectType;
    private int id;
    private String requestInfo;
    private Map<String,String> queryParams;

    public Request() {
        queryParams = new HashMap<>();
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public void setObjectType(Object objectType) {
        this.objectType = objectType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public Object getObjectType() {
        return objectType;
    }

    public int getId() {
        return id;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    @Override
    public String toString() {
        return "Request{" +
                "objectType=" + objectType +
                ", id=" + id +
                ", requestInfo='" + requestInfo + '\'' +
                ", queryParams=" + queryParams +
                '}';
    }
}
