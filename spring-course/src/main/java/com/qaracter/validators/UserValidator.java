package com.qaracter.validators;

import com.qaracter.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        //here you can add more validation rules
        User user = (User) target;
        if(user.getId() == null
                || user.getId() <= 0) {
            errors.rejectValue("UserID", "field not valid");
        }
        if(user.getUsername() == null
                || user.getUsername().isEmpty()) {
            errors.rejectValue("username", "field not valid");
        }
    }

}
