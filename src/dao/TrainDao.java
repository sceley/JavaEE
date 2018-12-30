package dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import model.Query;
import model.Station;
import model.Train;

public class TrainDao extends HibernateDaoSupport {
	public Train findById(int trainId) {
		return this.getHibernateTemplate().get(Train.class, trainId);
	}

	public List<Train> findAll() {
		String hql = "from Train";
		return (List<Train>) this.getHibernateTemplate().find(hql);
	}

	public void create(Train train) {
		this.getHibernateTemplate().save(train);
	}

	public void delete(Train train) {
		this.getHibernateTemplate().delete(train);
	}

	public List<Train> queryByStartEnd(Station startStation, Station endStation) {
		int startStationId = startStation.getStationId();
		int endStationId = endStation.getStationId();
		String hql = "from Train where (sourceId=:startStationId and centerId=:endStationId) "
				+ "or (sourceId=:startStationId and destinationId=:endStationId)"
				+ "or (centerId=:startStationId and destinationId=:endStationId)";
		String[] paramNames = new String[] { "startStationId", "endStationId" };
		Object[] values = new Object[] { startStationId, endStationId };
		return (List<Train>) this.getHibernateTemplate().findByNamedParam(hql, paramNames, values);
	}
	
	public List<Train> queryByStart(Station station) {
		int stationId = station.getStationId();
		String hql = "from Train where sourceId:=stationId";
		return (List<Train>) this.getHibernateTemplate().findByNamedParam(hql, "stationId", stationId);
	}
	
	public List<Train> queryByCenter(Station station) {
		int stationId = station.getStationId();
		String hql = "from Train where centerId=:stationId";
		return (List<Train>) this.getHibernateTemplate().findByNamedParam(hql, "stationId", stationId);
	}
}
