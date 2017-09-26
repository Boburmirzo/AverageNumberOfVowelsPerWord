package ru.luxsoft.task.averagevowels.service;

import ru.luxsoft.task.averagevowels.domain.VowelsSet;
import ru.luxsoft.task.averagevowels.util.VowelsEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The VowelsExecutor program implements a main
 * functions of project. It calculates average number of
 * vowels in a list of words and gives stream of a set of vowels with its data
 * @author  Umurzokov Boburmirzo
 * @version 1.0
 * @since   2017-09-26
 */
public class VowelsExecutor {

    /**
     * This method is used to find a average number of vowels per word
     * @param words It is a list of words after parsing from input file
     * @return stream of VowelsSets.
     */
    public Stream<VowelsSet> wordsToResultStream(List<String> words) {

        List<VowelsSet> vowelsInWordList = new ArrayList<>();

        words.forEach(w -> {
            List<VowelsEnum> allVowels = findVowelsInAWord(w);

            VowelsSet vowelsInWord = new VowelsSet();
            vowelsInWord.setVowels(new HashSet<>(allVowels));
            vowelsInWord.setWordLen(w.length());
            vowelsInWord.setAverage((double) allVowels.size());
            vowelsInWord.increment();

            final boolean[] contains = new boolean[1];
            vowelsInWordList.stream()
                    .filter(v -> v.equals(vowelsInWord))
                    .forEach(v -> {
                        contains[0] = true;
                        v.increment();
                        v.setAverage((v.getAverage() + vowelsInWord.getAverage()) / v.getTotal());
                    });

            if(!contains[0]) {
                vowelsInWordList.add(vowelsInWord);
            }

        });

        return vowelsInWordList.stream().sorted();
    }

    /**
     * This method is used to find a vowels in one word
     * @param wordString String a word
     * @return stream of VowelsEnum.
     */
    private List<VowelsEnum> findVowelsInAWord(String wordString) {
        wordString = wordString.toLowerCase();
        List<Character> availableVowels = Stream.of(VowelsEnum.values())
                .map(VowelsEnum::getValue)
                .sorted()
                .collect(Collectors.toList());

        List<Character> word = wordString.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());

        List<int[]> indexList = availableVowels.stream()
                .map(e -> IntStream.range(0, word.size())
                        .filter(i -> word.get(i) == e)
                        .toArray())
                .filter(v -> v.length > 0)
                .collect(Collectors.toList());

        List<Integer> allIndexes = new ArrayList<>();
        for (int[] anIndexList : indexList) {
            for (int anAnIndexList : anIndexList) {
                allIndexes.add(anAnIndexList);
            }
        }

        return allIndexes.stream()
                .map(i -> VowelsEnum.valueOf(String.valueOf(Character.toUpperCase(word.get(i)))))
                .collect(Collectors.toList());
    }


}
