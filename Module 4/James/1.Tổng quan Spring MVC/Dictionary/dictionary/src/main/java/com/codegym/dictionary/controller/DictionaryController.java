package com.codegym.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.codegym.dictionary.model.Dictionary;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionaryData = new HashMap<>();

    static {
        dictionaryData.put("hello", "xin chào");
        dictionaryData.put("apple", "quả táo");
        dictionaryData.put("dog", "con chó");
    }

    @GetMapping("/dictionary")
    public String showForm(Model model) {
        model.addAttribute("dictionary", new Dictionary());
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(@ModelAttribute("dictionary") Dictionary dictionary, Model model) {
        String word = dictionary.getEnglish().toLowerCase();
        String result = dictionaryData.getOrDefault(word, "Không tìm thấy từ này!");
        dictionary.setVietnamese(result);

        model.addAttribute("dictionary", dictionary);
        return "dictionary";
    }
}
