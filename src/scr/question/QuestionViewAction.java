package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;

public class QuestionViewAction implements CommandAction{
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse ressponse)throws Throwable{
		 
		 QuestionDAO question=QuestionDAO.getInstance();
		 
			int pageNum;
		    
			
			
			if(request.getParameter("pageNum")!=null){
				pageNum=Integer.parseInt(request.getParameter("pageNum"));
			
			}else{
				pageNum=1;
			
			}
			
			double count=question.getQuestionCount();
		//System.out.println("count->>"+count);
			if(count==0){
				count=1;
			}
			final int VIEW=10;
			final int PAGEVIEW=5;
			
			int start=(pageNum-1)*VIEW;
			//System.out.println("start->>"+start);
			int end=VIEW;
			//System.out.println("end->>"+end);
			
			double temp=Math.ceil(count/VIEW);
			//System.out.println("temp1->>"+temp);
			int page=(int)temp;
			//System.out.println("page->>"+page);
			double pageNumTemp=pageNum;
			temp=Math.ceil(pageNumTemp/PAGEVIEW);
			temp=temp-1;
			//System.out.println("temp2->>"+temp);
			
			int pre=(int)temp*5;
			//System.out.println("pre->>"+pre);
			int next=((int)temp+1)*5;
			//System.out.println("next->>"+next);
		 
		 
		 
		 
	
		 List questionList=question.questionView();
		 
		 List paging=new ArrayList();
		    paging.add("<ul class='pagination'>");
			paging.add("<li><a href=questionView.do>처음</a></li>");
			if(temp>=1){
				paging.add("<li><a href=questionView.do?pageNum="+pre+">이전</a></li>");
			}
			for(int i=pre;i<next;i++){
				if(i==page){
					break;
				}
				if((i+1)==pageNum)
					paging.add("<li class='active'><a>"+(i+1)+"</a></li>");
				else
					paging.add("<li><a href=questionView.do?pageNum="+(i+1)+">"+(i+1)+"</a></li>");
			}
			if(next<page){
				paging.add("<li><a href=questionView.do?pageNum="+(next+1)+">다음</a></li>");
			}
			
			paging.add("<li><a href=questionView.do?pageNum="+page+">마지막</a></li>");
			paging.add("</ul>");
		 
	
		 request.setAttribute("questionList", questionList);
		 request.setAttribute("paging", paging);
		 request.setAttribute("count", count);
		 
		 return "questionView.jsp";
	 }

}
