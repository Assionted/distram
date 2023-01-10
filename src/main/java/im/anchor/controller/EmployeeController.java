package im.anchor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import im.anchor.dto.Result;
import im.anchor.entity.Employee;
import im.anchor.service.EmployeeService;

@RestController
public class EmployeeController<T> {

    @Autowired
    private EmployeeService employeeService;
    
    private Result<T> result = new Result<T>();

    /**
     * 查询所有员工信息
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
	@GetMapping("/emp")
    public Result<T> findAll(){
        List<Employee> list = null;
    	try {
    		list = employeeService.findAll();
    		result.setCode(200);
    		result.setMessage("请求成功");
		} catch (Exception e) {
			result.setCode(500);
    		result.setMessage("请求失败");
		} finally {
			result.setData((T) list);
		}
        
        return result;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return employeeService.findById(id);
    }

    /**
     * 添加
     * @param employee
     */
    @PostMapping("/emp")
    public void add(Employee employee){
        employeeService.add(employee);
    }

    /**
     * 修改，这里接收前端发来的JSON格式的数据
     * @param employee
     */
    @PutMapping("/emp")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    /**
     * 删除数据
     * @param id
     */
    @DeleteMapping("/emp/{id}")
    public void delete(@PathVariable("id") Integer id){
        employeeService.delete(id);
    }
}
