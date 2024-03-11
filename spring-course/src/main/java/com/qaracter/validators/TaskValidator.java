package com.qaracter.validators;

import com.qaracter.models.Task;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class TaskValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //here you can add more validation rules
        Task task = (Task) target;
        if(task.getId() == null
                || task.getId() <= 0) {
            errors.rejectValue("id", "field not valid");
        }
        if(task.getTitle() == null
                || task.getTitle().isEmpty()) {
            errors.rejectValue("title", "field not valid");
        }
    }

}
