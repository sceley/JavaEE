package dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import model.Admin;

public class AdminDao extends HibernateDaoSupport {
	public List<Admin> findByName(Admin admin) {
		String hql = "from Admin where username=:username";
		String username = admin.getUsername();
		return (List<Admin>) this.getHibernateTemplate().findByNamedParam(hql, "username", username);
	}
}
