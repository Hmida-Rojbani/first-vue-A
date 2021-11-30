package de.tekup.vue.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	@NotBlank
	@Size(max = 30)
	private String name;
	@NotBlank
	@Pattern(regexp = "^[0-9]{4,8}$", message = "Password must contains only 4 to 8 digits")
	private String password;
	@Past
	private LocalDate dateOfBirth; 
	
	private String email;
	
	public void setDate(String date) {
		
		this.dateOfBirth = LocalDate.parse(date);
	}
	
	public String getDate() {
		if(dateOfBirth==null)
			dateOfBirth=LocalDate.of(2000,1,1);
		return dateOfBirth.toString();
	}

}
