package case_study.models;

public class Contract {
    private int contractNumber;
    private String bookingId;
    private double depositAmount;
    private double totalAmount;
    private String customerId;

    public Contract() {
    }

    public Contract(int contractNumber, String bookingId, double depositAmount, double totalAmount, String customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String showInfo() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingId='" + bookingId + '\'' +
                ", depositAmount=" + depositAmount +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return contractNumber +
                "," + bookingId +
                "," + depositAmount +
                "," + totalAmount +
                "," + customerId;
    }
}
