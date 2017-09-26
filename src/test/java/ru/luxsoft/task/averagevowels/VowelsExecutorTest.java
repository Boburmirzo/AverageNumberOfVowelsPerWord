package ru.luxsoft.task.averagevowels;

import org.junit.Before;
import org.junit.Test;
import ru.luxsoft.task.averagevowels.domain.VowelsSet;
import ru.luxsoft.task.averagevowels.service.VowelsExecutor;
import ru.luxsoft.task.averagevowels.util.VowelsEnum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VowelsExecutorTest {

    private VowelsExecutor vowelsExecutor = new VowelsExecutor();

    private List<VowelsSet> result;
    private List<String> words = Stream
            .of("Platon", "made", "bamboo", "boats")
            .collect(Collectors.toList());

    @Before
    public void readListOfString(){
        result = vowelsExecutor.wordsToResultStream(words).collect(Collectors.toList());
        assertEquals(3, result.size());
    }

    @Test
    public void assertFirstGroup() {
        VowelsSet expected = new VowelsSet();
        expected.setVowels(Stream.of(VowelsEnum.A, VowelsEnum.O).collect(Collectors.toSet()));
        expected.setWordLen(6);
        expected.setAverage(2.5);

        assertGroup(expected, 0);
    }

    @Test
    public void assertSecondGroup() {
        VowelsSet expected = new VowelsSet();
        expected.setVowels(Stream.of(VowelsEnum.A, VowelsEnum.O).collect(Collectors.toSet()));
        expected.setWordLen(5);
        expected.setAverage(2.0);

        assertGroup(expected, 1);
    }

    @Test
    public void assertThirdGroup() {
        VowelsSet expected = new VowelsSet();
        expected.setVowels(Stream.of(VowelsEnum.A, VowelsEnum.E).collect(Collectors.toSet()));
        expected.setWordLen(4);
        expected.setAverage(2.0);

        assertGroup(expected, 2);
    }


    private void assertGroup(VowelsSet expected, Integer listIndex) {
        assertNotNull(result);
        assertEquals(expected, result.get(listIndex));
    }

}
