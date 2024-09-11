package com.chambers.employeemgrserver.domain.employee.services;

import com.chambers.employeemgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.chambers.employeemgrserver.domain.core.exceptions.ResourceCreationException;
import com.chambers.employeemgrserver.domain.employee.models.Employee;
import com.chambers.employeemgrserver.domain.employee.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) throws ResourceCreationException {
        Optional<Employee> optional = employeeRepository.findByEmail(employee.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Employee with email exists: " + employee.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with id: " + id));
    }

    @Override
    public Employee getByEmail(String email) throws ResourceNotFoundException {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with email: " + email));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException {
        Employee employee = getById(id);
        employee.setFirstName(employeeDetail.getFirstName());
        employee.setLastName(employeeDetail.getLastName());
        employee.setEmail(employeeDetail.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
    }
}
