package scr.counsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.dto.CounselDTO;
import scr.util.JsonUtil;

public class GetYearListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("GetYearListAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		CounselDAO counselDao=CounselDAO.getInstance();
		List<CounselDTO> list=counselDao.getYearList();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("yearList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
