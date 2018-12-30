package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import model.Link;
import model.Station;
import service.LinkService;
import service.StationService;

public class LinkAction implements ModelDriven<Link> {
	private LinkService linkService;
	private StationService stationService;
	private Link link = new Link();

	@Override
	public Link getModel() {
		// TODO Auto-generated method stub
		return link;
	}

	public StationService getStationService() {
		return stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	public LinkService getLinkService() {
		return linkService;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public String showLink() {
		List<Link> links = linkService.findAll();
		ActionContext.getContext().getValueStack().set("links", links);
		return "success";
	}

	public String showCreateLink() {
		List<Station> stations =	stationService.findAll();
		ActionContext.getContext().getValueStack().set("stations", stations);
		return "success";
	}

	public String create() {
		linkService.create(link);
		return "success";
	}

	public String delete() {
		linkService.delete(link.getLinkId());
		return "success";
	}

}
