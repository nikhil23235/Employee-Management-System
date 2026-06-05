package com.project.eml.service.impl;

import com.project.eml.dto.EmployeeDto;
import com.project.eml.entity.Employee;
import com.project.eml.exception.ResourceNotFoundException;
import com.project.eml.mapper.EmployeeMapper;
import com.project.eml.repository.EmployeeRepo;
import com.project.eml.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

  @Override
  public EmployeeDto createEmployee(EmployeeDto employeeDto){
      Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
      Employee savedEmployee = employeeRepo.save(employee);
      return EmployeeMapper.maptoEmployeeDto(savedEmployee);
  }
  @Override
  public EmployeeDto getEmployeeById(Long employeeId){
     Employee employee= employeeRepo.findById(employeeId)
              .orElseThrow(()-> new ResourceNotFoundException("employeeNot found"+employeeId));
      return EmployeeMapper.maptoEmployeeDto(employee);

 }

    @Override
    public List<EmployeeDto> getAllemployees() {
     List<Employee> employees= employeeRepo.findAll();
        return employees.stream().map((employee) ->EmployeeMapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
      Employee employee= employeeRepo.findById(employeeId)
              .orElseThrow(() -> new ResourceNotFoundException("employee does not exists with this Id"+employeeId));

      employee.setFirstName(updatedEmployee.getFirstName());
      employee.setLastName(updatedEmployee.getLastName());
      employee.setEmail(updatedEmployee.getEmail());

      Employee updatedemployeeobj= employeeRepo.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updatedemployeeobj) ;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee= employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee does not exists with this Id"
                        +employeeId));

        employeeRepo.deleteById(employeeId);
    }

}
