package com.example;

import java.util.ArrayList;

public class Joker {

   static int jokeNumber=0;
   ArrayList<String> jokes;

    public Joker(){
        jokes=new ArrayList<>();
        addJokes();
    }

    private void addJokes()
    {
        jokes.add("Elephant & Ant were walking on a bridge.\n" +
                "Then d elephant looked down toward d river.\n" +
                "Suddenly ant bit the elephant.\n" +
                "Y?\n" +
                "Bcoz ants wife was bathing in the river.");

        jokes.add("Three ants find an elephant asleep.\n" +
                "One says,\"We'll kill him!\"\n" +
                "Other one says,\"We'll break his legs!\"\n" +
                "3rd one says: \"choro yaar bechara akela hai aur hum teen..!!\":-)");

        jokes.add("Q- a parrots sits on an elephant and the elephant died!!\n" +
                "Prove how is this possible.? . . . . . . .\n" +
                "Physics student: assume that elephant's name is parrot & parrot's name is elephant:d:p:)\n" +
                "physics can prove anything");

        jokes.add("What Happens When The Elephant Sat On The Mercedes Car ... ??? . . . .\n" +
                "Everyone Knows \"The Mercedes bends\" ;->");

        jokes.add("A girl's speaking 2 a boy........ u r very handsome. u r very cute. u r very sweet.\n" +
                "ooph.......sorry. i can't call u sweet.... because ants will finish u.");

        jokes.add("In a practical Exam Examiner showed legs of bird n said:Tell the bird's name?\n" +
                "Sardar:I dont know.\n" +
                "Exminer: U r failed.\n" +
                "Wats ur name?\n" +
                "Sardar: You see my legs,and tell me.");
    }


    public String spillJoke()
    {
        String joke=jokes.get(jokeNumber);
        jokeNumber++;
        if(jokeNumber==jokes.size())
        {
            jokeNumber=0;
        }
        return joke;
    }

}
