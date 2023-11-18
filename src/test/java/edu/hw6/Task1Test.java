package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Test DiskMap working")
    void testDiskMap() {
        DiskMap diskMap = new DiskMap();

        diskMap.clear();
        assertThat(diskMap.size()).isEqualTo(0);
        assertThat(diskMap.isEmpty()).isEqualTo(true);
        assertThat(diskMap.containsKey("first")).isEqualTo(false);
        assertThat(diskMap.containsValue("second")).isEqualTo(false);

        diskMap.put("first", "second");
        diskMap.put("first", "second");
        assertThat(diskMap.size()).isEqualTo(1);
        diskMap.put("second", "third");
        assertThat(diskMap.size()).isEqualTo(2);
        diskMap.remove("second");
        assertThat(diskMap.containsKey("first")).isEqualTo(true);
        assertThat(diskMap.size()).isEqualTo(1);

        diskMap.clear();
        diskMap.putAll(new HashMap<>(Map.ofEntries(
            new ImmutablePair<>("first", "f"),
            new ImmutablePair<>("second", "s"),
            new ImmutablePair<>("third", "t")
        )));
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(diskMap.values().toArray()).containsExactly("f", "s", "t");
        assertThat(Arrays.stream(
            diskMap.keySet().toArray()).sorted().toArray()).containsExactly("first", "second", "third");

        diskMap.clear();
    }
}
