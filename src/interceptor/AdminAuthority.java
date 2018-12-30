package interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminAuthority extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		if (session.get("admin") != null) {
			return invocation.invoke();
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getRequestURI().split("/")[2];
			session.put("path", path);
			return Action.LOGIN;
		}
	}
	
}
