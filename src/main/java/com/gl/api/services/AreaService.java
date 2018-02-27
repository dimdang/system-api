package com.gl.api.services;

import com.gl.api.model.Area;
import com.gl.api.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 5:25 PM
 * Email    : d.dim@gl-f.com
 */

@Service
public class AreaService {

    @Autowired
    private AreaRepository repository;

    public List<Area> findByAreaName(String[] names){
        return repository.findByAreaName(names);
    }

}
