package model;

public class Request {
    private Object objectType;
    private int id;
    private String requestInfo;

    public Request() {}

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public void setObjectType(Object objectType) {
        this.objectType = objectType;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Request{" +
                "objectType=" + objectType +
                ", id=" + id +
                ", requestInfo='" + requestInfo + '\'' +
                '}';
    }
}
