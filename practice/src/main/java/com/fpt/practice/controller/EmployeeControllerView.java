package com.fpt.practice.controller;

import com.fpt.practice.model.Employee;
import com.fpt.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeControllerView {
    @Autowired
    EmployeeService employeeService;

    @GetMapping({"/","/index"})
    public String getAll(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/employee/form")
    public String getForm( Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Employee employee, Model model, BindingResult bindingResult){
        Employee emp = employeeService.createEmployee(employee);
        if(emp != null){
            model.addAttribute("message", "create success");
        }else {
            model.addAttribute("message", "create error");
        }
        return "redirect:index";
    }
}
