package im.anchor.service;

import java.util.List;

import im.anchor.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(Integer id);

	public void add(Employee employee);

	public void update(Employee employee);

	public void delete(Integer id);
}
