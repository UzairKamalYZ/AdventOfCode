package be.techfix.advent.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class SonarSweepTest {

    @Test
    void should_return_numberof_increased_from_the_sweeping_list() {
        SonarSweep sonarSweep = new SonarSweep();

        int count = sonarSweep.getNumberofIncreased(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
        assertThat(count).isEqualTo(7);
    }

    @Test
    void should_return_number_of_increased_for_big_sweeping_list() throws URISyntaxException, IOException {

        int[] ints = getInputSweepts();

        SonarSweep sonarSweep = new SonarSweep();
        int numberofIncreased = sonarSweep.getNumberofIncreased(ints);
        assertThat(numberofIncreased).isEqualTo(1832);
    }


    @Test
    void should_return_increade_number_of_summing_sweeps() throws URISyntaxException, IOException {
        int[] ints = getInputSweepts();
        SonarSweep sonarSweep = new SonarSweep();
        int[] sumOf3SizeWindow = sonarSweep.getSumOf3SizeWindow(ints);
        assertThat(sonarSweep.getNumberofIncreased(sumOf3SizeWindow)).isEqualTo(1858);

    }

    private int[] getInputSweepts() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("input.txt")).toURI());

        Stream<String> lines = Files.lines(path);
        int[] ints = lines.mapToInt(Integer::parseInt).toArray();
        lines.close();
        return ints;
    }
}
