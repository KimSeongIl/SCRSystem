package scr.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;

import scr.dao.BoardDAO;
import scr.dto.BoardDTO;
import scr.util.JsonUtil;

public class FileDownloadAction implements AjaxAction {
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
	 
		
		System.out.println("Ajax practice ");
		request.setCharacterEncoding("UTF-8");
		String bFile=request.getParameter("bFile");
		
		
		
		
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
	
}
