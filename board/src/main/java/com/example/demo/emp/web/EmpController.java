package com.example.demo.emp.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpSearchVO;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈 등록 + 사용자요청처리할 수 있는 커맨드 핸들러 변환
public class EmpController {

	final EmpMapper mapper; // 의존성주입(=DI. dependency Injection)

	@GetMapping("/emp/insert")
	public void insert() {

	}
	
	//등록처리 --> employees 테이블에 photo 칼럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile) {
		//파일업로드 ...
		vo.setPhoto(photoFile.getOriginalFilename());
		System.out.println("vo : " + vo);
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}

	// 수정페이지 이동
	@GetMapping("/emp/update")
	public void update() {

	}
	
	//수정처리
	@GetMapping("/update/{empId}")
    public String update(@PathVariable int empId) {
    	System.out.println(empId);
    	return "index";
    }
	
	//삭제처리
	
	//상세조회 페이지 이동

	// 목록페이지로 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, EmpSearchVO svo) {
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "emp/list";
	}

}
