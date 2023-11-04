package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Tasks {
    private Tasks() {
    }

    //Task1
    public static void sortAnimalHeight(List<TaskClass.Animal> originalList) {
        originalList.sort(Comparator.comparingInt(TaskClass.Animal::height));
    }

    //Task2
    public static List<TaskClass.Animal> sortAnimalWeight(List<TaskClass.Animal> originalList, int k) {
        List<TaskClass.Animal> newAnimalList = new ArrayList<>(List.copyOf(originalList));

        newAnimalList.sort(Comparator.comparingInt(TaskClass.Animal::weight));

        return newAnimalList.reversed().stream().limit(k).collect(Collectors.toList());
    }

    //Task3
    public static Map<TaskClass.Animal.Type, Integer> counterAnimalTypes(List<TaskClass.Animal> originalList) {
        Map<TaskClass.Animal.Type, Integer> animalTypesMap = new HashMap<>();

        for (TaskClass.Animal animal : originalList) {
            animalTypesMap.merge(animal.type(), 1, Integer::sum);
        }

        return animalTypesMap;
    }

    //Task4
    public static TaskClass.Animal findAnimalWithLongestName(List<TaskClass.Animal> originalList) {

        TaskClass.Animal animalWithLongestName = originalList.get(0);

        for (TaskClass.Animal animal : originalList) {
            if (animal.name().length() > animalWithLongestName.name().length()) {
                animalWithLongestName = animal;
            }
        }

        return animalWithLongestName;
    }

    //Task5
    public static TaskClass.Animal.Sex counterOfAnimalSex(List<TaskClass.Animal> originalList) {

        int maleCounter = 0;
        int femaleCounter = 0;
        for (TaskClass.Animal animal : originalList) {
            if (animal.sex().equals(TaskClass.Animal.Sex.F)) {
                femaleCounter++;
            } else {
                maleCounter++;
            }
        }
        if (maleCounter > femaleCounter) {
            return TaskClass.Animal.Sex.M;
        } else {
            return TaskClass.Animal.Sex.F;
        }
    }

    //Task6
    public static Map<TaskClass.Animal.Type, TaskClass.Animal> findHeaviestAnimalPerType(
        List<TaskClass.Animal> originalList) {
        Map<TaskClass.Animal.Type, TaskClass.Animal> result = new HashMap<>();
        for (TaskClass.Animal animal : originalList) {
            if (!result.containsKey(animal.type()) || result.get(animal.type()).weight() < animal.weight()) {
                result.put(animal.type(), animal);
            }
        }
        return result;
    }

    //Task7
    public static TaskClass.Animal findKOldestAnimal(List<TaskClass.Animal> originalList, int k) {
        TaskClass.Animal result;
        List<TaskClass.Animal> newAnimalList = new ArrayList<>(List.copyOf(originalList));

        newAnimalList.sort(Comparator.comparingInt(TaskClass.Animal::age));
        newAnimalList = newAnimalList.reversed();

        if (k > newAnimalList.size()) {
            result = newAnimalList.get(0);
        } else {
            result = newAnimalList.get(k - 1);
        }

        return result;
    }

    //Task8
    public static Optional<TaskClass.Animal> findHeaviestAnimalWithOptionalHeight(
        List<TaskClass.Animal> originalList, int maxHeight
    ) {

        List<TaskClass.Animal> newAnimalList = new ArrayList<>(
            originalList.stream().filter(it -> it.height() < maxHeight).toList());

        newAnimalList.sort(Comparator.comparingInt(TaskClass.Animal::weight));

        if (newAnimalList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(newAnimalList.get(newAnimalList.size() - 1));
    }

    //Task9
    public static Integer counterOfPaws(List<TaskClass.Animal> originalList) {
        return Arrays.stream(originalList.toArray(new TaskClass.Animal[0])).mapToInt(TaskClass.Animal::paws).sum();
    }

    //Task10
    public static List<TaskClass.Animal> findAnimalsWithDiffNumberOfPawsAndAge(List<TaskClass.Animal> originalList) {
        return originalList.stream().filter(it -> it.paws() != it.age()).collect(Collectors.toList());
    }

    //Task11
    public static List<TaskClass.Animal> findAnimalsWhoBites(List<TaskClass.Animal> originalList) {
        final int HEIGHT = 100;
        return originalList.stream().filter(it -> it.bites() && it.height() > HEIGHT).collect(Collectors.toList());
    }

    //Task12
    public static Integer countAnimalsWithWeightMoreHeight(List<TaskClass.Animal> originalList) {
        return originalList.stream().filter(it -> it.weight() > it.height()).collect(Collectors.toList()).size();
    }

    //Task13
    public static List<TaskClass.Animal> findAnimalsWithNamesLongerOneWord(
        List<TaskClass.Animal> originalList
    ) {
        return originalList.stream().filter(it -> it.name().contains(" ")).collect(Collectors.toList());
    }

    //Task14
    public static Boolean isInListDogLongerK(List<TaskClass.Animal> originalList, int k) {

        for (TaskClass.Animal animal : originalList) {
            if (animal.type() == TaskClass.Animal.Type.DOG && animal.height() > k) {
                return true;
            }
        }

        return false;
    }

    //Task15
    public static Integer sumOfWeightWithBordersOfAge(List<TaskClass.Animal> originalList, int k, int l) {
        return Arrays.stream(originalList.toArray(new TaskClass.Animal[0]))
            .filter(it -> it.age() >= k && it.age() <= l).mapToInt(TaskClass.Animal::weight).sum();
    }

    //Task16
    public static List<TaskClass.Animal> sortAnimalTypeSexName(List<TaskClass.Animal> originalList) {
        List<TaskClass.Animal> newAnimalsList = new ArrayList<>(List.copyOf(originalList));
        newAnimalsList.sort(new Comparator<TaskClass.Animal>() {
            @Override
            public int compare(TaskClass.Animal o1, TaskClass.Animal o2) {
                if (!o1.type().equals(o2.type())) {
                    return o1.type().toString().compareTo(o2.type().toString());
                } else {
                    if (!o1.sex().equals(o2.sex())) {
                        return o1.sex().toString().compareTo(o2.sex().toString());
                    } else {
                        return o1.name().compareTo(o2.name());
                    }
                }
            }
        });

        return newAnimalsList;
    }

    //Task17
    public static Boolean doSpidersBiteMoreThanDogs(List<TaskClass.Animal> originalList) {
        boolean result = false;
        double spidersCounter = 0;
        double dogsCounter = 0;
        double spidersBitesCounter = 0;
        double dogsBitesCounter = 0;

        for (TaskClass.Animal animal : originalList) {
            if (animal.type().equals(TaskClass.Animal.Type.SPIDER)) {
                spidersCounter++;
                if (animal.bites()) {
                    spidersBitesCounter++;
                }
            }

            if (animal.type().equals(TaskClass.Animal.Type.DOG)) {
                dogsCounter++;
                if (animal.bites()) {
                    dogsBitesCounter++;
                }
            }
        }

        if (dogsBitesCounter != 0 && dogsCounter != 0 && spidersBitesCounter != 0 && spidersCounter != 0) {
            result = dogsBitesCounter / dogsCounter < spidersBitesCounter / spidersCounter;
        }

        return result;
    }

    //Task18
    @SafeVarargs
    public static TaskClass.Animal findTheHeaviestFish(List<TaskClass.Animal>... originalLists) {
        TaskClass.Animal theHeaviestFish = originalLists[0].get(0);

        for (List<TaskClass.Animal> animalsList : originalLists) {
            for (TaskClass.Animal animal : animalsList) {
                if (animal.type().equals(TaskClass.Animal.Type.FISH) && animal.weight() > theHeaviestFish.weight()) {
                    theHeaviestFish = animal;
                }
            }
        }

        return theHeaviestFish;
    }

    //Task19
    public static Map<String, Set<ValidationError>> findErrorsWithAnimals(List<TaskClass.Animal> givenList)
        throws NoSuchFieldError, IllegalAccessException {

        ArrayList<String> fieldsNamesArray = new ArrayList<>(List.of("name", "type", "sex", "age", "height", "weight"));
        Map<String, Set<ValidationError>> errorsMap = new HashMap<>();

        for (TaskClass.Animal animal : givenList) {
            Set<ValidationError> errorsSet = new HashSet<>();

            for (String field : fieldsNamesArray) {
                try {
                    errorsSet.add(new ValidationError(animal, field));
                } catch (IllegalAccessException | NoSuchFieldException operationException) {

                }
            }

            if (!errorsSet.isEmpty()) {
                errorsMap.put(animal.name(), errorsSet);
            }

        }
        return errorsMap;
    }

    //Task20
    public static Map<String, String> findErrorsWithAnimalsWithStrings(List<TaskClass.Animal> givenList)
        throws NoSuchFieldError, IllegalAccessException {

        Map<String, Set<ValidationError>> errorsMap = findErrorsWithAnimals(givenList);
        Map<String, String> resultMap = new HashMap<>();

        for (var element : errorsMap.entrySet()) {
            StringBuilder errorString = new StringBuilder();

            for (ValidationError error : element.getValue()) {
                errorString.append(error.getMessage());
            }
            resultMap.put(element.getKey(), errorString.toString());

        }
        return resultMap;
    }
}
