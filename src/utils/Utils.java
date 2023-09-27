package utils;

import direction.Direction;
import direction.TranslateCharDirection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static List<String> parseAndCheckInputfile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        }
        checkInputFile(lines);
        return lines;
    }
    public static void checkPlateau(String plateauInput){
        String[] plateauInputArray = plateauInput.split(" ");
        if(plateauInputArray.length != 2){
            throw new IllegalArgumentException("Invalid plateau input");
        }
        if(Integer.parseInt(plateauInputArray[0]) <= 0 && Integer.parseInt(plateauInputArray[1]) <= 0) {
            throw new IllegalArgumentException("Invalid plateau dimensions");
        }
    }

    public static void checkRoverPosition(String roverPosition, String plateauInput){
        String[] roverPositionArray = roverPosition.split(" ");
        if(roverPositionArray.length != 3){
            throw new IllegalArgumentException("Invalid rover position");
        }
        int x = Integer.parseInt(roverPositionArray[0]);
        int y = Integer.parseInt(roverPositionArray[1]);
        Direction direction = TranslateCharDirection.valueOf(roverPositionArray[2]).getDirection();
        if(x < 0 || x > Integer.parseInt(plateauInput.split(" ")[0]) || y < 0 || y > Integer.parseInt(plateauInput.split(" ")[1])){
            throw new IllegalArgumentException("Invalid rover position");
        }

    }

    public static void chekRoverInstruction(String roverInstruction){
        for(char instruction : roverInstruction.toCharArray()){
            if(instruction != 'L' && instruction != 'R' && instruction != 'M'){
                throw new IllegalArgumentException("Invalid rover instruction");
            }
        }
    }

    public static void checkRovers(List<String> roverInputs, String plateauInput){
        if(roverInputs.size() % 2 != 0){
            throw new IllegalArgumentException("Invalid rover input");
        }
        for(int i = 0; i < roverInputs.size(); i+=2){
            checkRoverPosition(roverInputs.get(i), plateauInput);
            chekRoverInstruction(roverInputs.get(i+1));
        }
    }

    public static void checkInputFile(List<String> inputs) throws IOException{
        checkPlateau(inputs.get(0));
        checkRovers(inputs.subList(1, inputs.size()), inputs.get(0));
    }

}


