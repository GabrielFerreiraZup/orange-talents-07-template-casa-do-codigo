package br.com.zupacademy.gabrielf.casadocodigo.validation;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Autor;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.AutorDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private AutorRepository autorRepository;
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Autor> optionalAutor = autorRepository.findByEmail(value);
        if(optionalAutor.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
