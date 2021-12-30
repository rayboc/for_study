package rayboc.rayboc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rayboc.rayboc.common.LogFileUtil;
import rayboc.rayboc.form.ValidationForm;
import rayboc.rayboc.service.AggregationLogService;

@RestController
public class ValidationController {
	
	@Autowired
	AggregationLogService aggregationLogService;
	
	@PostMapping("/validation")
	public void postValid(@RequestBody @Valid ValidationForm validationForm, Errors errors) {
		System.out.println("post済み");
		System.out.println(validationForm.getName() + ":" + validationForm.getAge());
		
		if(errors.hasErrors()) {
			System.out.println(errors);
		}
		
//		try {
//			throw new Exception("test");
//		}catch(Exception ex){
//			System.out.println(ex.getMessage());
//		}
	}
	
	@GetMapping("/file")
	public void file() {
		List<String> collaboAtkList = LogFileUtil.getATKList("C:\\Users\\ryoni\\Documents\\test.txt", "コラボ");
		List<String> largeFauilureAtkList = LogFileUtil.getATKList("C:\\Users\\ryoni\\Documents\\test.txt", "故障あり");
		
		List<String> queryList = LogFileUtil.countFailurKey("C:\\Users\\ryoni\\Documents\\test.txt", collaboAtkList, largeFauilureAtkList);
		
		aggregationLogService.execCountLog(queryList);
		
//		List<String> testList = new ArrayList<String>();
//		testList.add("aaaaaaaa-977e-b1f7-d4c9-ddc3262e8c8d");
//		testList.add("cccccccc-977e-b1f7-d4c9-ddc3262e8c8d");
//		aggregationLogService.execCountLog(testList);
		
	}
	
//	@GetMapping("/dbCount")
//	public void dbCount() {
//		aggregationLogService.execCountLog(new ArrayList<String>());
//	}

}
