package friendship;

import graph.UndirectedGraph;

import java.io.*;
import java.util.*;


/**
 * Models the friendships between people.
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class FriendshipModel {

    private UndirectedGraph<Person> friendshipGraph;

    /**
     * Instantiates a model of friendships from a specified friendship file.
     * @param fileName The name of the text file to build the friendship model from.
     * @throws IllegalArgumentException if there was a problem reading the friendship file.
     */
    public FriendshipModel(String fileName) throws IllegalArgumentException {

        // TODO: Construct edges between friends.

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

    /**
     * Gets the subgraph of all people who attend the same school.
     * @param schoolName The name of the school.
     * @return <code>null</code> if no subgraph exists; otherwise an undirected graph of all people who attend the
     * specified school.
     */
    public UndirectedGraph<Person> getSubgraphOfSchool(String schoolName) {

        // TODO: Implement subgraph logic.

        return null;
    }

    /**
     * Gets the shortest introduction chain between two people.
     * @param personA The name of the first person.
     * @param personB The name of the second person.
     * @return <code>null</code> if no introduction chain exists between; otherwise an ordered list representing the
     * shortest introduction chain.
     */
    public List<Person> getIntroChain(String personA, String personB) {

        // TODO: Implement intro chain logic.

        return null;
    }

    /**
     * Gets all the connected islands (cliques) of a specified school.
     * @param schoolName The name of the school of which to find cliques.
     * @return <code>null</code> if no cliques exist; otherwise an unordered list of graphs representing each
     * respective clique.
     */
    public List<UndirectedGraph<Person>> getListOfCliquesOfSchool(String schoolName) {

        // TODO: Implement clique logic.

        return null;
    }

    /**
     * Gets all people who are the only connection between at least two other distinct persons.
     * @return <code>null</code> if this friendship model has no connectors; otherwise an unordered list of persons who
     * are connectors.
     */
    public List<Person> getListOfConnectors() {

        // TODO: Implement connector logic.

        return null;
    }
}
