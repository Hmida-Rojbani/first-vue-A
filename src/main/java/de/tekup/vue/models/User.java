package de.tekup.vue.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private int id;
	
	private String name;
	
	private LocalDate dateOfBirth;
	
	private String email;

}
