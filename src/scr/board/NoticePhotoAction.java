package scr.board;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import scr.action.AjaxAction;

import scr.util.JsonUtil;

public class NoticePhotoAction implements AjaxAction{
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		//íì¼ì ë³´
		String sFileInfo = "";
		//íì¼ëªì ë°ëë¤ - ì¼ë° ìë³¸íì¼ëª
		String filename = request.getHeader("file-name");
		filename=URLDecoder.decode(filename,"UTF-8");
		//íì¼ íì¥ì
		String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
		//íì¥ìë¥¼ìë¬¸ìë¡ ë³ê²½
		filename_ext = filename_ext.toLowerCase();
			
		//ì´ë¯¸ì§ ê²ì¦ ë°°ì´ë³ì
		String[] allow_file = {"jpg","png","bmp","gif"};
		PrintWriter out=response.getWriter();

		//ëë¦¬ë©´ì íì¥ìê° ì´ë¯¸ì§ì¸ì§ 
		int cnt = 0;
		for(int i=0; i<allow_file.length; i++) {
			if(filename_ext.equals(allow_file[i])){
				cnt++;
			}
		}

		//ì´ë¯¸ì§ê° ìë
		if(cnt == 0) {
			out.println("NOTALLOW_"+filename);
		} else {
		//ì´ë¯¸ì§ì´ë¯ë¡ ì ê· íì¼ë¡ ëë í ë¦¬ ì¤ì  ë° ìë¡ë	
		//íì¼ ê¸°ë³¸ê²½ë¡
		String dftFilePath = request.getServletContext().getRealPath("");
		String path="";
		try(FileInputStream fis=new FileInputStream(dftFilePath+"/WEB-INF/upload.properties");){
    		Properties props=new Properties();
    		
    		
    		
    		props.load(new BufferedInputStream(fis));
    		
    		path=props.getProperty("path").trim();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		//íì¼ ê¸°ë³¸ê²½ë¡ _ ìì¸ê²½ë¡
		String filePath = path + File.separator+ "editor" + File.separator +"upload" + File.separator;
		System.out.println(filePath);
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		String realFileNm = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String today= formatter.format(new java.util.Date());
		realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
		String rlFileNm = filePath + realFileNm;//realFileNm->이미지 값 
		System.out.println(realFileNm);
		
		///////////////// ìë²ì íì¼ì°ê¸° ///////////////// 
		InputStream is = request.getInputStream();
		OutputStream os=new FileOutputStream(rlFileNm);
		int numRead;
		byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
		while((numRead = is.read(b,0,b.length)) != -1){
			os.write(b,0,numRead);
		}
		if(is != null) {
			is.close();
		}
		os.flush();
		os.close();
		///////////////// ìë²ì íì¼ì°ê¸° /////////////////

		// ì ë³´ ì¶ë ¥
		sFileInfo += "&bNewLine=true";
		//sFileInfo += "&sFileName="+ realFileNm;;
		// img íê·¸ì title ìì±ì ìë³¸íì¼ëªì¼ë¡ ì ì©ìì¼ì£¼ê¸° ìí¨
		sFileInfo += "&sFileName="+ filename;;
		sFileInfo += "&sFileURL="+"upload/"+realFileNm;
		

		}
		Map<String,Object> param=new HashMap<>();
		param.put("returnResult", sFileInfo);
		return JsonUtil.putSuccessJsonContainer(param);
		
	}
}
