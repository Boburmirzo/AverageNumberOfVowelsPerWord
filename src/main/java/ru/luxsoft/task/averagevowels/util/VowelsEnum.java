package ru.luxsoft.task.averagevowels.util;

public enum VowelsEnum {

    U('u'),
    Y('y'),
    O('o'),
    A('a'),
    I('i'),
    E('e');

    private Character vowel;

    VowelsEnum(Character value) {
        this.vowel = value;
    }

    public Character getValue() {
        return vowel;
    }

}
