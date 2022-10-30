package com.eatingApple.resp;

public class commonResp<T> {
    //    业务上的成功与失败
    private Boolean success = true;

    private String message;

    private T content;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "commonResp{" +
                "sucess=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
