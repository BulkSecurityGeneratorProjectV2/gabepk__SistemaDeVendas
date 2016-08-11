package com.vendas.validation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4,18})?")
public @interface SKU {

	// Fazer esse Override é como escrever no @Pattern(message = "tem formato invpalido")
	@OverridesAttribute(constraint = Pattern.class, name="message")
	String message() default "{com.vendas.validation.constraint.SKU.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
