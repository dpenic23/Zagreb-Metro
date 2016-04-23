package hr.fer.zgmetro.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hr.fer.zgmetro.json.Distance;
import hr.fer.zgmetro.json.PairOfStations;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;
import hr.fer.zgmetro.model.loader.IGraphLoader;
import hr.fer.zgmetro.util.GraphUtil;
import hr.fer.zgmetro.util.IOUtil;
import hr.fer.zgmetro.util.JSONConverter;

@Controller
public class MetroTripController {

	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MetroTripController.class);

	@RequestMapping(value = "/trip/distance", method = RequestMethod.POST)
	public String calculateTripDistance(HttpServletRequest request, ModelMap model) {
		logger.debug("Received request for distance calculation.");

		try {
			String jsonRequest = IOUtil.getStringFromInputStream(request.getInputStream());
			Stations stations = JSONConverter.convertJSONStringToStations(jsonRequest);
			logger.debug("Calculating trip distance for stations: " + stations.getStations().toString());

			Graph graph = loadGraph(request);
			int distance = GraphUtil.calculateTripDistance(graph, stations.getStations());

			String returnValue;
			if (distance == -1) {
				returnValue = "NO SUCH ROUTE";
			} else {
				returnValue = distance + "";
			}

			model.addAttribute("json", JSONConverter.convertDistanceToJSONString(new Distance(returnValue)));
		} catch (Exception e) {
			logger.debug(e.getLocalizedMessage());
		}

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/trip/round/count/{station}", method = RequestMethod.GET)
	public String calculateRoundTrips(@PathVariable String station, ModelAndView modelAndView) {

		logger.debug("Round trips to be calculated...");
		// model.addAttribute("message", station);

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
	public String calculateShortestPath(HttpServletRequest request, ModelMap model) {
		logger.debug("Received request for distance calculation.");

		try {
			String jsonRequest = IOUtil.getStringFromInputStream(request.getInputStream());
			PairOfStations stations = JSONConverter.convertJSONStringToPairOfStations(jsonRequest);
			logger.debug("Calculating shortest path between stations.");

			Graph graph = loadGraph(request);
			int distance = GraphUtil.calculateShortestDistance(graph, stations.getStations().get("start"),
					stations.getStations().get("end"));

			String returnValue;
			if (distance == -1) {
				returnValue = "NO SUCH ROUTE";
			} else {
				returnValue = distance + "";
			}

			model.addAttribute("json", returnValue);
		} catch (Exception e) {
			logger.debug(e.getLocalizedMessage());
		}
		return VIEW_INDEX;
	}

	private Graph loadGraph(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/") + "WEB-INF/metro.txt";
		IGraphLoader graphLoader = new FileLoader(path);
		return graphLoader.load();
	}

}