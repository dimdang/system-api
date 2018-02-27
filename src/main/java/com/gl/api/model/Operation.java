package com.gl.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 9:33 AM
 * Email    : d.dim@gl-f.com
 */
@Entity
@Table(name = "operation_tbl")
public class Operation implements Serializable{

    private Long operationId;
    private String operationCode;
    private String operationDescription;
    private Double operationPrice;
    private Double defaultDLTCharge;
    private Double defaultWage;
    private ReceiptCode receiptCode;

    public Operation() { }

    @Id
    @GeneratedValue
    @Column(name = "ope_id")
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    @Column(name = "ope_cde")
    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @Column(name = "ope_des")
    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    @Column(name = "ope_price")
    public Double getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(Double operationPrice) {
        this.operationPrice = operationPrice;
    }

    @Column(name = "def_dlt_charge")
    public Double getDefaultDLTCharge() {
        return defaultDLTCharge;
    }

    public void setDefaultDLTCharge(Double defaultDLTCharge) {
        this.defaultDLTCharge = defaultDLTCharge;
    }

    @Column(name = "def_wag")
    public Double getDefaultWage() {
        return defaultWage;
    }

    public void setDefaultWage(Double defaultWage) {
        this.defaultWage = defaultWage;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rec_cod_id")
    public ReceiptCode getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(ReceiptCode receiptCode) {
        this.receiptCode = receiptCode;
    }
}
