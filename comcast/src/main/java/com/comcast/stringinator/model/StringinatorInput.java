package com.comcast.stringinator.model;

import org.jetbrains.annotations.NotNull;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringinatorInput {
    private String input;

    public StringinatorInput() {
    }

    public StringinatorInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String getOccur() {

        String str = input;
        int[] freq = new int[str.length()];
        char minChar = str.charAt(0), maxChar = str.charAt(0);
        int i, j, min, max;

        //Converts given string into character array
        char string[] = str.toCharArray();

        //Count each word in given string and store in array freq
        for(i = 0; i < string.length; i++) {
            freq[i] = 1;
            for(j = i+1; j < string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ' && string[i] != '0') {
                    freq[i]++;

                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
        }

        //Determine minimum and maximum occurring characters
        min = max = freq[0];
        for(i = 0; i <freq.length; i++) {

            //If min is greater than frequency of a character
            //then, store frequency in min and corresponding character in minChar
            if(min > freq[i] && freq[i] != '0') {
                min = freq[i];
                minChar = string[i];
            }
            //If max is less than frequency of a character
            //then, store frequency in max and corresponding character in maxChar
            if(max < freq[i]) {
                max = freq[i];
                maxChar = string[i];

            }
        }
        String maxCount=Character.toString((maxChar));
        return maxCount;
    }


    public int GetCount() {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] charArray = input.replaceAll("\\s+", "").toCharArray();

        for (char c : charArray)
        {
            if (charCountMap.containsKey(c))
            {
                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                charCountMap.put(c, 1);
            }
        }

        Set<Entry<Character, Integer>> entrySet = charCountMap.entrySet();

        int maxCount = 0;

        for (Entry<Character, Integer> entry : entrySet)
        {
            if (entry.getValue() > maxCount)
            {
                maxCount = entry.getValue();

            }
        }

        return maxCount;
    }

    public String getWord()
    {
        //String myStr = "how can I find the most frequent word in an string how can I find how how how string";
        String[] splited = input.split(" ");
        Arrays.sort(splited);
        System.out.println(Arrays.toString(splited));
        int max = 0;
        int count= 1;
        String word = splited[0];
        String curr = splited[0];
        for(int i = 1; i<splited.length; i++){
            if(splited[i].equals(curr)){
                count++;
            }
            else{
                count =1;
                curr = splited[i];
            }
            if(max<count){
                max = count;
                word = splited[i];
            }
        }
        return word;
    }

    public String getLongest()
    {
        String string = input;
        String word = "", small = "", large="";
        String[] words = new String[100];
        int length = 0;

        string = string + " ";

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != ' '){
                word = word + string.charAt(i);
            }
            else{

                words[length] = word;

                length++;

                word = "";
            }
        }

        small = large = words[0];


        for(int k = 0; k < length; k++){

            if(small.length() > words[k].length())
                small = words[k];


            if(large.length() < words[k].length())
                large = words[k];
        }
        return large;
    }

    public void setInput(String input) {
        this.input = input;
    }
}

