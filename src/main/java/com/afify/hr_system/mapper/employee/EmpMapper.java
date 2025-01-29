package com.afify.hr_system.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.afify.hr_system.mapper.dependent.DependentMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.Employee;

@Mapper(componentModel = "spring", uses = {DependentMapper.class})
public interface EmpMapper {

    // Entity -> DTO
    @Mapping(target = "full_name", expression = "java(combineNames(emp.getFname(), emp.getLname()))")
    @Mapping(source = "bdate", target = "birthdate")
    @Mapping(source = "manager.ssn", target = "manager_ssn")
    @Mapping(source = "department.departmentNumber", target = "department_number")
    @Mapping(source = "department.dname", target = "department_name")
    EmpDTO empToDto(Employee emp);

    // DTO -> Entity
    @Mapping(target = "fname", source = "full_name", qualifiedByName = "extractFirstName")
    @Mapping(target = "lname", source = "full_name", qualifiedByName = "extractLastName")
    @Mapping(source = "birthdate", target = "bdate")
    @Mapping(target = "manager", expression = "java(mapManager(empDto.getManager_ssn()))")
    @Mapping(target = "department", expression = "java(mapDepartment(empDto.getDepartment_number()))")
    @Mapping(target = "dependents", ignore = true)
    @Mapping(target = "pouns", ignore = true)  // Fix typo if this is incorrect
    Employee mapToEntity(EmpDTO empDto);

    // Helper methods
    default String combineNames(String firstName, String lastName) {
        if (firstName == null) return lastName != null ? lastName : "";
        if (lastName == null) return firstName;
        return firstName + " " + lastName;
    }

    @Named("extractFirstName")
    default String extractFirstName(String fullName) {
        if (fullName == null || fullName.isEmpty()) return "";
        String[] parts = fullName.split("\\s+", 2);
        return parts[0];
    }

    @Named("extractLastName")
    default String extractLastName(String fullName) {
        if (fullName == null || fullName.isEmpty()) return "";
        String[] parts = fullName.split("\\s+", 2);
        return parts.length > 1 ? parts[1] : "";
    }

    default Employee mapManager(Integer managerSsn) {
        if (managerSsn == null) return null;
        Employee emp = new Employee();
        emp.setSsn(managerSsn);
        return emp;
    }

    default Department mapDepartment(Integer departmentNumber) {
        if (departmentNumber == null) return null;
        Department dept = new Department();
        dept.setDepartmentNumber(departmentNumber);
        return dept;
    }
}