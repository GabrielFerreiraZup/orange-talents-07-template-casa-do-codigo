package br.com.zupacademy.gabrielf.casadocodigo.validation;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Estado;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.EstadoDtoEntrada;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueEstadoNameValidator implements ConstraintValidator<UniqueEstadoName, EstadoDtoEntrada> {

    @Autowired
    EntityManager em;

    @Override
    public void initialize(UniqueEstadoName constraintAnnotation) {

    }

    @Override
    public boolean isValid(EstadoDtoEntrada estado, ConstraintValidatorContext context) {
        Long valueId = estado.getIdPais();
        String valueNome = estado.getNome();
        Query query = em.createNativeQuery("Select * from Estado where pais_id=:valueId and nome =:valueNome ",Estado.class);
        query.setParameter("valueId",valueId);
        query.setParameter("valueNome",valueNome);

        List lista = query.getResultList();
        if(lista.size()>0){
            System.out.printf("Achou mesmo nome");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Nome Inválido: Não pode ser igual a um nome presente no mesmo Pais")
                    .addPropertyNode("nome")
                    .addConstraintViolation();
            return false;
        }
        else{
            return true;
        }
    }
    }
