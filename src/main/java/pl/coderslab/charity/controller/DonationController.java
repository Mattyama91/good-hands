package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRespository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DonationController {

    private CategoryRepository categoryRepository;
    private DonationRespository donationRespository;
    private InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRespository donationRespository, InstitutionRepository institutionRepository){
        this.categoryRepository = categoryRepository;
        this.donationRespository = donationRespository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("form")
    public String formAction(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("intytutions", institutionRepository.findAll());
        return "form";
    }

//    @ResponseBody
    @PostMapping("summary")
    public String formComfirmation(@RequestParam String categoryId, Donation donation){

        List<Category> categories = Arrays.stream(categoryId.split(","))
                .map(c-> categoryRepository.findById(Long.parseLong(c)).orElse(null))
                .collect(Collectors.toList());

        donation.setCategories(categories);

        donationRespository.save(donation);
        return "formComfirmation";
    }
}
