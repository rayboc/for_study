package rayboc.rayboc.controller;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rayboc.rayboc.form.ValidationForm;

@RestController
public class ValidationController {
	
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

}
