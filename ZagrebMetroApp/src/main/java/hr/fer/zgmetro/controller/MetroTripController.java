package hr.fer.zgmetro.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hr.fer.zgmetro.json.Distance;
import hr.fer.zgmetro.json.PairOfStations;
import hr.fer.zgmetro.json.PathsWithStops;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.json.StationsWithStops;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Path;
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
	public String calculateRoundTrips(HttpServletRequest request, @PathVariable String station, Model model)
			throws Exception {
		int max = 3;
		LinkedList<Path> paths = (LinkedList<Path>) GraphUtil.findRoundTripsWithStopsLimit(loadGraph(request), station,
				max);

		List<String> list = new ArrayList<>();
		for (Path p : paths) {
			list.add(p.toString());
		}
		model.addAttribute("json",
				JSONConverter.convertPathsWithStopstoJSONString(new PathsWithStops(paths.size(), list)));

		return VIEW_INDEX;

	}

	// POST
	@RequestMapping(value = "/trip/count", method = RequestMethod.POST)
	public String calculateTrips(HttpServletRequest request, Model model) throws Exception {
		String jsonRequest = IOUtil.getStringFromInputStream(request.getInputStream());
		StationsWithStops stationsWithStops = JSONConverter.convertJSONStringtoStationsWithStops(jsonRequest);

		List<Path> paths = GraphUtil.findTripsWithStopsLimit(loadGraph(request),
				stationsWithStops.getStations().get("start"), stationsWithStops.getStations().get("end"),
				stationsWithStops.getStops());

		List<String> list = new ArrayList<>();
		for (Path p : paths) {
			p.removeStart();
			p.removeEnd();
			list.add(p.toString());
		}
		model.addAttribute("json",
				JSONConverter.convertPathsWithStopstoJSONString(new PathsWithStops(paths.size(), list)));

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

			model.addAttribute("json", JSONConverter.convertDistanceToJSONString(new Distance(returnValue)));
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