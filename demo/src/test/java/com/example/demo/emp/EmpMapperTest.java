package com.example.demo.emp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {

	@Autowired EmpMapper mapper;
	
	//@Test
	public void 사원통계() {
		List<Map<String,Object>> list = mapper.getStat();
		//for departmentId cnt만 출력
		for(Map<String,Object > map : list) {
			System.out.println("사원통계"+map.get("name") + ":" + map.get("CNT"));			
		}			
		System.out.println("리스트"+list);
	}
	
	//@Test
	public void 사원삭제() {
		int id = 300;
		int deleteCnt = mapper.deleteEmp(id);
		System.out.println("삭제갯수" + deleteCnt);
	}
	
	@Test
	public void 사원등록() {
		//vo 객체 생성
		EmpVO vo = EmpVO.builder()
				// .employeeId(301)
				   .lastName("aaaa")
				   .salary(10)
				   .email("a3@a.a")
				   .hireDate(new Date())
				   .jobId("IT_PROG")
				   .build();
		int result = mapper.insertEmp(vo);
		
		//등록된 사번을 조회
		System.out.println("등록된 사번 : " + vo.getEmployeeId());
		System.out.println("등록건수=" + result);
	}
	
	@Test
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
		//vo.setDepartmentId("50");
		//vo.setFirstName("Kevin");
		//vo.setManagerId("103");
		//vo.setStart(1);
		//vo.setEnd(100);
		svo.setEmployeeIds(new int[] {100, 101, 102, 103, 104});
		List<EmpVO> list = mapper.getEmpList(vo, svo);
//for문 돌려서 employeeId, firstName만 출력
		for(EmpVO emp : list) {
			System.out.println(emp.getDepartmentId()+ ":" + emp.getFirstName());
		}		
		System.out.println("결과는="+list.size());
		//assertEquals(list);
	}
	//@Test
	public void 사원단건조회() {
		int employeeId = 100;
		EmpVO vo = mapper.getEmpInfo(employeeId);
		System.out.println(vo);
		//assertEqual(employeeId, vo.getEmloyeeId());
	}
}
