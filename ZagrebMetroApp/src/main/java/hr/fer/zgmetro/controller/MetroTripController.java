package hr.fer.zgmetro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.util.IOUtil;
import hr.fer.zgmetro.util.JSONConverter;

@Controller
public class MetroTripController {

	// private static IGraphLoader graphLoader = new
	// FileLoader("/src/main/resources/metro.txt");
	// private static Graph metroGraph = graphLoader.load();

	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MetroTripController.class);

	// POST
	@RequestMapping(value = "/trip/distance", method = RequestMethod.POST)
	public String calculateTripDistance(HttpServletRequest request, ModelMap model) {
		logger.debug("Received request for distance calculation.");
		logger.debug("Calculating trip distance...");

		try {
			String jsonRequest = IOUtil.getStringFromInputStream(request.getInputStream());
			Stations stations = JSONConverter.convertJSONStringToStations(jsonRequest);
			logger.debug(stations.getStations().toString());
		} catch (Exception e) {
			logger.debug(e.getLocalizedMessage());
		}

		List<String> stations = new ArrayList<String>();

		// model.addAttribute("message", "Distance to be calculated...");
		// model.addAttribute("message", stations.getStations().get(0));

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