package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Hiển thị danh sách khách hàng
    @GetMapping
    public ModelAndView showList() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    // Hiển thị thông tin khách hàng cụ thể
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable("id") Long id) {
        Customer customer = customerService.findOne(id);
        ModelAndView modelAndView = new ModelAndView("customers/info");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    // Cập nhật thông tin khách hàng
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
}
