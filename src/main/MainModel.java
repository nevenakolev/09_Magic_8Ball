package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainModel {
    Random rd = new Random();
    MainController mainctrl = new MainController();
    String answerType;

    //lists with answers separated in positive, negative and neutral
    private ArrayList<String> posAnswer = new ArrayList<>(
            Arrays.asList("It is certain.",
                    "It is decidedly so.",
                    "Without a doubt.",
                    "Yes - definitely.",
                    "You may rely on it.",
                    "As I see it, yes.",
                    "Most likely.",
                    "Outlook good.",
                    "Yes.",
                    "Signs point out yes.")
    );
    private ArrayList<String> negAnswer = new ArrayList<>(
            Arrays.asList("Don't count on it.",
                    "My reply is no.",
                    "My sources say no.",
                    "Outlook not so good.",
                    "Very doubtful.")
    );
    private ArrayList<String> neutAnswer = new ArrayList<>(
            Arrays.asList("Reply hazy, try again.",
                    "Ask again later.",
                    "Better not tell you now.",
                    "Cannot predict now.",
                    "Concentrate and ask again.")
    );

    //Methods
    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getAnswerType() {
        return answerType;
    }

    public String getRandomAnswer(String question) {
        if(!question.contains("?")) {
            setAnswerType("no question");
            return "Please enter a question :(";
        } else if(question.toUpperCase().contains("MATH") || question.toUpperCase().contains("SEW")) {
            setAnswerType("positive");
            return posAnswer.get(rd.nextInt(posAnswer.size()));
        } else {
            int choice = rd.nextInt(2);
            if(choice == 0) {
                setAnswerType("neutral");
                return neutAnswer.get(rd.nextInt(neutAnswer.size()));
            } else {
                setAnswerType("negative");
                return negAnswer.get(rd.nextInt(negAnswer.size()));
            }
        }
    }
}