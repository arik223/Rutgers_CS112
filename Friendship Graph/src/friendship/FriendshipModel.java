package friendship;

import graph.UndirectedGraph;

import java.io.*;
import java.util.*;


/**
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class FriendshipModel {

    // TODO: loadFriendships() - add neighbors.

    private UndirectedGraph<Person> friendshipGraph;

    public FriendshipModel(String fileName) throws IllegalArgumentException {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));  // Load in friendship file.

            try {
                String fileLine = br.readLine(); // Read first line of file for number of people.

                fileLine = fileLine.toLowerCase().trim();

                // Go through first line making sure only numbers are present.
                for (int i=0; i<fileLine.length(); i++) {
                    char c = fileLine.charAt(i);

                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("file: " + fileLine + " is not formatted correctly.");
                    }
                }

                int numPeople = Integer.parseInt(fileLine);

                ArrayList<Person> people = new ArrayList<Person>(numPeople);

                int personCount = 0;
                // Parse file for people and schools.
                while ( (fileLine = br.readLine()) != null) {

                    if (personCount++ < numPeople) {
                        break;
                    }

                    fileLine = fileLine.toLowerCase().trim();

                    int leftVerticalBarPos = fileLine.indexOf('|');
                    int rightVerticalBarPos = fileLine.lastIndexOf('|');

                    // Vertical bars cannot be the last character of the line.
                    if (leftVerticalBarPos + 1 > fileLine.length() || rightVerticalBarPos + 1 > fileLine.length()) {
                        throw new IllegalArgumentException("file: " + fileLine + " is not formatted correctly.");
                    }

                    // There must be at least one vertical bar in the line.
                    if (leftVerticalBarPos == -1) {
                        throw new IllegalArgumentException("file: " + fileLine + " is not formatted correctly.");
                    }

                    String name = fileLine.substring(0, leftVerticalBarPos);

                    String school = null;

                    // A person has a school if there are two vertical bars.
                    if (rightVerticalBarPos != leftVerticalBarPos) {

                        String schoolStatus = fileLine.substring(leftVerticalBarPos+1, rightVerticalBarPos);

                        // There must only be one character between vertical bars.
                        if (schoolStatus.length() != 1) {
                            throw new IllegalArgumentException("file: " + fileLine + " is not formatted correctly.");
                        }

                        school = fileLine.substring(rightVerticalBarPos+1, fileLine.length()-1);
                    }

                    people.add(new Person(name, school));
                }

                friendshipGraph = new UndirectedGraph<Person>(people);

                while ( (fileLine = br.readLine()) != null) {

                    int verticalBarPos = fileLine.indexOf('|');
                    //if (verticalBarPos+1)
                }

            } catch (IOException ioe) {

            }

        } catch (FileNotFoundException fnne) {
            System.out.println(fileName + "was not found.");
            System.exit(0);
        }
    }
}
