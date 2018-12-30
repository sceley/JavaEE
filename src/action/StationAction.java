package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import model.Station;
import service.StationService;

public class StationAction implements ModelDriven<Station> {
	private StationService stationService;
	private Station station = new Station();

	@Override
	public Station getModel() {
		// TODO Auto-generated method stub
		return station;
	}

	public StationService getStationService() {
		return stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String create() {
		stationService.create(station);
		return "success";
	}

	public String showStation() {
		List<Station> stations = stationService.findAll();
		ActionContext.getContext().getValueStack().set("stations", stations);
		return "success";
	}
	
	public String showCreateStation () {
		return "success";
	}

	public String delete() {
		stationService.delete(station.getStationId());
		return "success";
	}

}
