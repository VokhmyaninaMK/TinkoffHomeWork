package edu.hw4;

import java.lang.reflect.Field;

public class ValidationError {

    private final static String ZERO_FIELD = "- is zero\n";
    private final static String NULL_FIELD = "- is null\n";
    private final static String NEGATE_FIELD = "- is negate\n";

    private String errorMessage = null;

    public String getMessage() {
        return errorMessage;
    }

    public ValidationError(TaskClass.Animal animal, String fieldName)
        throws IllegalAccessException, NoSuchFieldException {

        Field field = animal.getClass().getDeclaredField(fieldName);

        field.setAccessible(true);

        switch (fieldName) {

            case "name":
                checkName(animal, field);
                break;

            case "type":
            case "sex":
                checkTypeAndSex(animal, field);
                break;

            case "age":
            case "height":
            case "weight":
                checkAgeHeightWeight(animal, field);
                break;
            default:
                break;
        }
    }

    private void checkName(TaskClass.Animal animal, Field field) throws IllegalAccessException {
        if (field.get(animal) == null) {
            errorMessage = field.getName() + NULL_FIELD;
        } else if (field.get(animal).equals(" ")) {
            errorMessage = field.getName() + ": is empty\n";
        } else {
            throw new IllegalAccessException();
        }
    }

    private void checkTypeAndSex(TaskClass.Animal animal, Field field) throws IllegalAccessException {
        if (field.get(animal) == null) {
            errorMessage = field.getName() + NULL_FIELD;
        } else {
            throw new IllegalAccessException();
        }
    }

    private void checkAgeHeightWeight(TaskClass.Animal animal, Field field) throws IllegalAccessException {
        if ((Integer) field.get(animal) < 0) {
            errorMessage = field.getName() + NEGATE_FIELD;
        } else if ((Integer) field.get(animal) == 0) {
            errorMessage = field.getName() + ZERO_FIELD;
        } else {
            throw new IllegalAccessException();
        }
    }

}
