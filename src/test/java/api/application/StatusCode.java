package api.application;

public enum StatusCode {
    STATUS_CODE_200(200,"r"),
    STATUS_CODE_201(201,"Segment has been created successfully."),
    STATUS_CODE_400(400,"CustomerID is mandatory"),
    STATUS_CODE_Email_400(400,"Validation error: Invalid email, expected format is janedoe@thewarehouse.co.nz"),
    STATUS_CODE_Token_400(400,"Validation error: Invalid Firebase Token"),
    STATUS_CODE_401(401,"Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription."),
    STATUS_CODE_UnauthorisedKey_401(401,"Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.");

private final int code;
    private final String status;

    StatusCode(int code, String status) {
        this.code = code;
        this.status = status;
    }
    public int getCode(){
        return code;
    }
    public String getstatus(){
        return status;
    }
}
