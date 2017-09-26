package ru.luxsoft.task.averagevowels;

import ru.luxsoft.task.averagevowels.common.FileIO;
import ru.luxsoft.task.averagevowels.common.ResourceReader;
import ru.luxsoft.task.averagevowels.service.VowelsExecutor;

import java.io.IOException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        FileIO fileIO = new FileIO();
        fileIO.write(new VowelsExecutor().
                wordsToResultStream(fileIO.read(resourceReader.getInput()))
                .collect(Collectors.toList()),resourceReader.getOutput());
    }
}
