package com.afify.hr_system.model.dependent;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DependentDto {
	@NotNull
	private int employeeSsn;
	@NotBlank
	private String dependentName;
	@NotBlank
	private String sex;
	@NotNull
	private LocalDateTime bdate;
    private LocalDateTime created_at;
    private LocalDateTime lastModified;
    private String created_by;
    private String lastModified_by;
}
