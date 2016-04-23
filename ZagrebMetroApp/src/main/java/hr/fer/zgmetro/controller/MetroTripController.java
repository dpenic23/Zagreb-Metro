package hr.fer.zgmetro.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hr.fer.zgmetro.json.Distance;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.util.IOUtil;
import hr.fer.zgmetro.util.JSONConverter;

@Controller
public class MetroTripController {

	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MetroTripController.class);

	// POST
	@RequestMapping(value = "/trip/distance", method = RequestMethod.POST)
	public String calculateTripDistance(HttpServletRequest request, ModelMap model) {
		logger.debug("Received request for distance calculation.");

		try {
			String jsonRequest = IOUtil.getStringFromInputStream(request.getInputStream());
			Stations stations = JSONConverter.convertJSONStringToStations(jsonRequest);
			logger.debug("Calculating trip distance for stations: " + stations.getStations().toString());
		} catch (Exception e) {
			logger.debug(e.getLocalizedMessage());
		}

		List<String> stations = new ArrayList<String>();

		String a =request.getServletContext().getRealPath("/") + "WEB-INF/metro.txt";
		File file = new File(a);
		logger.debug(file.exists() + "");
		// model.addAttribute("message", "Distance to be calculated...");
		// model.addAttribute("message", stations.getStations().get(0));

		Distance distance = new Distance();
		distance.setDistance(3);
		

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/trip/round/count/{station}", method = RequestMethod.GET)
	public String calculateRoundTrips(@PathVariable String station, ModelMap model) {

		logger.debug("Round trips to be calculated...");
		model.addAttribute("message", station);

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