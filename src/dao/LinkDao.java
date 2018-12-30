package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import model.Link;

public class LinkDao extends HibernateDaoSupport {
	public Link findById(int linkId) {
		return this.getHibernateTemplate().get(Link.class, linkId);
	}

	public List<Link> findAll() {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Link.class);
//		return (List<Link>) this.getHibernateTemplate().findByCriteria(criteria);
		 String hql = "from Link";
		 return (List<Link>) this.getHibernateTemplate().find(hql);
	}

	public List<Link> findSrcDest(int srcId, int destId) {
		String hql = "from Link where sourceId=:srcId and destinationId=:destId";
		String[] paramNames = new String[] {"srcId", "destId"};
		Object[] values = new Object[] {srcId, destId};
		return (List<Link>) this.getHibernateTemplate().findByNamedParam(hql, paramNames, values);
	}

	public void create(Link link) {
		this.getHibernateTemplate().save(link);
	}

	public void delete(Link link) {
		this.getHibernateTemplate().delete(link);
	}
}
