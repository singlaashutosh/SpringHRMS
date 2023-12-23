package com.example.hrms.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Optional;

import javax.swing.text.View;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hrms.model.Employee;
import com.example.hrms.service.EmployeeService;



@Controller
class HRMSMVCController{

@Autowired
EmployeeService eService ;





@GetMapping("/")
public String viewHomePage(Model model) {
    model.addAttribute("allemplist", this.eService.findAllEmp());
    return "home";
}

@GetMapping("/login")
public String loginpage() {
    return "login";
}


@GetMapping("/addnew")
public String addNewEmployee(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "newemployee";
}

@PostMapping("/save")
public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    this.eService.addEmp(employee);
    return "redirect:/";
}

@GetMapping("/showFormForUpdate/{id}")
public String updateForm(@PathVariable(value = "id") int id, Model model) {
    Optional<Employee> employee = this.eService.getEmp(id);
    model.addAttribute("employee", employee);
    return "update";
}

@GetMapping("/deleteEmployee/{id}")
public String deleteThroughId(@PathVariable(value = "id") int id) {
    this.eService.deleteEmp(id);
    return "redirect:/";

}



}