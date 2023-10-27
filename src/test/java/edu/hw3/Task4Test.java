package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Checking convertToRoman function efficiency")
    void testConvertToRoman() {
        assertThat(edu.hw3.Task4.convertToRoman(1159)).isEqualTo("MCLIX");
        assertThat(edu.hw3.Task4.convertToRoman(98)).isEqualTo("XCVIII");
        assertThat(edu.hw3.Task4.convertToRoman(1388)).isEqualTo("MCCCLXXXVIII");
        assertThat(edu.hw3.Task4.convertToRoman(3817)).isEqualTo("MMMDCCCXVII");
        assertThat(edu.hw3.Task4.convertToRoman(423)).isEqualTo("CDXXIII");
    }
}
