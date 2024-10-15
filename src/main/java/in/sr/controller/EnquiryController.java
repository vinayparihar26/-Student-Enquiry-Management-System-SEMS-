package in.sr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.sr.entity.Enquiry;
import in.sr.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class EnquiryController {
   @Autowired
   private EnquiryService es;

   @GetMapping({"/enquiry"})
   public String addEnq(Model m) {
      m.addAttribute("enq", new Enquiry());
      return "addenquiry";
   }

   @PostMapping({"/enquiry"})
   public String saveEnq(Model m, Enquiry enqu, HttpServletRequest req) {
      HttpSession session = req.getSession(false);
      Integer id = (Integer)session.getAttribute("cid");
      boolean status = this.es.addEnquiry(enqu, id);
      if (status) {
         m.addAttribute("smsg", "Enquiry saved..!");
      } else {
         m.addAttribute("emsg", "Enquiry not saved..!");
      }

      m.addAttribute("enq", new Enquiry());
      return "addenquiry";
   }

   @GetMapping({"/enquiries"})
   public String getEnq(Model m, HttpServletRequest req) {
      HttpSession session = req.getSession(false);
      Integer cid = (Integer)session.getAttribute("cid");
      List<Enquiry> list = this.es.getEnquiries(new Enquiry(), cid);
      m.addAttribute("enqs", list);
      m.addAttribute("enq", new Enquiry());
      return "viewpage";
   }

   @PostMapping({"/filterenq"})
   public String filterEnq(@ModelAttribute("enq") Enquiry enq, Model m, HttpServletRequest req) {
      HttpSession session = req.getSession(false);
      Integer id = (Integer)session.getAttribute("cid");
      List<Enquiry> list = this.es.getEnquiries(enq, id);
      m.addAttribute("enqs", list);
      return "viewpage";
   }

   @GetMapping({"/edit/{eid}"})
   public String editEnq(@PathParam("eid") Integer eid, Model m) {
      Enquiry enquiry = this.es.getEnquiry(eid);
      m.addAttribute("enq", enquiry);
      return "addenquiry";
   }
   
   @PostMapping({"/delete"})
   public String deleteEnquiry(@RequestParam("eid") Integer enquiryId, RedirectAttributes redirectAttributes) {
       try {
           es.deleteEnquiry(enquiryId); // Your service method for deletion
           redirectAttributes.addFlashAttribute("smsg", "Enquiry deleted successfully!");
       } catch (Exception e) {
           redirectAttributes.addFlashAttribute("emsg", "Failed to delete enquiry: " + e.getMessage());
       }
       return "redirect:/enquiries"; // Redirect to the list of enquiries
   }

}
