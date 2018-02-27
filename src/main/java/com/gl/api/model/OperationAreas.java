package com.gl.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:37 AM
 * Email    : d.dim@gl-f.com
 */

@Entity
@Table(name = "operation_area")
public class OperationAreas {

    private Long operationAreaId;
    private Double areaDLTCharge;
    private Double areaWage;
    private List<Area> provinceAreas = new ArrayList<>();

    public OperationAreas(){}

    @Id
    @GeneratedValue
    @Column(name = "ope_are_id")
    public Long getOperationAreaId() {

        return operationAreaId;
    }

    public void setOperationAreaId(Long operationAreaId) {
        this.operationAreaId = operationAreaId;
    }


    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Area> getProvinceAreas() {
        return provinceAreas;
    }

    public void setProvinceAreas(List<Area> provinceAreas) {
        this.provinceAreas = provinceAreas;
    }

    @Column(name = "are_dlt_charge")
    public Double getAreaDLTCharge() {
        return areaDLTCharge;
    }

    public void setAreaDLTCharge(Double areaDLTCharge) {
        this.areaDLTCharge = areaDLTCharge;
    }

    @Column(name = "are_wage")
    public Double getAreaWage() {
        return areaWage;
    }

    public void setAreaWage(Double areaWage) {
        this.areaWage = areaWage;
    }
}
