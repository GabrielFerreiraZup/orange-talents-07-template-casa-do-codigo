package br.com.zupacademy.gabrielf.casadocodigo.validation;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Cliente;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Pais;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.ClienteDtoEntrada;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoComPaisValidation  implements ConstraintValidator<EstadoComPais, ClienteDtoEntrada> {
    @Autowired
    EntityManager em;

    @Override
    public void initialize(EstadoComPais constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClienteDtoEntrada value, ConstraintValidatorContext context) {
        System.out.println("Entrei na validacao");
        Pais pais = em.find(Pais.class,value.getIdPais());

        if(pais ==null){

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("ID Pais invalido: Não existe ID desse pais")
                    .addPropertyNode("idPais")
                    .addConstraintViolation();
            return false;
        }
        Long estadoId = value.getIdEstado();
        Long paisId = value.getIdPais();
        Query query = em.createNativeQuery("Select * from Estado where pais_id=:paisId and id=:estadoId");
        query.setParameter("paisId",paisId);
        query.setParameter("estadoId",estadoId);
        List lista = query.getResultList();
        if(lista.size()>0){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Id Inválido: Estado deve pertencer ao pais")
                .addPropertyNode("idEstado")
                .addConstraintViolation();
        return false;
    }
}
