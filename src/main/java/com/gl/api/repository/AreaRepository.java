package com.gl.api.repository;

import com.gl.api.model.Area;
import com.gl.api.model.OperationAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:28 AM
 * Email    : d.dim@gl-f.com
 */

public interface AreaRepository extends JpaRepository<Area, Long> {


    public List<Area> findByAreaName(String[] names);
}
