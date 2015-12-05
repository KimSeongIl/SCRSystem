package scr.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

public class BoardSearchAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		System.out.println(10);
		String category=request.getParameter("category");
		String s= request.getParameter("select");
		int select=Integer.parseInt(s);
		String value= request.getParameter("value");
	
		//1  name 2 title 3 content
		int pageNum;
		if(request.getParameter("pageNum")!=null){
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		}else{
			pageNum=1;
		}

		BoardDAO board=BoardDAO.getInstance();
		
		final int VIEW=10;
		final int PAGEVIEW=5;
		int start=(pageNum-1)*VIEW;
		int end=VIEW;
		double count=0;
		
		List boardList=null;
		
		
		if(select==1){
			count=board.getSearchNameCount(category, value);
		
			boardList=board.searchBoardByName(category,value,start,end);
		
		
			
		}else if(select==2){
		
			count=board.getSearchTitleCount(category, value);
			
			boardList=board.searchBoardByTitle(category,value,start,end);
		
			
		}else if(select==3){
			
			count=board.getSearchContentCount(category, value);
		
			boardList=board.searchBoardByContent(category,value,start,end);
			
		}
		if(count==0){
			count=1;
		}
		
		double temp=Math.ceil(count/VIEW);
		int page=(int)temp;
		
		double pageNumTemp=pageNum;
		temp=Math.ceil(pageNumTemp/PAGEVIEW);
		temp=temp-1;
		
		
		int pre=(int)temp*5;
	
		int next=((int)temp+1)*5;
	
		
		List paging=new ArrayList();
		  paging.add("<ul class='pagination'>");
		
		paging.add("<li><a href=boardSearch.do?category="+category+"&select="+select+"&value="+value+">처음</a></li> &nbsp;");
		if(temp>=1){
			paging.add("<li><a href=boardSearch.do?category="+category+"&select="+select+"&value="+value+"&pageNum="+pre+">이전</a></li> &nbsp;");
		}
		for(int i=pre;i<next;i++){
			if(i==page){
				break;
			}
			if((i+1)==pageNum)
				paging.add("<li class='active'><a>"+(i+1)+"</a></li> &nbsp;");
			else
				paging.add("<li><a href=boardSearch.do?category="+category+"&select="+select+"&value="+value+"&pageNum="+(i+1)+">"+(i+1)+"</a></li> &nbsp;");
		}
		if(next<page){
			paging.add("<li><a href=boardSearch.do?category="+category+"&select="+select+"&value="+value+"&pageNum="+(next+1)+">다음</a></li> &nbsp;");
		}
		
		paging.add("<li><a href=boardSearch.do?category="+category+"&select="+select+"&value="+value+"&pageNum="+page+">마지막</a></li> &nbsp;");
		paging.add("</ul>");
		request.setAttribute("category", category);
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", boardList);
		
		
		return "boardView.jsp";

	}

}
