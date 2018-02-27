package com.gl.api.controller;

import com.gl.api.model.Area;
import com.gl.api.model.ReceiptCode;
import com.gl.api.repository.AreaRepository;
import com.gl.api.repository.ReceiptCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:28 AM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private AreaRepository repository;

    @PostMapping
    public Area createArea(@RequestBody Area area) {
        return repository.save(area);
    }

    @GetMapping
    public List<Area> allArea() {
        return repository.findAll();
    }
}
