package com.gl.api.services;

import com.gl.api.model.ReceiptCode;
import com.gl.api.repository.ReceiptCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:13 AM
 * Email    : d.dim@gl-f.com
 */

@Service
public class ReceiptCodeService {

    @Autowired
    private ReceiptCodeRepository repository;

    public ReceiptCode findByReceiptCode(String code){
        return repository.findByReceiptCode(code);
    }
}
