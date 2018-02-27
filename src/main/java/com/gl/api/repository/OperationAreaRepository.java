package com.gl.api.repository;

import com.gl.api.model.OperationAreas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 4:08 PM
 * Email    : d.dim@gl-f.com
 */

public interface OperationAreaRepository  extends JpaRepository<OperationAreas, Long> {

    List<OperationAreas> findByProvinceAreas(String[] names);
}
