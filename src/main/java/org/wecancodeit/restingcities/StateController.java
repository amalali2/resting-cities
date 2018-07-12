package org.wecancodeit.restingcities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StateController {
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@RequestMapping("/")
	public String home() {
		return "redirect: /states";
		
	}
	
	@RequestMapping("/states")
	public String getStates(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "states";
	}
	
	@RequestMapping(value = "/states", method = RequestMethod.POST)
	public String addState(String name, String motto, String abbreviation, String citiesUrl, Fish fish) {
		stateRepo.save(new State(name, motto, abbreviation, citiesUrl, fish));
		return "redirect:/states";
	}
	
	@RequestMapping("/states/{abbreviation}")
	public String getState(@PathVariable(name="abbreviation") String abbreviation, Model model) {
		model.addAttribute("state", stateRepo.findByAbbreviation(abbreviation));
		return "state";
	}
	
	@RequestMapping("/states/{abbreviation}/fish")
	public String getFish(@PathVariable(name = "abbreviation") String abbreviation, Model model) {
		model.addAttribute("state", stateRepo.findByAbbreviation(abbreviation));
		return "fish";
	}
	
	@RequestMapping("/states/{abbreviation}/cities/{id}")
	public String getCity(
			@PathVariable(name="abbreviation") String abbreviation,
			@PathVariable(name="id") Long id,
			Model model) {
		model.addAttribute("city", cityRepo.findOne(id));
		return "city";
	}
}
