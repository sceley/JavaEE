package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.StationDao;
import model.Station;

@Transactional
public class StationService {
	private StationDao stationDao;

	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}
	
	public List<Station> findAll () {
		return stationDao.findAll();
	}

	public void create(Station station) {
		stationDao.create(station);
	}

	public void delete(int stationId) {
		Station station = stationDao.findById(stationId);
		stationDao.delete(station);
	}
}
