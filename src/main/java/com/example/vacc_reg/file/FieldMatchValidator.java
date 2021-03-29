package com.example.vacc_reg.file;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import static org.apache.commons.beanutils.BeanUtils.getProperty;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Object firstObj = getProperty(value, firstFieldName);
            final Object secondObj = getProperty(value, secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore) {}
        return true;
    }
}
