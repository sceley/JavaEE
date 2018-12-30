package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import model.Query;
import model.Train;
import service.QueryService;

public class QueryAction implements ModelDriven<Query> {
	private QueryService queryService;
	private Query query = new Query();

	@Override
	public Query getModel() {
		// TODO Auto-generated method stub
		return query;
	}

	public QueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
	public String query () {
		List<Query> querys = queryService.query(query);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("querys", querys);
		return "success";
	}
	
	public String advancedQuery () {
		return "success";
	}

}
