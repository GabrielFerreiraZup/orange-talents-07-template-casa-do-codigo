package br.com.zupacademy.gabrielf.casadocodigo.validation;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;
import br.com.zupacademy.gabrielf.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueNomeValidation implements ConstraintValidator<UniqueNome,String> {
    @Autowired
    CategoriaRepository categoriaRepository;


    @Override
    public void initialize(UniqueNome constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Optional<Categoria> optional = categoriaRepository.findByNome(value);
        if(optional.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
