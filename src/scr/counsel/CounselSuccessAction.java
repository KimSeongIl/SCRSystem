package scr.counsel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.util.JsonUtil;

public class CounselSuccessAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselSuccessAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int counselId=Integer.parseInt(request.getParameter("cid"));
		String content=request.getParameter("content");
		String counselDate=request.getParameter("counselDate");
		CounselDAO counselDao=CounselDAO.getInstance();
		counselDao.updateStatus(counselId, "완료");
		counselDao.counselRecordAdd(counselId, content, counselDate);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
