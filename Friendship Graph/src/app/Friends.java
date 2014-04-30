package app;

import friendship.FriendshipModel;
import friendship.Person;
import graph.UndirectedGraph;

import java.util.*;

/**
 * Driver for the friendship graph program.
 * @author Cameron pascal
 * @author Ari Shaposhnik
 */
public class Friends {

    private static FriendshipModel friendshipModel;

    public static void main(String args[]) {

        System.out.print("File name: ");
        String fileName = IO.readString();

        boolean isValidFileName = false;
        while (!isValidFileName) {
            try {
                friendshipModel = new FriendshipModel(fileName);
                isValidFileName = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(fileName + "is not a valid file. Please try again or type 'quit' to end.");
                System.out.print("File: ");
                String input = IO.readString();

                if (input.equalsIgnoreCase("quit")) {
                    System.out.println("Program exited.");
                    return;
                }
            }
        }

        while (true) {
            System.out.println("Friendship Graph\n");
            System.out.println("(1) Get subgraph of students at school.");
            System.out.println("(2) Get shortest intro chain between two people.");
            System.out.println("(3) Get all connected islands of people.");
            System.out.println("(4) Get all people who are connectors.");
            System.out.println("(5) Quit");
            int userCommandCode = IO.readInt();

            while (userCommandCode < 1 && userCommandCode > 5) {
                System.out.print(userCommandCode + " is not a valid command. Enter again (1..5): ");
                userCommandCode = IO.readInt();
            }
            switch (userCommandCode) {
                case 1:
                    // Get subgraph of students at school.
                    subgraphHandler();
                break;

                case 2:
                    // Get intro chain between two people.
                    introChainHandler();
                    break;

                case 3:
                    // Get all connected islands in friendship model.
                    connectedIslandHandler();
                break;

                case 4:
                    // Get people who are connectors.
                    connectorHandler();
                break;

                case 5:
                    System.out.println("Program exited.");
                    return;
            }
        }

    }

    private static void subgraphHandler() {

        System.out.println("Subgraph by school - Type 'exit' to return to previous menu.");

        String schoolName = IO.readString();
        if (schoolName.equalsIgnoreCase("exit")) {
            return;
        }

        UndirectedGraph<Person> schoolSubgraph = friendshipModel.getSubgraphOfSchool(schoolName);

        if (schoolSubgraph == null) {
            System.out.println("No subgraph exists for " + schoolName.toLowerCase());
            return;
        }

        System.out.println("Subgraph for " + schoolName.toLowerCase() + ":\n");

        schoolSubgraph.toString();
    }

    private static void introChainHandler() {

        System.out.println("Introduction chain of two people - Type 'exit' to return to previous menu.");

        String personA = IO.readString();
        if (personA.equalsIgnoreCase("exit")) {
            return;
        }

        String personB = IO.readString();
        if (personB.equalsIgnoreCase("exit")) {
            return;
        }

        ArrayList<Person> introChainList = friendshipModel.getIntroChain(personA, personB);

        if (introChainList == null) {
            System.out.println("No introduction chain exists between " + personA + " and " + personB + ".");
            return;
        }

        System.out.println("Introduction chain between " + personA + " and " + personB + ":\n");

        String introChain = "START -> ";
        for (Person p : introChainList) {
            introChain += p.NAME + " -> ";
        }
        introChain += "END";

        System.out.println(introChain);
    }

    private static void connectedIslandHandler() {

        System.out.println("All Cliques of a school - Type 'exit' to return to previous menu.");

        String schoolName = IO.readString();
        if (schoolName.equalsIgnoreCase("exit")) {
            return;
        }

        ArrayList<UndirectedGraph<Person>> listOfCliquesOfSchool = friendshipModel.getListOfCliquesOfSchool(schoolName);

        if (listOfCliquesOfSchool == null) {
            System.out.println("No cliques exist at " + schoolName + ".");
            return;
        }

        System.out.println("Cliques at " + schoolName + ":\n");

        for (int i=0; i<listOfCliquesOfSchool.size(); ++i) {

            System.out.println("Clique " + i + ":\n");
            UndirectedGraph<Person> clique = listOfCliquesOfSchool.get(i);
            System.out.println(clique.toString());
        }
    }

    private static void connectorHandler() {

        System.out.println("All People who are connectors\n");

        ArrayList<Person> listOfConnectors = friendshipModel.getListOfConnectors();

        if (listOfConnectors == null) {
            System.out.println("There are no people who are connectors.");
            return;
        }

        for (Person p : listOfConnectors) {
            System.out.println(p.NAME);
        }
    }
}