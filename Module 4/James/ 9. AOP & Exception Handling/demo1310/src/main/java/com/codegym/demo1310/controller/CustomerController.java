package com.codegym.demo1310.controller;

import com.codegym.demo1310.exception.DuplicateEmailException;
import com.codegym.demo1310.model.Customer;
import com.codegym.demo1310.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/customer/inputs-not-acceptable");
    }

    @GetMapping("")
    public String index(Model model) throws Exception{
        Iterable<Customer> customerList = customerService.findAll();
//        Iterable<Customer> customerList = customerService.findAllWithException();
        model.addAttribute("customers", customerList);
        return "/customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    /*@PostMapping("/save")
    public String save(Customer customer) throws Exception{
        //customerService.save(customer);
        customerService.saveWithException(customer);
        return "redirect:/customers";
    }*/

    @PostMapping("/save")
    public String save(Customer customer) throws DuplicateEmailException {
        //customerService.save(customer);
        //customerService.saveWithException(customer);
        customerService.saveWithDuplicateEmailException(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
