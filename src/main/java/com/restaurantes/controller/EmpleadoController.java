package com.restaurantes.controller;

import com.restaurantes.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {

    private EmployeeRepository employeeRepository;

    public EmpleadoController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("restaurants/employee-list")
    public String employeeList(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "restaurants/employee-list";
    }
}
