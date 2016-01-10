package camping.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import camping.model.Client;
import camping.model.Stay;
import service.ClientService;
import service.StayService;

@Controller
public class StayController {

	@RequestMapping(value="/stays", method = RequestMethod.GET)
	public String list(Model model) {
		StayService ss = StayService.getInstance();
		List<Stay> stays = ss.getAllStays();
		model.addAttribute("stays", stays);
		return "stays_list";
	}
	
	@RequestMapping(value="/stays/view/{stayId}", method = RequestMethod.GET)
	public String show(@PathVariable("stayId") int stayId, Model model) {
		model.addAttribute("content", "Client " + stayId);
		return "stays_view";
	}
	
	@RequestMapping(value="/stays/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		ClientService cs = ClientService.getInstance();
		List<Client> clients = cs.getAllClients();
		Map<String,String> clientsChoice = new LinkedHashMap<String,String>();
		for (Client c : clients) {
			clientsChoice.put(Integer.toString(c.getId()), c.getName());
		}		
		model.addAttribute("clients", clientsChoice);
		
		model.addAttribute("stay", new Stay());
		return "stays_create";
	}
	
	@RequestMapping(value="/stays/store", method = RequestMethod.POST)
	public String store(@ModelAttribute("stay") Stay stay, BindingResult result, Model model) {
		System.out.println(stay.toString());
		StayService cs = StayService.getInstance();
		cs.storeStay(stay);	
		
		return "redirect:/stays";
	}
	
	@RequestMapping(value="/stays/edit/{stayId}", method = RequestMethod.GET)
	public String edit(@PathVariable("stayId") int stayId, Model model) {
		Stay stay = new Stay();
		model.addAttribute("stay", stay);
		return "stays_edit";
	}
	
	@RequestMapping(value="/stays/delete/{stayId}", method = RequestMethod.GET)
	public String destroy(@PathVariable("stayId") int stayId, Model model) {
		StayService cs = StayService.getInstance();
		cs.deleteStay(stayId);
		
		return "redirect:/stays";		
	}
	
	@RequestMapping(value="/stays/invoice/{stayId}", method = RequestMethod.GET)
	public ModelAndView invoice(@PathVariable("stayId") int stayId, Model model) {
		ModelAndView modelAndView = new ModelAndView("invoicePdf", "command", "hello");
		  
		return modelAndView;
	}
	
	@RequestMapping(value="/stays/invoiceSports/{stayId}", method = RequestMethod.GET)
	public ModelAndView invoiceSports(@PathVariable("stayId") int stayId, Model model) {
		ModelAndView modelAndView = new ModelAndView("invoiceSportsPdf", "command", "hello");
		  
		return modelAndView;
	}

}