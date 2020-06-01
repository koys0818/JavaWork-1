package com.command.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//업로드 된 파일 저장
		
		final String SAVE_URL = "ckupload";
		
		//실제 저장되는 물리적인 경로 확인
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath(SAVE_URL);
		System.out.println("업로드 경로: " + saveDirectory);
		
		Enumeration names = null;
		String name = null; //parameter로 넘어오는 name 값
		String originalFileName = null; //원본파일 이름
		String fileSystemName = null; //실제 저장되는 파일 이름
		String fileType = null; // 파일 MIME 타입
		String fileUrl = null; //업로드된 파일의 URL
		
		int maxPostSize = 5 * 1024 * 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, 
					saveDirectory,
					maxPostSize,
					encoding,
					policy
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		names = multi.getFileNames(); //type="file" 요소의 name들 추출
		while(names.hasMoreElements()){
			name = (String)names.nextElement();
			System.out.println("input name: " + name); // CKEditor에선 name이 "upload"이다.
			
			originalFileName = multi.getOriginalFileName(name);
			fileSystemName = multi.getFilesystemName(name);
			fileType = multi.getContentType(name);
			
			fileUrl = request.getContextPath() + "/" + SAVE_URL + "/" + fileSystemName;
			System.out.println("fileUrl: " + fileUrl);
		}
		
		//response(CKEditor에서 정한 포맷으로, json)
		//{
		//	fileName: "face03.png"
		//	uploaded: 1
		//	url: "https://ckeditor.com/apps/ckfinder/userfiles/images/face03.png"
		//}
		
		String jsonString = "{\"fileName\" : \"" + fileSystemName
				+ "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
		
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
