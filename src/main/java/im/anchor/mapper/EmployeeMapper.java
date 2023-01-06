package im.anchor.mapper;

import java.util.List;

import im.anchor.entity.Employee;

public interface EmployeeMapper {
	
	public Integer insert(Employee employee);
	
	public Integer updateByPrimaryKey(Employee employee);
	
	public boolean deleteByPrimaryKey(Integer id);
	
	public Employee selectByPrimaryKey(Integer id);
	
	public List<Employee> selectAllEmployee();
	
}
