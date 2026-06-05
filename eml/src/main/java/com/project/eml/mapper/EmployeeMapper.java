package com.project.eml.mapper;

import com.project.eml.dto.EmployeeDto;
import com.project.eml.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto( Employee employeeDto){
      return new EmployeeDto(
               employeeDto.getId(),
               employeeDto.getFirstName(),
               employeeDto.getLastName(),
               employeeDto.getEmail()
  );  }

    public static Employee maptoEmployee(EmployeeDto employee){
        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
