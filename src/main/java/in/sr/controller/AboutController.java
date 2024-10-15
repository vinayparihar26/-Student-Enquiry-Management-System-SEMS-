package in.sr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AboutController {

	@GetMapping({"/contact"})
	   public String contact(Model model) {
		model.addAttribute("con", new AboutController());
	      return "contact";
	   }
	
    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("ab", new AboutController());
    	return "about"; // This will map to about.html
    }
}