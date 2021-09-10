package case_study.models;

public class Customer extends Person{
    private String customerId;
    private String customerType;
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerId, String customerType, String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public Customer(String name, String date, boolean gender, int idCard, String email, String customerId, String customerType, String customerAddress) {
        super(name, date, gender, idCard, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    @Override
    public String toString() {
        return  name +
                "," + date +
                "," + gender +
                "," + idCard +
                "," + email +
                "," +  customerId +
                "," + customerType +
                "," + customerAddress ;
    }

    public String showInfo() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender=" + gender +
                ", idCard=" + idCard +
                ", email='" + email + '\'' +
                '}';
    }


}
