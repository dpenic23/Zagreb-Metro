package hr.fer.zgmetro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;
import hr.fer.zgmetro.model.loader.IGraphLoader;

@Controller
public class MetroTripController {

	private static IGraphLoader graphLoader = new FileLoader("/src/main/resources/metro.txt");
	private static Graph metroGraph = graphLoader.load();
	
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MetroTripController.class);

	// POST
	@RequestMapping(value = "/trip/distance", method = RequestMethod.POST)
	public String calculateTripDistance(@RequestBody final Stations stationsReceived, ModelMap model) {

		// logger.debug("[welcome] counter : {}", counter);

		List<String> stations = new ArrayList<String>();
		
		
		logger.debug("Distance to be calculated...");
		//model.addAttribute("message", "Distance to be calculated...");
		//model.addAttribute("message", stations.getStations().get(0));
		
		// Distance distance = new Distance();
		// distance.setDistance(3);

		return VIEW_INDEX;

	}

	@RequestMapping(value = "/trip/round/count/{station}", method = RequestMethod.GET)
	public String calculateRoundTrips(@PathVariable String station, ModelMap model) {

		logger.debug("Round trips to be calculated...");
		model.addAttribute("message", "Round trips to be calculated...");

		return VIEW_INDEX;

	}

	// POST
	@RequestMapping(value = "/trip/count", method = RequestMethod.POST)
	public String calculateTrips(@PathVariable String station, ModelMap model) {

		logger.debug("Trips to be calculated...");
		model.addAttribute("message", "Trips to be calculated...");

		return VIEW_INDEX;

	}

	// POST
	@RequestMapping(value = "/trip/shortest", method = RequestMethod.POST)
	public String calculateShortestPath(ModelMap model) {

		logger.debug("Shortest path to be calculated...");
		model.addAttribute("message", "Shortest path to be calculated...");

		return VIEW_INDEX;
	}

}