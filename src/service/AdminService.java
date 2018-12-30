package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.AdminDao;
import model.Admin;

@Transactional
public class AdminService {
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public boolean login(Admin admin) {
		List<Admin> admins = adminDao.findByName(admin);
		if (admins.size() > 0) {
			String password = admins.get(0).getPassword();
			return admin.getPassword().equals(password);
		} else {
			return false;
		}
	}
}
