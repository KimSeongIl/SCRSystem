package scr.counsel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.dto.CounselDTO;
import scr.util.JsonUtil;

public class CounselRequestAddAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselRequestAddAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		MultipartRequest multi = null;
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		String realFolder = request.getServletContext().getRealPath("/assets/counselUpload");
		
		multi = new MultipartRequest( request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		String division=multi.getParameter("division");
		int term=Integer.parseInt(multi.getParameter("term"));
		String wantDate=multi.getParameter("wantDate");
		String reason=multi.getParameter("reason");
		String counselCategory=multi.getParameter("counselCategory");
		String groupList=multi.getParameter("groupList");
		int pid=Integer.parseInt(multi.getParameter("professorId"));
		String file=multi.getFilesystemName("file");
		
		CounselDTO counsel=new CounselDTO();
		
		counsel.setStudentId(uid);
		counsel.setProfessorId(pid);
		counsel.setCounselDivision(division);
		counsel.setTerm(term);
		counsel.setWantDate(wantDate);
		counsel.setReason(reason);
		counsel.setCounselCategory(counselCategory);
		counsel.setStatus("신청");
		if(file!=null){
			counsel.setFile(file);
		}
		CounselDAO counselDao=CounselDAO.getInstance();
		counselDao.counselAdd(counsel);
		
		
		if(groupList!=null && !"".equals(groupList.trim())){
			String[] group=groupList.split(",");
			for(int i=0;i<group.length;i++){
				counselDao.groupCounselAdd(pid, Integer.parseInt(group[i]));
			}
			
		}
		
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
