package com.company;
import java.util.Scanner;
import java.util.Random;

//Main class
public class Main {

    public static void main(String[] args) {
        Random randGen = new Random();
        Scanner scnr = new Scanner(System.in);
	    int loop = 0;
        //SecureRandom question1 = new SecureRandom(); //create new object for questions
        while(loop == 0){
            SecureRandom question1 = new SecureRandom(); //create new object for questions and initialize
            question1.setDifficulty(scnr);
            question1.setType(scnr);
            question1.askQuestion(scnr);
            loop = question1.genResponse(scnr);
        }
        return ;


    }
}

//create secure Random object class
class SecureRandom{
    private int userDifficulty = 0;
    private int userType = 0;
    private int correct = 0;
    private int incorrect = 0;
    private int a = 0;
    private int b = 0;
    private int session = 0;
    double answer = 0;
    //A method is used to determine the difficulty level
    public void setDifficulty(Scanner scnr) {
        System.out.println("Choose difficulty from 1 to 4:");
        userDifficulty = scnr.nextInt();
        return;
    }
    //A method is used to determine the problem type
    public void setType(Scanner scnr) {
        System.out.println("Choose problem type. (1 - addition, 2 - multiplication, 3 - subtraction, 4 - division, 5 - mixture");
        userType = scnr.nextInt();
        return;
    }
    // A method is used to generate the questions
    public void askQuestion(Scanner scnr) {
        // Prompts user with question
        Random randGen = new Random();
        //10 times, generate numbers
        for (int i = 0; i < 10; i++) {
            if (userDifficulty == 1) {
                a = randGen.nextInt(10); //0-9
                b = randGen.nextInt(10);
            } else if (userDifficulty == 2) {
                a = randGen.nextInt(99 - 10 + 1) + 10; //10 - 99
                b = randGen.nextInt(99 - 10 + 1) + 10;
            } else if (userDifficulty == 3) {
                a = randGen.nextInt(999 - 100 + 1) + 100; //100 - 999
                b = randGen.nextInt(999 - 100 + 1) + 100;
            } else if (userDifficulty == 4) {
                a = randGen.nextInt(9999 - 1000 + 1) + 1000; // 1000 - 9999
                b = randGen.nextInt(9999 - 1000 + 1) + 1000;
            }

            //first four cases
            if (userType == 1) {
                answer = (double) a + b;
                System.out.println("" + "How much is " + a + " plus " + b + "?");
            } else if (userType == 2) {
                answer = (double) a * b;
                System.out.println("" + "How much is " + a + " times " + b + "?");
            } else if (userType == 3) {
                answer = (double) a - b;
                System.out.println("" + "How much is " + a + " minus " + b + "?");
            } else if (userType == 4) {
                answer = (double) a / b;
                System.out.println("" + "How much is " + a + " divided by " + b + "?");
            }
            //mixture
            else if (userType == 5) {
                int mixture = randGen.nextInt(4) + 1;
                if (mixture == 1) {
                    answer = (double) a + b;
                    System.out.println("" + "How much is " + a + " plus " + b + "?");
                } else if (mixture == 2) {
                    answer = (double) a * b;
                    System.out.println("" + "How much is " + a + " times " + b + "?");
                } else if (mixture == 3) {
                    answer = (double) a - b;
                    System.out.println("" + "How much is " + a + " minus " + b + "?");
                } else if (mixture == 4) {
                    answer = (double) a / b;
                    System.out.println("" + "How much is " + a + " divided by " + b + "?");
                }
            }
            int response = randGen.nextInt(4) + 1;
            double userAnswer = scnr.nextDouble();
            if (Math.abs(userAnswer - answer) < 0.0001) {
                switch(response){
                    case 1:
                        System.out.println("Very good!");
                        break;
                    case 2:
                        System.out.println("Excellent!");
                        break;
                    case 3:
                        System.out.println("Nice work!");
                        break;
                    case 4:
                        System.out.println("Keep up the good work!");
                        break;
                }
                correct = correct + 1;
            }
            if(Math.abs(userAnswer - answer) >= 0.0001){
                switch(response){
                    case 1:
                        System.out.println("No. Please try again.");
                        break;
                    case 2:
                        System.out.println("Wrong. Try once more.");
                        break;
                    case 3:
                        System.out.println("Don’t give up!");
                        break;
                    case 4:
                        System.out.println("No. Keep trying.");
                        break;
                }
                incorrect = incorrect + 1;
            }
        }

        return;
    }


    public int genResponse(Scanner scnr) {
        System.out.println("Correct answers: " + correct + ", Incorrect answers: " + incorrect +"");
        double percentCorrect = correct / 10.0;
        if(percentCorrect < 0.75){
            System.out.println("Please ask your teacher for extra help.");
        }
        else{
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        System.out.println("Would you like to begin a new session? (0 - yes, 1 - no");
        session = scnr.nextInt();
        return session;
    }

    }









