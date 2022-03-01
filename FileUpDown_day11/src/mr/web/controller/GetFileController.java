package mr.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFileController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fileName = request.getParameter("fileName");
		
		String UPLOAD_DIR = "uploaded_file";		
		// 실제 물리적인 경로를 얻어오기                                                                                    //\\(윈도우), /(리눅스)
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		File file = new File(uploadPath+"\\"+fileName);
		
		// 한글 깨짐 방지
		fileName = URLEncoder.encode(fileName, "UTF-8");
		fileName = fileName.replace("+", " "); // 어떤 브라우저는 파일명의 공백 부분을 + 처리하는 경우가 있음, + ---> " " 
		
		// 다운로드 준비과정: 서버에서 클라이언트에게 다운로드 준비를 시켜놓는 과정
		response.setContentLength((int)file.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName+";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		// 실제 다운로드 
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		
		byte[] buffer= new byte[1024];
		while(true) {
			int cnt = fis.read(buffer);
			if(cnt==-1) {
				break;
			}
			out.write(buffer, 0, cnt); //읽어들인만큼 클라이언트에 계속 씀 
		}
		
		fis.close();
		out.close();
		
		return null;
	}
}
