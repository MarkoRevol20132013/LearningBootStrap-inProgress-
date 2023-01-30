package com.example.servery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Department name is mandatory")
    /*@Length(min = 3 , max = 10 , message = "Department name should have atleast 3 characters and atmost 10 characters")
      @Size(min = 3 , max = 10 , message = "Department name should have atleast 3 characters and atmost 10 characters")
      @Email
      @Positive
      @Negative
      @NegativeOrZero
      @Future
      @FutureOrPresent
      @Past*/

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
