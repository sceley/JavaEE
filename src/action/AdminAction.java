package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import service.AdminService;
import model.Admin;

public class AdminAction implements ModelDriven<Admin> {
	private AdminService adminService;
	private Admin admin = new Admin();

	@Override
	public Admin getModel() {
		return admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String showAdmin() {
		return "success";
	}

	public String login() {
		ActionContext ctx = ActionContext.getContext();
		if (adminService.login(admin)) {
			Map<String, Object> session = ctx.getSession();
			session.put("admin", admin);
			String path = (String) session.get("path");
			session.remove("path");
			if (path != null) {
				path = "/train";
			}
			ctx.getValueStack().set("path", path);
			return "success";
		} else {
			ctx.getValueStack().set("failureMsg", "账号或密码错误");
			return "failure";
		}
	}

}
