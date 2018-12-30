package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.LinkDao;
import dao.TrainDao;
import model.Link;
import model.Train;

@Transactional
public class TrainService {
	private TrainDao trainDao;
	private LinkDao linkDao;

	public LinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public TrainDao getTrainDao() {
		return trainDao;
	}

	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
	}
	
	public List<Train> findAll () {
		return trainDao.findAll();
	}

	public boolean create(Train train) {
		int sourceStationId = train.getSource().getStationId();
		int centerStationId = train.getCenter().getStationId();
		int destinationStationId = train.getDestination().getStationId();
		
		List<Link> links1 = linkDao.findSrcDest(sourceStationId, centerStationId);
		List<Link> links2 = linkDao.findSrcDest(centerStationId, destinationStationId);
		if (links1.isEmpty() || links2.isEmpty()) {
			return false;
		} else {
			trainDao.create(train);
			return true;			
		}
	}

	public void delete(int trainId) {
		Train train = trainDao.findById(trainId);
		trainDao.delete(train);
	}
}
