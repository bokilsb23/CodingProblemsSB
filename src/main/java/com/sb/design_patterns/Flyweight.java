package com.sb.design_patterns;

import java.util.*;

class Sentence
{
    private List<WordToken> wordTokens = new ArrayList<>();
    private String plainText;
    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }


    public WordToken getWord(int index)
    {
        WordToken wordToken = new WordToken(1);
        wordTokens.add(wordToken);
        return wordToken;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String[] strArray = plainText.split(" ");
        for(int i =0 ; i < strArray.length; i++){
            String wordToAppend = strArray[i];
            for(WordToken token : wordTokens){
                if(token.index  == i){
                    if(token.capitalize){
                        wordToAppend = wordToAppend.toUpperCase();
                    }
                }
            }
            sb.append(wordToAppend);
            if(i != strArray.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    class WordToken
    {
        public boolean capitalize;
        public int index;

        public WordToken(int index){
            this.index = index;
        }
    }
}

public class Flyweight {
    public static void main(String[] args) {
        Sentence stc = new Sentence("Make America Great Again");
        stc.getWord(1).capitalize = true;
        System.out.println(stc);
    }
}
