package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int contractDetailId;

    @Min(value = 0,message = "phải là giá trị dương")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    public ContractDetail() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
