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

import camping.model.Client;
import service.ClientService;

@Controller
public class ClientController {

	@RequestMapping(value="/clients", method = RequestMethod.GET)
	public String list(Model model) {
		ClientService cs = ClientService.getInstance();
		List<Client> clients = cs.getAllClients();
		model.addAttribute("clients", clients);
		return "clients_list";
	}

	@RequestMapping(value="/clients/view/{clientId}", method = RequestMethod.GET)
	public String show(@PathVariable("clientId") int clientId, Model model) {
		ClientService cs = ClientService.getInstance();
		//Client c = cs.getClient(clientId);

		model.addAttribute("content", "Client " + clientId);
		return "clients_view";
	}
	
	@RequestMapping(value="/clients/create", method = RequestMethod.GET)
	public String create(Model model) {
		Map<String,String> identityTypes = new LinkedHashMap<String,String>();
		identityTypes.put("CI", "Carte d'identité");
		identityTypes.put("PS", "Passeport");
		identityTypes.put("PC", "Permis de conduire");
		
		model.addAttribute("identityTypes", identityTypes);
		model.addAttribute("client", new Client());
		return "clients_create";
	}

	@RequestMapping(value="/clients/edit/{clientId}", method = RequestMethod.GET)
	public String edit(@PathVariable("clientId") int clientId, Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "clients_edit";
	}

	@RequestMapping(value="/clients/store", method = RequestMethod.POST)
	public String store(@ModelAttribute("client") Client client, BindingResult result, Model model) {
		System.out.println(client.toString());
		ClientService cs = ClientService.getInstance();
		cs.storeClient(client);	
		
		return "redirect:/clients";
	}

	@RequestMapping(value="/clients/update", method = RequestMethod.POST)
	public void update(@ModelAttribute("client") Client client, BindingResult result, Model model) {
		// TODO Update client
		
	}

	@RequestMapping(value="/clients/delete/{clientId}", method = RequestMethod.GET)
	public String destroy(@PathVariable("clientId") int clientId, Model model) {
		ClientService cs = ClientService.getInstance();
		cs.deleteClient(clientId);
		
		return "redirect:/clients";		
	}

}