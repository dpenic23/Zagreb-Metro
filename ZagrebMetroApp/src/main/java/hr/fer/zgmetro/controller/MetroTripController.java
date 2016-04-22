package hr.fer.zgmetro.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MetroTripController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MetroTripController.class);

	@RequestMapping(value = "/trip/distance", method = RequestMethod.POST)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Zivot je cudo");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/trip/round/count/{station}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String station, ModelMap model) {

		model.addAttribute("message", "Welcomesfadsfadg " + station);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/trip/count", method = RequestMethod.POST)
	public String welcomeNamenla(@PathVariable String station, ModelMap model) {

		model.addAttribute("message", "Welcomesfadsfadg " + station);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/trip/shortest", method = RequestMethod.POST)
	public String welcomeShortest(ModelMap model) {

		model.addAttribute("message", "Zivot je cudo");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

}