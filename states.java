/* This is just a demo of using hashmaps, it loads data from a .txt
*  and plays a simple game with the user to guess state capitals. 
*  Give it a try to find out how much more your 4th grade self knew!
*/
import java.io.*;
import java.util.*;

public class StateCapitals2_Ver_2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        
        Map<String, String> stateCapitals = new HashMap<>();

        int stateCount = 0;
        while (sc.hasNextLine()) {
            String[] currentLine = sc.nextLine().split("::");
            stateCapitals.put(currentLine[0], currentLine[1]);
            stateCount++;
        }
        System.out.print("You have " + stateCount + " states to choose from!\n");
        
        // Create Set and Collection objects to hold states (keys) and 
        // capitals (values).
        Set<String> keys = stateCapitals.keySet();
        Collection<String> values = stateCapitals.values();
        
        // Generate List / ArrayList polymorphic object to read keys from stateCapitals
        // Generate random object to choose a random key (state) from HashMap.
        List<String> keysAsArray = new ArrayList<>(keys);
        Random rand = new Random();
        
        // Generate List / ArrayList object to read the values from stateCapitals
        List<String> valuesAsArray = new ArrayList<>(values);
        
        // Using Set object, create a list of all keys 
        // representing the states, loop through and print it.
        for (int i = 0; i < keysAsArray.size(); i++){
            if(i != 0 && i != keysAsArray.size()){
                System.out.print(", ");
            }
            System.out.print(keysAsArray.get(i) + "");
        }
        System.out.println();
        
        System.out.println("Let's play a  game and test your knowledge of " + ""
                + "the capitals!\n");
        System.out.println("1) Pick how many states you'd like to guess." +
                "\n2) Answer each state prompt with the capital.  (Remember to " +  
                  "capitalize the first letter!)" + "\n3) The game will tell " +
                " you your final score.");
        
        // Make a scanner to read in player input for number of guesses
        // and for each guess
        Scanner input = new Scanner(System.in);
        System.out.println("\tHow many states would you like to guess for?");
        int numPlays = input.nextInt();
        
        // Create a list of the random states for this round
        List<String> statesToPlay = new ArrayList<>();
        
        // Pull a random state from the hashmap and load a list with each value
        while(statesToPlay.size() < numPlays){
            String state = (keysAsArray.get(rand.nextInt(keysAsArray.size())));
            if(!statesToPlay.contains(state)){
                statesToPlay.add(state);
            }
        }
        // Initiate guessing game
        String guess = "";
        
        //Consume first line and guess
        guess = input.nextLine();
        int numCorrect = 0;
        int numWrong = 0;
        for (int i = 0; i < numPlays; i++) {
            System.out.println("What is the capital of " + statesToPlay.get(i) +
                    ": ");
            guess = input.nextLine();
            if(guess.contentEquals(stateCapitals.get(statesToPlay.get(i)))){
            System.out.println("Correct! " + stateCapitals.get(statesToPlay.get(i)) 
                    + " is the capital of " + statesToPlay.get(i));
            numCorrect++;
            }
            else {
            System.out.println("Oops! " + stateCapitals.get(statesToPlay.get(i)) 
                    + " is the capital of " + statesToPlay.get(i));
            numWrong++;
            }
        }
        System.out.println("Number Correct: " + numCorrect + "\nNumber Wrong: " +
                numWrong);
    }
}


