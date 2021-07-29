package br.com.zupacademy.gabrielf.casadocodigo.validation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteIdValidation implements ConstraintValidator<ExisteId,Long> {
    @Autowired
    EntityManager entityManager;

    private Class<?> classeUsada;
    private String campo;


    @Override
    public void initialize(ExisteId constraintAnnotation) {
        classeUsada = constraintAnnotation.domainClass();
        campo = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("Select 1 from "+ classeUsada.getName() + " where " +campo +"=:value");
        query.setParameter("value",value);
        List<?> lista = query.getResultList();
        if (lista.size()>0){
            return true;
        }
        else{
            return false;
        }


    }
}
