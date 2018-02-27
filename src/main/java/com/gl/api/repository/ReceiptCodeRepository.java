package com.gl.api.repository;

import com.gl.api.model.ReceiptCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 10:12 AM
 * Email    : d.dim@gl-f.com
 */

public interface ReceiptCodeRepository extends JpaRepository<ReceiptCode, Long> {

    ReceiptCode findByReceiptCode(String string);
}
