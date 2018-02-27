package com.gl.api.controller;

import com.gl.api.model.ReceiptCode;
import com.gl.api.repository.ReceiptCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:14 AM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "/receipt")
public class ReceiptCodeController {

    @Autowired
    private ReceiptCodeRepository repository;

    @PostMapping("/code")
    public ReceiptCode createReceiptCode(@RequestBody ReceiptCode code) {
        return repository.save(code);
    }

    @GetMapping("/code")
    public List<ReceiptCode> allReceiptCode() {
        return repository.findAll();
    }

}
