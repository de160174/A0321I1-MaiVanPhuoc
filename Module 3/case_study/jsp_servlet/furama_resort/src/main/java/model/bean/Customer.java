package model.bean;

public class Customer {
    private String customer_id;
    private String customer_type_id;
    private String customer_name;
    private String customer_birthday;
    private Boolean customer_gender;
    private String customer_id_card;
    private String customer_phone;
    private String customer_email;
    private String customer_address;
    private String contract_id;
    private String contract_total_money;
    private String contract_detail_id;
    private String attach_service_id;
    private String attach_service_name;

    public Customer() {
    }

    public Customer(String customer_id , String customer_type_id, String customer_name, String customer_birthday, Boolean customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address) {
        this.customer_id = customer_id;
        this.customer_type_id = customer_type_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public Customer(String customer_id, String customer_name, String customer_birthday, Boolean customer_gender, String customer_phone, String customer_email, String customer_address, String contract_id, String contract_total_money, String contract_detail_id, String attach_service_id, String attach_service_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.contract_id = contract_id;
        this.contract_total_money = contract_total_money;
        this.contract_detail_id = contract_detail_id;
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public Boolean getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(Boolean customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(String customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }


    public String getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(String contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public String getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(String contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public String getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(String attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }
}
