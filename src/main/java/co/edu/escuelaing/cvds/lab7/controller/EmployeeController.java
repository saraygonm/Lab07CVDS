package co.edu.escuelaing.cvds.lab7.controller;


import co.edu.escuelaing.cvds.lab7.model.Employee;

import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String employees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("trabajadores", employees); 
        return "Employee/employeeList";  
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employee/list";
    }
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable String id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}


