package scr.board;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import scr.action.CommandAction;
import scr.dto.BoardDTO;
import scr.dao.BoardDAO;

public class BoardInsertAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		String management=request.getParameter("management");
		
		String category="";
		String bTitle="";
        String bContent="";
    	String fileName=null;
		
		

		HttpSession session=request.getSession();
		int uId=(int)session.getAttribute("uid");//아이디 이름 
		System.out.print("Uid"+uId);

		
		String upload=request.getRealPath("/editor/upload");
		
		int sizeLimit= 1024*1024*15;
		
		MultipartRequest multi=new MultipartRequest(request,upload,5*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		Enumeration params=multi.getFileNames();
		
		
		category=multi.getParameter("category");
		bTitle=multi.getParameter("bTitle");
		bContent=multi.getParameter("bContent").replaceAll("\n", "<br>");
		

		 String formName=(String)params.nextElement();
	     fileName=multi.getFilesystemName(formName);
	     
	     System.out.println("category->>"+category);
	     System.out.println("bTitle->>"+bTitle);
	     System.out.println("bContent->>"+bContent);
		System.out.println("fileName->"+fileName);
		
		
	
		
		
	
		
		BoardDAO board=BoardDAO.getInstance(); // BoardDAO의 메소드를 사용하기위해 객체 생성 
		board.insertBoard(uId, bTitle, bContent,category,fileName);
		request.setAttribute("category", category);
		

		if(management!=null){
			System.out.println("c");
			return "boardManagementInsert.jsp";
		}else{
			System.out.println("d");
			return "boardInsert.jsp";
		}

		
		
		
	}

}
