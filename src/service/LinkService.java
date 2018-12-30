package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.LinkDao;
import dao.StationDao;
import model.Link;
import model.Station;

@Transactional
public class LinkService {
	private LinkDao linkDao;

	public LinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public void create(Link link) {
		linkDao.create(link);
	}

	public void delete(int linkId) {
		Link link = linkDao.findById(linkId);
		linkDao.delete(link);
	}

	public List<Link> findAll() {
		return linkDao.findAll();
	}

}
