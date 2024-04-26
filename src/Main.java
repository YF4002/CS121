import java.util.Scanner;
import java.util.Random;


    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();
            String player1;
            String player2;
            // new additions to initialize variables for anything outside the original for loop.
            int hP1 = 0;
            int hP2 = 0;
            int attackSpeed1 = 0;
            int attackSpeed2 = 0;
            int movePower1 = 0;
            int movePower2 = 0;
            int player1wins = 0;
            int player2wins = 0;
            int points = 1;
            int rounds;

            System.out.println("Enter an odd number of rounds:");
            rounds = scanner.nextInt();

            if (rounds % 2 == 0) {
                System.out.println("Please enter an odd number of rounds:");
                return;


            }
            for (int roundNum = 1; roundNum <= rounds; roundNum++) {
                System.out.println("Round " + roundNum + " :");

                System.out.println(" ");


                System.out.println("PLayer 1: Select a Character and enter its stats");
                System.out.println("Enter name:");
                String name1 = scanner.next();
                System.out.println("Enter HP:");
                hP1 = scanner.nextInt();
                System.out.println("Enter move name:");
                String move1 = scanner.next();
                System.out.println("Enter move's Power:");
                movePower1 = scanner.nextInt();
                System.out.println("Enter attack speed:");
                attackSpeed1 = scanner.nextInt();

                System.out.println("PLayer 2: Select a Character and enter its stats");
                System.out.println("Enter name:");
                String name2 = scanner.next();
                System.out.println("Enter HP:");
                hP2 = scanner.nextInt();
                System.out.println("Enter move name:");
                String move2 = scanner.next();
                System.out.println("Enter move's Power:");
                movePower2 = scanner.nextInt();
                System.out.println("Enter attack speed:");
                attackSpeed2 = scanner.nextInt();

                if (attackSpeed1 > attackSpeed2) {
                    // Makes sure hp is drained to zero to find a round winner
                    while (hP2 > 0 || hP1 > 0) {
                        hP2 = hP2 - movePower1;
                        hP1 = hP1 - movePower2;
                    }
                    //removed the setting of points to zero, so you always know how many points someone has
                    if (hP2 <= 0) {
                        System.out.println("Player 1 is the round winner");
                        player1wins += points;
                        // new variable is needed for a player1wins total if you wish to only show final score at the end.
                        System.out.println("Player 1 wins:" + player1wins);
                        System.out.println("Player 2 wins:" + player2wins);
                    } else{
                        System.out.println("Player 2 is the round winner");
                        player2wins += points;
                        System.out.println("Player 1 wins:" + player1wins);
                        System.out.println("Player 2 wins:" + player2wins);

                    }


                } else if (attackSpeed2 > attackSpeed1) {
                    while (hP2 > 0 || hP1 > 0) {
                        hP2 = hP2 - movePower1;
                        hP1 = hP1 - movePower2;
                    }
                    if (hP1 <= 0) {
                        System.out.println("Player 2 is the round winner");
                        player2wins += points;
                        System.out.println("Player 1 wins:" + player1wins);
                        System.out.println("Player 2 wins:" + player2wins);
                    }else{
                        System.out.println("Player 1 is the round winner");
                        player1wins += points;
                        System.out.println("Player 1 wins:" + player1wins);
                        System.out.println("Player 2 wins:" + player2wins);
                    }


                }
                // was stuck within the last else-if loop above, moved it outside that loop.
                if (attackSpeed1 == attackSpeed2) {
                    int random = rand.nextInt(2);
                    if (random == 0) {
                        while (hP2 > 0 || hP1 > 0) {
                            hP2 = hP2 - movePower1;
                            hP1 = hP1 - movePower2;
                        }
                        if (hP2 <= 0) {
                            System.out.println("Player 1 is the round winner");
                            player1wins += points;
                            System.out.println("Player 1 wins:" + player1wins);
                            System.out.println("Player 2 wins:" + player2wins);
                        } else{
                            System.out.println("Player 2 is the round winner");
                            player2wins += points;
                            System.out.println("Player 1 wins:" + player1wins);
                            System.out.println("Player 2 wins:" + player2wins);
                        }

                    } else if (random == 1) {
                        // does the same here, just in case they choose a very high value.
                        while (hP2 > 0 || hP1 > 0) {
                            hP2 = hP2 - movePower1;
                            hP1 = hP1 - movePower2;
                        }
                        if (hP1 <= 0) {
                            System.out.println("Player 2 is the round winner");
                            player2wins += points;
                            System.out.println("Player 1 wins:" + player1wins);
                            System.out.println("Player 2 wins:" + player2wins);
                        }else{
                            System.out.println("Player 1 is the round winner");
                            player1wins += points;
                            System.out.println("Player 1 wins:" + player1wins);
                            System.out.println("Player 2 wins:" + player2wins);
                        }
                    }

                }
            }
            System.out.println("Final Scores:");
            System.out.println("Player 1 Wins: " + player1wins);
            System.out.println("Player 2 wins: " + player2wins);

            if (player1wins > player2wins) {
                System.out.println("Player 1 has won the game!");
            } else if (player1wins < player2wins) {
                System.out.println("Player 2 has won the game!");
            }
        }
    }
