package com.project.eml.controller;

import com.project.eml.dto.EmployeeDto;
import com.project.eml.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employi")
public class EmployeeController {

    private EmployeeService employeeService;

    //Create Id
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get by Id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId ){
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }

    //Get All
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllemployees(){
        List<EmployeeDto> employees= employeeService.getAllemployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedemployee){
        EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updatedemployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");

    }
}

