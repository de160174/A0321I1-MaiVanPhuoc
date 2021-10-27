package model.bean;

public class ContractDetail {
    private String contract_detail_id;
    private String contract_id;
    private String attach_service_id;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(String contract_detail_id, String contract_id, String attach_service_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public String getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(String contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(String attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
