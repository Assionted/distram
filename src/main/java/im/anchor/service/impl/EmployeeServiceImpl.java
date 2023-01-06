package im.anchor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import im.anchor.entity.Employee;
import im.anchor.mapper.EmployeeMapper;
import im.anchor.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.selectAllEmployee();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
