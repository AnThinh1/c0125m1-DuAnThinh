package com.codegym.cinema.controller;

import com.codegym.cinema.model.Promotion;
import com.codegym.cinema.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public String listPromotions(
            @RequestParam(required = false) Long discount,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end,
            Model model) {

        LocalDate startDate = (start != null && !start.isEmpty()) ? LocalDate.parse(start) : null;
        LocalDate endDate = (end != null && !end.isEmpty()) ? LocalDate.parse(end) : null;

        List<Promotion> promotions = promotionService.search(discount, startDate, endDate);


        model.addAttribute("promotions", promotions);
        model.addAttribute("discountFilter", discount);
        model.addAttribute("startFilter", start);
        model.addAttribute("endFilter", end);

        return "promotions/list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "promotions/add";
    }

    @PostMapping("/add")
    public String addPromotion(@Valid @ModelAttribute("promotion") Promotion promotion,
                               BindingResult result) {
        validatePromotionDates(promotion, result);
        if (result.hasErrors()) return "promotions/add";

        promotionService.save(promotion);
        return "redirect:/promotions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Promotion> promotionOpt = promotionService.findById(id);
        if (promotionOpt.isEmpty()) return "redirect:/promotions";

        model.addAttribute("promotion", promotionOpt.get());
        return "promotions/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPromotion(@PathVariable Long id,
                                @Valid @ModelAttribute("promotion") Promotion promotion,
                                BindingResult result) {
        validatePromotionDates(promotion, result);
        if (result.hasErrors()) return "promotions/edit";

        promotion.setId(id);
        promotionService.save(promotion);
        return "redirect:/promotions";
    }

    @GetMapping("/delete/{id}")
    public String deletePromotion(@PathVariable Long id) {
        promotionService.deleteById(id);
        return "redirect:/promotions";
    }

    private void validatePromotionDates(Promotion promotion, BindingResult result) {
        if (promotion.getStartDate() != null && promotion.getStartDate().isBefore(LocalDate.now())) {
            result.rejectValue("startDate", "error.startDate",
                    "Thời gian bắt đầu phải lớn hơn hiện tại");
        }
        if (promotion.getStartDate() != null &&
                promotion.getEndDate() != null &&
                !promotion.getEndDate().isAfter(promotion.getStartDate())) {
            result.rejectValue("endDate", "error.endDate",
                    "Thời gian kết thúc phải lớn hơn thời gian bắt đầu");
        }
    }
}
