package mr.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;

public class DelFileController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		//파라미터값 얻어오기
		int num = Integer.parseInt(request.getParameter("num"));
		String fileName = request.getParameter("fileName");
		fileName=URLEncoder.encode(fileName, "UTF-8");
		
		fileName=fileName.replace("+"," ");
		
		String UPLOAD_DIR="uploaded_file";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		File file = new File(uploadPath+"\\"+fileName);
		
		if(file.exists()) {
			file.delete();
			System.out.println("파일 삭제 성공!!");
		}
		
		// DB에서 파일 삭제
		MemberDAO dao = new MemberDAO();
		dao.memberDeleteFile(num);
		
		return "redirect:"+ctx+"/memberInfo.do?num="+num;
	}
}
