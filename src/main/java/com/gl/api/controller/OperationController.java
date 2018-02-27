package com.gl.api.controller;

import com.gl.api.model.Operation;
import com.gl.api.model.ReceiptCode;
import com.gl.api.repository.OperationRepository;
import com.gl.api.services.ReceiptCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 12:00 PM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "/operation")
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ReceiptCodeService codeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllOperation(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Map<String, Object> map = new HashMap<>();
        Page<Operation> operations = operationRepository.findAll(new PageRequest(page, size));
        if (operations != null) {
            map.put("STATUS", true);
            map.put("MESSAGE", "SUCCESSFUL");
            map.put("DATA", operations);
        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "NO CONTENT");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createOperation(@RequestBody Operation operations) {
        Map<String, Object> map = new HashMap<>();
        ReceiptCode receiptCode = codeService.findByReceiptCode(operations.getReceiptCode().getReceiptCode());
        if (receiptCode != null) {
            operations.setReceiptCode(receiptCode);
            if (operationRepository.save(operations) != null){
                map.put("STATUS", true);
                map.put("MESSAGE", "CREATED");
                map.put("DATA", operations);
            }else {
                map.put("STATUS", false);
                map.put("MESSAGE", "ERROR");
            }

        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "NO RECEIPT CODE TO CREATE");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findOperationById(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        Operation operation = operationRepository.findOne(id);
        if (operation != null) {
            map.put("STATUS", true);
            map.put("MESSAGE", "FOUND");
            map.put("DATA", operation);
        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "NO CONTENT IN DATABASE");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Map<String, Object>> updateOperation(@PathVariable(value = "id") Long id, Operation operationDetail) {
        Map<String, Object> map = new HashMap<>();
        Operation operation = operationRepository.findOne(id);
        if (operation != null) {

            operation.setOperationId(id);
            operation.setReceiptCode(operationDetail.getReceiptCode());
            operation.setOperationCode(operationDetail.getOperationCode());
            operation.setDefaultDLTCharge(operationDetail.getDefaultDLTCharge());
            operation.setDefaultWage(operationDetail.getDefaultWage());
            operation.setOperationDescription(operationDetail.getOperationDescription());
            operation.setOperationPrice(operationDetail.getOperationPrice());

            if (operationRepository.save(operation) != null) {
                map.put("STATUS", true);
                map.put("MESSAGE", "UPDATED SUCCESS");
                map.put("DATA", operation);
            } else {
                map.put("STATUS", false);
                map.put("MESSAGE", "UPDATE ERROR");
            }
        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "OPERATION NOT FOUND");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteOperation(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            operationRepository.delete(id);
            map.put("STATUS", true);
            map.put("MESSAGE", "DELETED");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("STATUS", false);
            map.put("MESSAGE", "DELETED ERROR");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

}
