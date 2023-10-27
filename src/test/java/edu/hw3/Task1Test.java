package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Checking atbash function efficiency")
    void testAtbash() {
        assertThat(edu.hw3.Task1.atbash("Hello, my name is Masha")).isEqualTo("Svool, nb mznv rh Nzhsz");
        assertThat(edu.hw3.Task1.atbash(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler")).isEqualTo(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
        assertThat(edu.hw3.Task1.atbash("Hello world!")).isEqualTo("Svool dliow!");

    }
}
