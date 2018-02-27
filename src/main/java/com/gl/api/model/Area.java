package com.gl.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:03 AM
 * Email    : d.dim@gl-f.com
 */

@Entity
@Table(name = "area_tbl")
public class Area implements Serializable{

    private Long areaId;
    private String areaName;
    private String description;

    public Area(){}

    @Id
    @GeneratedValue
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
