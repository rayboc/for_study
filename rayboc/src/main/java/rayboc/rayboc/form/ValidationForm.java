package rayboc.rayboc.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationForm {

	@NotNull
	@Size(min = 10, max = 10)
	private String name;
	private int age;

}
