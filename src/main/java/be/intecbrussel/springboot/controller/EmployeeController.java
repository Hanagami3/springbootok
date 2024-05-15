package be.intecbrussel.springboot.controller;

import be.intecbrussel.springboot.model.Employee;
import be.intecbrussel.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        Employee employee = new Employee();
        //Thymeleaf template will access this empty employee object for binding form data
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
