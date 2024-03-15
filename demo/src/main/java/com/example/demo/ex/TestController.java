package com.example.demo.ex;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;

@Controller
public class TestController {
	@RequestMapping("/ex6")
	public String ex6(EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException {
		System.out.println(vo);
		if (photos != null) {
			for (MultipartFile photo : photos) {
				if (photo.getSize() > 0) {
					// 파일생성
					File file = new File("d:/upload", photo.getOriginalFilename());
					// 파일저장
					photo.transferTo(file);
					
					System.out.println("파일명 : " + photo.getOriginalFilename());
					System.out.println("파일명 : " + photo.getSize());
				}
			}
		}
		return "index";
	}
}
