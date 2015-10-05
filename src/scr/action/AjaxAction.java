package scr.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AjaxAction {
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable;
}
