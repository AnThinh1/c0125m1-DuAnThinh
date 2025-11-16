package com.codegym.commencalstore.controller;

import com.codegym.commencalstore.model.Bike;
import com.codegym.commencalstore.service.BikeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }
    @GetMapping("/add")
    public String addBikeForm(Model model) {
        model.addAttribute("bike", new Bike());
        return "bike/add";
    }

    @PostMapping("/add")
    public String addBike(@Valid @ModelAttribute("bike") Bike bike,
                          BindingResult result,
                          @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (result.hasErrors()) {
            return "bike/add";
        }

        if (!imageFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            Path uploadPath = Paths.get("src/main/resources/static/bike-images/"); // folder trong static
            Files.createDirectories(uploadPath);

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            bike.setImageUrl("/bike-images/" + fileName); // <--- đường dẫn đúng
        }

        bikeService.save(bike);
        return "redirect:/bikes";
    }



    @GetMapping("/edit/{id}")
    public String editBikeForm(@PathVariable Long id, Model model) {
        Bike bike = bikeService.findById(id);
        if (bike == null) return "redirect:/bikes";
        model.addAttribute("bike", bike);
        return "bike/edit";
    }

    @PostMapping("/edit")
    public String editBike(@Valid @ModelAttribute("bike") Bike bike,
                           BindingResult result,
                           @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (result.hasErrors()) {
            return "bike/edit";
        }

        Bike existingBike = bikeService.findById(bike.getId());

        if (!imageFile.isEmpty()) {
            // Upload file mới
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            Path uploadPath = Paths.get("src/main/resources/static/bike-images/");
            Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            bike.setImageUrl("/bike-images/" + fileName);
        } else {
            // Giữ ảnh cũ
            bike.setImageUrl(existingBike.getImageUrl());
        }

        bikeService.save(bike);
        return "redirect:/bikes";
    }


    @GetMapping("/delete/{id}")
    public String deleteBike(@PathVariable Long id) {
        bikeService.delete(id);
        return "redirect:/bikes";
    }

    @GetMapping
    public String listBikes(@RequestParam(required = false) String category,
                            @RequestParam(required = false) String sort,
                            Model model) {
        List<Bike> bikes = bikeService.filterAndSort(category, sort);
        model.addAttribute("bikes", bikes);
        return "bike/list";
    }
}
