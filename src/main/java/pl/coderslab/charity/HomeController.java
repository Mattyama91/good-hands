package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;

    public HomeController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
//        model.addAttribute("instytution", institutionRepository.findById(Long.parseLong("1")));
        model.addAttribute("instytutions", institutionRepository.findAll());
        return "index";
    }
}
