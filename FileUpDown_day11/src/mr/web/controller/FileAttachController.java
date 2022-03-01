package mr.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileAttachController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String UPLOAD_DIR = "uploaded_file";		
		// 실제 물리적인 경로를 얻어오기                                                                                    //\\(윈도우), /(리눅스)
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
//		System.out.println(uploadPath);
		// 파일의 실제경로		
		File currentDirPath = new File(uploadPath); // 업로드할 경로를 File객체로 만들기
		
		if(!currentDirPath.exists()) {
			currentDirPath.mkdir();
		}
		
		// 임시 저장 경로를 설정
		// file upload시에 필요한 API : commons-fileupload, common-io
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setRepository(currentDirPath); //실제 파일이 저장될 경로 설정
		factory.setSizeThreshold(2*1024*1024); // 2MB, 임시파일을 생성할 최대 사이즈 (바이트단위로 지정) 
		
		String fileName = null;
		
		// request에서 데이터를 좀 더 쉽게 찾아내기 위한 클래스
		// multipart/form-data를 쉽게 다룰수 있게 해주는 객체 'ServletFileUpload'
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		
		// FileItem : 사용자가 업로드한 File, 사용자가 input에 입력한 text에 대한 정보를 갖고 있는 객체		
		// items: FileItem[],FileItem[],FileItem[],....
		try {
			List<FileItem> items=servletFileUpload.parseRequest(request);
			
			for(int i=0; i <items.size(); i++) {
				FileItem fileItem=items.get(i); // 하나의 파일정보가 담긴 객체를 가져오기
				
				// isFormField() 파라미터값이면 true, 파일이면 false
				if(fileItem.isFormField()) { // 파라미터 값이면
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}else { // 데이터가 파일인경우
					if(fileItem.getSize() > 0) { // 정상적으로 임시디렉토리에 파일이 업로드 되면
						// fileItem.getName(); // c:\\A\\B\\test.txt
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						fileName = fileItem.getName().substring(idx+1);
						
						File uploadFile=new File(currentDirPath+"\\"+fileName);
						
						if(uploadFile.exists()) {
							// 파일 중복체크
							fileName = System.currentTimeMillis()+"_"+fileName;
							uploadFile = new File(currentDirPath+"\\"+fileName);
						}
						
						fileItem.write(uploadFile);//임시경로 -> 새로운 경로에 파일 쓰기
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// $.ajax()로 업로드된 최종 파일이름을 전송
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(fileName);
		
		return null;
	}
}
