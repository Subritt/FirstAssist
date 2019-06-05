package com.bway.springproject.controllers;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/upload")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String UploadPage(){
		
		return "fileUpload" ;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String Upload(@RequestParam("file") MultipartFile file, Model model) throws IOException{
		
		byte[] bytes;
		
		if(!file.isEmpty()){
			bytes = file.getBytes();
			//Write in file
			FileOutputStream out = new FileOutputStream("C:\\Users\\subri\\Documents\\workspace-sts-3.7.2.RELEASE\\sprinproject\\src\\main\\webapp\\resources\\imgs\\" + file.getOriginalFilename()); //C:\Users\subri\Documents\workspace-sts-3.7.2.RELEASE\sprinproject\src\main\webapp\resources\imgs
			out.write(bytes);
			out.close();
		}
		
		model.addAttribute("msg", "file upload success");
		
		return "fileUpload";
	}

}
