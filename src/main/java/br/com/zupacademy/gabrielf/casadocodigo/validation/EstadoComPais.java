package br.com.zupacademy.gabrielf.casadocodigo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoComPaisValidation.class)
public @interface EstadoComPais {

    String message() default "Estado invalido nesse pais";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
