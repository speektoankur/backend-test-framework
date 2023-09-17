package DataModels.eNums;

public enum StatusEnums implements StatusBase{
    AVL("available"),
    PEN("pending"),
    SOLD("sold"),
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String status;

    StatusEnums(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
