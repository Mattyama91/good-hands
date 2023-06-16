package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRespository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRespository donationRespository;

    public HomeController(InstitutionRepository institutionRepository, DonationRespository donationRespository) {
        this.institutionRepository = institutionRepository;
        this.donationRespository = donationRespository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("donations", donationRespository.count());
        model.addAttribute("instytutions", institutionRepository.findAll());
        return "index";
    }
}
