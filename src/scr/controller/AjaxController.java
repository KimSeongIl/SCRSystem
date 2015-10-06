package scr.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;




import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import scr.action.AjaxAction;

@WebServlet("/AjaxController")
public class AjaxController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public AjaxController(){
		super();
	}
	
	 private Map<String, Object> commandMap=new HashMap<String, Object>();
	    @Override
	    public void init(ServletConfig config)throws ServletException{
	    	
	    	super.init(config);
	    	
	    	String props=config.getInitParameter("propertyConfig");
	    	
	    	Properties pr=new Properties();
	    	
	    	FileInputStream f=null;
	    	props=config.getServletContext().getRealPath(props);
	    	
	    	try{
	    		f=new FileInputStream(props);
	    		pr.load(f);
	    	}catch(IOException e){
	    		throw new ServletException(e);
	    	}finally{
	    		if(f!=null){
	    			try{
	    				f.close();
	    			}catch(IOException ex){}
	    		}
	    	}
	    	
	    	Iterator<?> keyIter=pr.keySet().iterator();
	    	
	    	while(keyIter.hasNext()){
	    		
	    		String command=(String)keyIter.next();
	    		String className=pr.getProperty(command);
	    		try{
	    			Class<?> commandClass=Class.forName(className);
	    			
	    			Object commandInstance=commandClass.newInstance();
	    			
	    			commandMap.put(command, commandInstance);
	    		}catch(ClassNotFoundException e){
	    			throw new ServletException(e);
	    		}catch(InstantiationException e){
	    			throw new ServletException(e);
	    		}catch(IllegalAccessException e){
	    			throw new ServletException(e);
	    		}
	    	}
	    }
	    
	    /**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			requestPro(request,response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	    @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			requestPro(request,response);
		}
		
		private void requestPro(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			Map<String,Object> result=null;
			AjaxAction com=null;
			try{//이부분은 요청한 URI에서 명령어를 추출하는 부분이다 .URI를 명령어로 사용하는 예제에서 추가되는 부분은 여기부터 
				String command=request.getRequestURI();
				
				if(command.indexOf(request.getContextPath())==0){
					command=command.substring(request.getContextPath().length()+1);
				}
				com=(AjaxAction)commandMap.get(command);
				
				
				result=com.responseBody(request,response);
				
				
			}catch(Throwable e){
				throw new ServletException(e);
			}
			
			response.setContentType("application/json;charset=UTF-8");
			String json=new Gson().toJson(result);
			PrintWriter out=response.getWriter();
			out.println(json);
			
			
			
			
			
		}
}
