package com.gl.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:05 AM
 * Email    : d.dim@gl-f.com
 */

@Entity
@Table(name = "receipt_code_tbl")
public class ReceiptCode implements Serializable{

    private Long receiptCodId;
    private String receiptCode;
    private String description;

    public ReceiptCode(){}

    @Id
    @GeneratedValue
    @Column(name = "rec_cod_id")
    public Long getReceiptCodId() {
        return receiptCodId;
    }

    public void setReceiptCodId(Long receiptCodId) {
        this.receiptCodId = receiptCodId;
    }

    @Column(name = "rec_code")
    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    @Column(name = "rec_des")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
