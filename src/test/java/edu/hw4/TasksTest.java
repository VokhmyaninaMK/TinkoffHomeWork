package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTest {

    private static final List<TaskClass.Animal> ANIMAL_LIST = new ArrayList<>(List.of(
        new TaskClass.Animal("cat_1", TaskClass.Animal.Type.CAT, TaskClass.Animal.Sex.M, 3, 25, 4, false),
        new TaskClass.Animal("cat_2", TaskClass.Animal.Type.CAT, TaskClass.Animal.Sex.F, 7, 15, 5, true),
        new TaskClass.Animal("cat_3", TaskClass.Animal.Type.CAT, TaskClass.Animal.Sex.M, 10, 20, 6, true),
        new TaskClass.Animal("dog_1", TaskClass.Animal.Type.DOG, TaskClass.Animal.Sex.M, 3, 33, 24, false),
        new TaskClass.Animal("dog_2", TaskClass.Animal.Type.DOG, TaskClass.Animal.Sex.F, 4, 41, 27, true),
        new TaskClass.Animal("bird_1", TaskClass.Animal.Type.BIRD, TaskClass.Animal.Sex.F, 1, 5, 5, false),
        new TaskClass.Animal("bird_2", TaskClass.Animal.Type.BIRD, TaskClass.Animal.Sex.M, 5, 17, 8, true),
        new TaskClass.Animal(
            "fish_1_with_long_name",
            TaskClass.Animal.Type.FISH,
            TaskClass.Animal.Sex.M,
            3,
            47,
            4,
            true
        ),
        new TaskClass.Animal("fish_2", TaskClass.Animal.Type.FISH, TaskClass.Animal.Sex.F, 4, 125, 125, false),
        new TaskClass.Animal("very angry spider", TaskClass.Animal.Type.SPIDER, TaskClass.Animal.Sex.F, 6, 20, 3, true)
    ));

    //Task1Test
    @Test
    @DisplayName("TASK1_TEST: Checking sortAnimalHeight function")
    void testSortAnimalHeight() {
        Tasks.sortAnimalHeight(ANIMAL_LIST);
        assertThat(ANIMAL_LIST.toArray(new TaskClass.Animal[0]))
            .extracting(TaskClass.Animal::height).contains(5, 15, 17, 20, 20, 25, 33, 41, 47, 125);
    }

    //Task2Test
    @Test
    @DisplayName("TASK2_TEST: Checking sortAnimalWeight function")
    void testSortAnimalWeight() {

        //k < array.size()
        assertThat(Tasks.sortAnimalWeight(ANIMAL_LIST, 3).toArray(new TaskClass.Animal[0]))
            .extracting(TaskClass.Animal::weight).contains(125, 27, 24);

        //k > array.size()
        assertThat(Tasks.sortAnimalWeight(ANIMAL_LIST, 10).toArray(new TaskClass.Animal[0]))
            .extracting(TaskClass.Animal::weight).contains(125, 27, 24, 8, 6, 5, 5, 4, 4, 3);
    }

    //Task3Test
    @Test
    @DisplayName("TASK3_TEST: Checking counterAnimalType function")
    void testCounterAnimalType() {

        //empty array
        assertThat(Tasks.counterAnimalTypes(new ArrayList<>()).size()).isEqualTo(0);

        //Not empty array
        var resultMap = Tasks.counterAnimalTypes(ANIMAL_LIST);

        assertThat(resultMap.size()).isEqualTo(5);
        assertThat(resultMap.get(TaskClass.Animal.Type.CAT)).isEqualTo(3);
        assertThat(resultMap.get(TaskClass.Animal.Type.DOG)).isEqualTo(2);
        assertThat(resultMap.get(TaskClass.Animal.Type.BIRD)).isEqualTo(2);
        assertThat(resultMap.get(TaskClass.Animal.Type.FISH)).isEqualTo(2);
        assertThat(resultMap.get(TaskClass.Animal.Type.SPIDER)).isEqualTo(1);
    }

    //Task4Test
    @Test
    @DisplayName("TASK4_TEST: Checking findAnimalWithLongestName function")
    void testFindAnimalWithTheLongestName() {
        assertThat(Tasks.findAnimalWithLongestName(ANIMAL_LIST).name()).isEqualTo("fish_1_with_long_name");
    }

    //Task5Test
    @Test
    @DisplayName("TASK5_TEST: Checking counterOfAnimalSex function")
    void testCounterOfAnimalSex() {
        assertThat(Tasks.counterOfAnimalSex(ANIMAL_LIST)).isEqualTo(TaskClass.Animal.Sex.F);
    }

    //Task6Test
    @Test
    @DisplayName("TASK6_TEST: Checking findHeaviestAnimalPerType function")
    void testFindHeaviestAnimalPerType() {
        //empty array
        assertThat(Tasks.findHeaviestAnimalPerType(new ArrayList<>()).size()).isEqualTo(0);

        //Not empty array
        var resultMap = Tasks.findHeaviestAnimalPerType(ANIMAL_LIST);

        assertThat(resultMap.size()).isEqualTo(5);

        assertThat(resultMap.get(TaskClass.Animal.Type.CAT).name()).isEqualTo("cat_3");
        assertThat(resultMap.get(TaskClass.Animal.Type.DOG).name()).isEqualTo("dog_2");
        assertThat(resultMap.get(TaskClass.Animal.Type.BIRD).name()).isEqualTo("bird_2");
        assertThat(resultMap.get(TaskClass.Animal.Type.FISH).name()).isEqualTo("fish_2");
        assertThat(resultMap.get(TaskClass.Animal.Type.SPIDER).name()).isEqualTo("very angry spider");

    }

    //Task7Test
    @Test
    @DisplayName("TASK7_TEST: Checking findKOldestAnimal function")
    void testFindKOldestAnimal() {

        //k < array.size()
        assertThat(Tasks.findKOldestAnimal(ANIMAL_LIST, 3).name()).isEqualTo("very angry spider");

        //k > array.size()
        assertThat(Tasks.findKOldestAnimal(ANIMAL_LIST, 10).name()).isEqualTo("bird_1");
    }

    //Task8Test
    @Test
    @DisplayName("TASK8_TEST: Checking findHeaviestAnimalWithOptionalHeight function")
    void testFindHeaviestAnimalWithOptionalHeight() {
        assertThat(Tasks.findHeaviestAnimalWithOptionalHeight(ANIMAL_LIST, 100).get().name())
            .isEqualTo("dog_2");
    }

    //Task9Test
    @Test
    @DisplayName("TASK9_TEST: Checking counterOfPaws function")
    void testCounterOfPaws() {

        //empty array
        assertThat(Tasks.counterOfPaws(new ArrayList<>())).isEqualTo(0);

        //Not empty array
        assertThat(Tasks.counterOfPaws(ANIMAL_LIST)).isEqualTo(32);
    }

    //Task10Test
    @Test
    @DisplayName("TASK10_TEST: Checking findAnimalsWithDiffNumberOfPawsAndAge function")
    void testFindAnimalsWithDiffNumberOfPawsAndAge() {
        assertThat(Tasks.findAnimalsWithDiffNumberOfPawsAndAge(ANIMAL_LIST).toArray().length).isEqualTo(9);
    }

    //Task11Test
    @Test
    @DisplayName("TASK11_TEST: Checking findAnimalsWhoBites function")
    void testFindAnimalsWhoBites() {

        List<TaskClass.Animal> result = Tasks.findAnimalsWhoBites(ANIMAL_LIST);
        assertThat(Tasks.findAnimalsWhoBites(ANIMAL_LIST).toArray().length).isEqualTo(0);
    }

    //Task12Test
    @Test
    @DisplayName("TASK12_TEST: Checking countAnimalsWithWeightMoreHeight function")
    void testCountAnimalsWithWeightMoreHeight() {
        assertThat(Tasks.countAnimalsWithWeightMoreHeight(ANIMAL_LIST)).isEqualTo(0);
    }

    //Task13Test
    @Test
    @DisplayName("TASK13_TEST: Checking findAnimalsWithNamesLongerOneWord function")
    void testFindAnimalsWithNamesLongerOneWord() {
        assertThat(Tasks.findAnimalsWithNamesLongerOneWord(ANIMAL_LIST)
            .toArray(new TaskClass.Animal[0])).extracting(TaskClass.Animal::name).contains("very angry spider");
    }

    //Task14Test
    @Test
    @DisplayName("TASK14_TEST: Checking isInListDogLongerK function")
    void testIsInListDogLongerK() {
        assertThat(Tasks.isInListDogLongerK(ANIMAL_LIST, 40)).isEqualTo(true);
    }

    //Task15Test
    @Test
    @DisplayName("TASK15_TEST: Checking sumOfWeightWithBordersOfAge function")
    void testSumOfWeightWithBordersOfAge() {
        assertThat(Tasks.sumOfWeightWithBordersOfAge(ANIMAL_LIST, 3, 8)).isEqualTo(200);
    }

    //Task16Test
    @Test
    @DisplayName("TASK16_TEST: Checking sortAnimalTypeSexName function")
    void testSortAnimalTypeSexName() {
        ArrayList<String> nameList = new ArrayList<>();

        for (TaskClass.Animal animal : Tasks.sortAnimalTypeSexName(ANIMAL_LIST)) {
            nameList.add(animal.name());
        }

        assertThat(nameList.toArray(new String[0])).containsExactly("bird_1", "bird_2",
            "cat_2", "cat_1", "cat_3", "dog_2", "dog_1", "fish_2", "fish_1_with_long_name", "very angry spider"
        );
    }

    //Task17Test
    @Test
    @DisplayName("TASK17_TEST: Checking doSpidersBiteMoreThanDogs function")
    void testDoSpidersBiteMoreThanDogs() {
        assertThat(Tasks.doSpidersBiteMoreThanDogs(ANIMAL_LIST)).isEqualTo(true);
    }

    //Task18Test
    @Test
    @DisplayName("TASK18_TEST: Checking findTheHeaviestFish function")
    void testFindTheHeaviestFish() {
        List<TaskClass.Animal> animalList_1 = new ArrayList<>(List.of(
            new TaskClass.Animal("fish_1", TaskClass.Animal.Type.FISH, TaskClass.Animal.Sex.M, 100, 100, 350, true),
            new TaskClass.Animal("fish_2", TaskClass.Animal.Type.FISH, TaskClass.Animal.Sex.F, 1, 50, 15, false)
        ));

        List<TaskClass.Animal> animalList_2 = new ArrayList<>(List.of(
            new TaskClass.Animal("fish_3", TaskClass.Animal.Type.FISH, TaskClass.Animal.Sex.M, 1, 100, 25, true),
            new TaskClass.Animal("fish_4", TaskClass.Animal.Type.FISH, TaskClass.Animal.Sex.F, 100, 200, 500, false)
        ));

        List<TaskClass.Animal> animalList_3 = new ArrayList<>(List.of(
            new TaskClass.Animal("cat", TaskClass.Animal.Type.CAT, TaskClass.Animal.Sex.M, 1, 100, 25, true)
        ));

        assertThat(Tasks.findTheHeaviestFish(animalList_1, animalList_2).name()).isEqualTo("fish_4");
        assertThat(Tasks.findTheHeaviestFish(animalList_3)).isEqualTo(null);
    }

    //Task19-20Test
    @Test
    @DisplayName("TASK19-20_TEST: Checking findErrorsWithAnimals function")
    void testFindErrorsWithAnimals() throws IllegalAccessException {
        List<TaskClass.Animal> animalList = new ArrayList<>(List.of(

            new TaskClass.Animal("a1", TaskClass.Animal.Type.DOG, null, 1, 50, 15, false),
            new TaskClass.Animal("a2", null, TaskClass.Animal.Sex.M, 100, 100, 350, true),
            new TaskClass.Animal("a3", TaskClass.Animal.Type.CAT, TaskClass.Animal.Sex.F, -1, 50, 15, false),
            new TaskClass.Animal("a4", TaskClass.Animal.Type.SPIDER, TaskClass.Animal.Sex.F, 1, -1, 10, false),
            new TaskClass.Animal("a5", TaskClass.Animal.Type.SPIDER, TaskClass.Animal.Sex.F, 0, 50, 1, false)
        ));

        Map<String, String> resultMap = Tasks.findErrorsWithAnimalsWithStrings(animalList);

        assertThat(resultMap.get("a1")).isEqualTo("sex- is null\n");
        assertThat(resultMap.get("a2")).isEqualTo("type- is null\n");
        assertThat(resultMap.get("a3")).isEqualTo("age- is negate\n");
        assertThat(resultMap.get("a4")).isEqualTo("height- is negate\n");
        assertThat(resultMap.get("a5")).isEqualTo("age- is zero\n");

    }
}
