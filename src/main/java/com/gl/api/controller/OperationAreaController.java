package com.gl.api.controller;

import com.gl.api.model.*;
import com.gl.api.repository.OperationAreaRepository;
import com.gl.api.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by DANG DIM
 * Date     : 2/27/2018, 4:09 PM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "/operation/area")
public class OperationAreaController {

    @Autowired
    private OperationAreaRepository repository;

    @Autowired
    private AreaService areaService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllOperationArea(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Map<String, Object> map = new HashMap<>();
        Page<OperationAreas> operationsArea = repository.findAll(new PageRequest(page, size));
        if (operationsArea != null) {
            map.put("STATUS", true);
            map.put("MESSAGE", "SUCCESS");
            map.put("DATA", operationsArea);
        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "NO CONTENT");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createOperationArea(@RequestBody OperationAreas operationAreas, @RequestBody AreaNames name) {
        Map<String, Object> map = new HashMap<>();
        List<Area> areas = areaService.findByAreaName(name.getNames());
        if (operationAreas != null && !areas.isEmpty()) {
            operationAreas.setProvinceAreas(new ArrayList<>(areas));
            repository.save(operationAreas);
            if (repository.save(operationAreas) != null){
                map.put("STATUS", HttpStatus.CREATED);
                map.put("MESSAGE", "CREATED");
                map.put("DATA", operationAreas);
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
    public ResponseEntity<Map<String, Object>> findById(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        OperationAreas oneOperationArea = repository.findOne(id);
        if (oneOperationArea != null) {
            map.put("STATUS", true);
            map.put("MESSAGE", "FOUND");
            map.put("DATA", oneOperationArea);
        } else {
            map.put("STATUS", false);
            map.put("MESSAGE", "NO DATA IN DATABASE");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Map<String, Object>> updateOperationArea(@PathVariable(value = "id") Long id, OperationAreas oper) {
        Map<String, Object> map = new HashMap<>();
        OperationAreas existOpArea = repository.findOne(id);
        if (existOpArea != null) {

            existOpArea.setOperationAreaId(id);
            existOpArea.setAreaDLTCharge(oper.getAreaDLTCharge());
            existOpArea.setAreaWage(oper.getAreaWage());
            existOpArea.setProvinceAreas(oper.getProvinceAreas());

            if (repository.save(existOpArea) != null) {
                map.put("STATUS", true);
                map.put("MESSAGE", "UPDATED SUCCESS");
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
    public ResponseEntity<Map<String, Object>> deleteOperationArea(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            repository.delete(id);
            map.put("STATUS", true);
            map.put("MESSAGE", "DELETED");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("STATUS", false);
            map.put("MESSAGE", "UPDATE ERROR");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

}
