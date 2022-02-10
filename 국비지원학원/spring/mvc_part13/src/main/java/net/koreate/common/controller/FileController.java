package net.koreate.common.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	@Resource(name="uploadPath")
	String uploadPath;
	
	@Inject
	ServletContext context;
	
	@PostConstruct
	public void initPath() {
		uploadPath = context.getRealPath(File.separator+uploadPath);
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		System.out.println("initPath 완료 : " + uploadPath);
	}
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> uploadFile(
			@RequestParam("file") MultipartFile[] file
			)throws Exception{
		ResponseEntity<Object> entity = null;
		
		System.out.println(file);
		List<String> fileList = new ArrayList<>();
		for(MultipartFile files : file) {
			String origin = files.getOriginalFilename();
			System.out.println(origin);
			File f = new File(uploadPath,origin);
			files.transferTo(f);
			//FileCopyUtils.copy(files.getBytes(), f);
			fileList.add(origin);
		}
		entity = new ResponseEntity<>(fileList,HttpStatus.OK);
		return entity;
	}
	
}





