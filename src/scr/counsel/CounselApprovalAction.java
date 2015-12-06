package scr.counsel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.util.JsonUtil;

public class CounselApprovalAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselApprovalAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int counselId=Integer.parseInt(request.getParameter("cid"));
		CounselDAO counselDao=CounselDAO.getInstance();
		counselDao.updateStatus(counselId, "승인");
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
