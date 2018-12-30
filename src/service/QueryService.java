package service;

import java.util.ArrayList;
import java.util.List;

import dao.LinkDao;
import dao.StationDao;
import dao.TrainDao;
import model.Link;
import model.Query;
import model.Station;
import model.Train;

public class QueryService {
	private TrainDao trainDao;
	private LinkDao linkDao;
	private StationDao stationDao;

	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}

	public TrainDao getTrainDao() {
		return trainDao;
	}

	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
	}

	public LinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public List<Query> query(Query query) {
		List<Station> startStations = stationDao.findByName(query.getStartStation().getStationName());
		List<Station> endStations = stationDao.findByName(query.getEndStation().getStationName());
		Station startStation = null, endStation = null;
		if (endStations.size() > 0) {
			startStation = startStations.get(0);
		}
		if (endStations.size() > 0) {
			endStation = endStations.get(0);
		}
		List<Train> trains = trainDao.queryByStartEnd(startStation, endStation);
		List<Query> querys = new ArrayList<Query>();

		for (Train train : trains) {
			Query query1 = new Query();
			query1.setCapacity(train.getCapacity());
			query1.setCenter(train.getCenter());
			query1.setCenterTime(train.getCenterTime());
			query1.setDestination(train.getDestination());
			query1.setSource(train.getSource());
			query1.setTime(train.getTime());
			query1.setTrainNumber(train.getTrainNumber());
			query1.setTrainId(train.getTrainId());

			query1.setStartStation(startStation);
			query1.setEndStation(endStation);

			int startStationId = startStation.getStationId();
			int endStationId = endStation.getStationId();
			int sourceStationId = train.getSource().getStationId();
			int centerStationId = train.getCenter().getStationId();
			int destinationStationId = train.getDestination().getStationId();
			if (startStationId == sourceStationId && endStationId == centerStationId) {
				Link link = linkDao.findSrcDest(startStationId, endStationId).get(0);
				query1.setPrice(link.getPrice());
			} else if (startStationId == sourceStationId && endStationId == destinationStationId) {
				Link link1 = linkDao.findSrcDest(startStationId, centerStationId).get(0);
				Link link2 = linkDao.findSrcDest(centerStationId, endStationId).get(0);
				query1.setPrice(link1.getPrice() + link2.getPrice());
			} else if (startStationId == centerStationId && endStationId == destinationStationId) {
				Link link = linkDao.findSrcDest(startStationId, endStationId).get(0);
				query1.setPrice(link.getPrice());
			}
			querys.add(query1);
		}
		return querys;
	}
	
	public List advancedQuery (Query query) {
		List<Station> startStations = stationDao.findByName(query.getStartStation().getStationName());
		List<Station> endStations = stationDao.findByName(query.getEndStation().getStationName());
		Station startStation = null, endStation = null;
		if (endStations.size() > 0) {
			startStation = startStations.get(0);
		}
		if (endStations.size() > 0) {
			endStation = endStations.get(0);
		}
		List<Train> starts = trainDao.queryByStart(startStation);
		List<Train> centers = trainDao.queryByCenter(startStation);
		List<Query> querys = new ArrayList<Query>();
		return null;
	}

}
