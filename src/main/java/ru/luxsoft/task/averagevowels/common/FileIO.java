package ru.luxsoft.task.averagevowels.common;

import ru.luxsoft.task.averagevowels.domain.VowelsSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {

    public List<String> read(final String path) throws IOException {
        return Files.lines(Paths.get(path))
                .map(line -> line.split("[^a-zA-Z0-9\\-']"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    public void write(List<VowelsSet> vowelsSets, final String path) throws IOException {
        List<String> out = vowelsSets.stream()
                .map(VowelsSet::toString)
                .map(v -> v.replaceAll("\\[", "").replaceAll("\\]", ""))
                .collect(Collectors.toList());
        Files.write(Paths.get(path), out);
    }
}
