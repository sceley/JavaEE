package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import model.Station;
import model.Train;
import service.StationService;
import service.TrainService;

public class TrainAction implements ModelDriven<Train> {
	private TrainService trainService;
	private StationService stationService;

	private Train train = new Train();

	@Override
	public Train getModel() {
		// TODO Auto-generated method stub
		return train;
	}

	public TrainService getTrainService() {
		return trainService;
	}

	public void setTrainService(TrainService trainService) {
		this.trainService = trainService;
	}

	public StationService getStationService() {
		return stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String showTrain() {
		List<Train> trains = trainService.findAll();
		ActionContext.getContext().getValueStack().set("trains", trains);
		return "success";
	}

	public String showCreateTrain() {
		 List<Station> stations = stationService.findAll();
		 ActionContext.getContext().getValueStack().set("stations", stations);
		return "success";
	}

	public String create() {
		Boolean bool = trainService.create(train);
		if (bool) {
			return "success";
		} else {
			return "failure";
		}
		
	}
	
	public String delete() {
		trainService.delete(train.getTrainId());
		return "success";
	}

}
