package books.headfirst.Lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private final int gridLength = 7;
    private final int gridSise = 49;
    private final int[] grid = new int[gridSise];
    private int comCount = 0;




    public String getUserInput(String userInput) {
        String inputLine = null;
        System.out.print(userInput + " ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();

        }catch (IOException e){
            System.out.println("Exception " + e);
        }
        assert inputLine != null;
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if((comCount % 2) == 1){
            incr = gridLength;
        }
        while (!success && attempts++ < 200){
            location = (int) (Math.random() * gridSise);
            int x = 0;
            success = true;
            while (success && x < comSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSise){
                        success = false;
                    }

                    if(x > 0 && (location % gridLength == 0)){
                        success = false;
                    }
                }else {
                    System.out.println("Используется " + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;

        while (x < comSize){
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println(" coord " + x + " = " + alphaCells.get(x - 1));
        }

        return alphaCells;

    }
}
