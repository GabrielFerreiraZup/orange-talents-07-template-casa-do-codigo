package br.com.zupacademy.gabrielf.casadocodigo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEstadoNameValidator.class)
public @interface UniqueEstadoName {
    String message() default "Campo deve ser único";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};

}
