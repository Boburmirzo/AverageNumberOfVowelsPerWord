package ru.luxsoft.task.averagevowels.domain;

import ru.luxsoft.task.averagevowels.util.VowelsEnum;

import java.util.HashSet;
import java.util.Set;

public class VowelsSet implements Comparable<VowelsSet>{

    private Integer wordLength;
    private Double average;
    private Set<VowelsEnum> vowels;
    private int counter;

    public VowelsSet() {
        wordLength = 0;
        average = 0.0;
        vowels = new HashSet<>();
        counter = 0;
    }

    @Override
    public String toString() {
        return "({" + vowels + "}," + wordLength + ") -> " + average;
    }

    @Override
    public int compareTo(VowelsSet vowelsInWord) {
        return vowelsInWord.getWordLen() - this.wordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VowelsSet that = (VowelsSet) o;

        if (!vowels.equals(that.vowels)) return false;
        return wordLength.equals(that.wordLength);

    }

    @Override
    public int hashCode() {
        int result = vowels.hashCode();
        result = 31 * result + wordLength.hashCode();
        return result;
    }

    public void increment() {
        counter++;
    }

    public int getTotal() {
        return counter;
    }

    public void addVolwe(VowelsEnum vowel) {
        vowels.add(vowel);
    }

    public Set<VowelsEnum> getVowels() {
        return vowels;
    }

    public Integer getWordLen() {
        return wordLength;
    }

    public void setVowels(Set<VowelsEnum> vowels) {
        this.vowels = vowels;
    }

    public void setWordLen(Integer wordLen) {
        this.wordLength = wordLen;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
