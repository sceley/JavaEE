package dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import model.Admin;
import model.Station;

public class StationDao extends HibernateDaoSupport {
	public Station findById(int stationId) {
		return this.getHibernateTemplate().get(Station.class, stationId);
	}
	
	public List<Station> findByName(String stationName) {
		String hql = "from Station where stationName=:stationName";
		return (List<Station>) this.getHibernateTemplate().findByNamedParam(hql, "stationName", stationName);
	}

	public List<Station> findAll() {
		String hql = "from Station";
		return (List<Station>) this.getHibernateTemplate().find(hql);
	}

	public void create(Station station) {
		this.getHibernateTemplate().save(station);
	}

	public void delete(Station station) {
		this.getHibernateTemplate().delete(station);
	}
}
