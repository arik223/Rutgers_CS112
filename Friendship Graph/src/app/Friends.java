package app;

import friendship.FriendshipModel;

import java.io.Console;

/**
 * Driver for the friendship graph program.
 * @author Cameron pascal
 * @author Ari Shaposhnik
 */
public class Friends {

    public static void main(String args[]) {

        String fileName = "";

        FriendshipModel fm;

        boolean isValidFileName = false;
        while (!isValidFileName) {
            try {
                fm = new FriendshipModel(fileName);
                isValidFileName = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(fileName + "is not a valid file. Please try again or type 'exit' to end.");
                System.out.print("File: ");
            }
        }

        int userCommandCode = -1;

        switch (userCommandCode) {
            case 1:
                // Get subgraph of students at school.

                String school = "";
                fm.getSubgraphOfSchool(school);
            break;

            case 2:
                // Get intro chain between two people.

                String personA = "", personB = "";
                fm.getIntroChain(personA, personB);
            break;

            case 3:
                // Get all connected islands in friendship model.

                String schoolName = "";
                fm.getListOfCliquesOfSchool(schoolName);
            break;

            case 4:
                // Get people who are connectors.
                fm.getListOfConnectors();

        }

    }

    private void getUserInput() {

    }
}
