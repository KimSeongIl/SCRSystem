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
		
		System.out.println("category->>"+category+"select->>"+select+"value->>"+value);
		//1  name 2 title 3 content
		int pageNum;
		if(request.getParameter("pageNum")!=null){
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
			System.out.println("pageNum->>"+pageNum);
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
			boardList=board.searchBoardByName(value);
			
		}else if(select==2){
			System.out.println("select2");
			count=board.getSearchTitleCount(category, value);
			System.out.println("count->>"+count);
			boardList=board.searchBoardByTitle(category,value,start,end);
			System.out.println("start->"+start+"end->"+end);
			
		}else if(select==3){
			
			count=board.getSearchContentCount(category, value);
			System.out.println("select3  count"+count);
			boardList=board.searchBoardByContent(category,value,start,end);
			
		}
		if(count==0){
			count=1;
		}
		
		double temp=Math.ceil(count/VIEW);
		int page=(int)temp;
		System.out.println("page->"+page);
		double pageNumTemp=pageNum;
		temp=Math.ceil(pageNumTemp/PAGEVIEW);
		temp=temp-1;
		System.out.println("temp->>"+temp);
		
		int pre=(int)temp*5;
		System.out.println("pre->>"+pre);
		int next=((int)temp+1)*5;
		System.out.println("next->>"+next);
		
		List paging=new ArrayList();
		
		paging.add("<a href=boardSearch.do?category="+category+"&search="+select+"&value="+value+">처음</a> &nbsp;");
		if(temp>=1){
			paging.add("<a href=boardSearch.do?category="+category+"&search="+select+"&value="+value+"&pnum="+pre+">이전</a> &nbsp;");
		}
		for(int i=pre;i<next;i++){
			if(i==page){
				break;
			}
			if((i+1)==pageNum)
				paging.add((i+1)+" &nbsp;");
			else
				paging.add("<a href=boardSearch.do?category="+category+"&search="+select+"&value="+value+"&pnum="+(i+1)+">"+(i+1)+"</a> &nbsp;");
		}
		if(next<page){
			paging.add("<a href=boardSearch.do?category="+category+"&search="+select+"&value="+value+"&pnum="+(next+1)+">다음</a> &nbsp;");
		}
		
		paging.add("<a href=boardSearch.do?category="+category+"&search="+select+"&value="+value+"&pnum="+page+">마지막</a> &nbsp;");

		request.setAttribute("category", category);
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", boardList);
		
		
		return "boardView.jsp";

	}

}