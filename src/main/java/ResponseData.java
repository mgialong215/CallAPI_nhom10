class ResponseData {
    private Integer code;
    private String message;
    private Data data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public void printResponseData() {
        System.out.println("Test Response");
        System.out.println("Code: " + this.getCode().toString());
        System.out.println("Message: " + this.getMessage());
        System.out.println();
    }
}
