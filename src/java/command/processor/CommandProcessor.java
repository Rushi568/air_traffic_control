/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.processor;

/**
 *
 * @author Kali
 */
public class CommandProcessor {

    private static final String[] codes = tokenize("Alfa,Bravo,Charlie,Delta,Echo,Foxtrot,Golf,Hotel,India,Juliett,Kilo,Lima,Mike,November,Oscar,Papa,Quebec,Romeo,Sierra,Tango,Uniform,Victor,Whiskey,Xray,Yankee,Zulu");

    public static String modifyFlightNumber(String flightnumber) {

        String temp = "";
        System.out.println(flightnumber);
        for (char f : flightnumber.toCharArray()) {

            if (f != ' ') {
                temp = temp + "-" + f;
            }

        }
        return temp;
    }
   

    

    public static String[] tokenize(String command) {
        return command.split(" ");
    }

    public static boolean hasSpecialCode(String[] words) {
        for (String word : words) {
            for (String code : codes) {
                if (word.equalsIgnoreCase(code)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String hasWhichCodes(String[] words) {
        String temp = null;
        for (String word : words) {
            for (String code : codes) {
                if (word.equalsIgnoreCase(code)) {
                    temp += code.charAt(0);
                }
            }
        }
        return temp;

    }

    public static String getFlightNumber(String command) {
        
            String[] tokens = tokenize(command);
            int len = tokens.length;
            for (int i = 0; i < len; i++) {
                if (tokens[i].equalsIgnoreCase("flight") || tokens[i].equalsIgnoreCase("flightnumber") || tokens[i].equalsIgnoreCase("flightno") || tokens[i].equalsIgnoreCase("flight-number") || tokens[i].equalsIgnoreCase("flight-num")) {
                    return tokens[i + 1] + " " + tokens[i + 2];
                }
            }

            return null;
       

        }
    

    public static boolean contains(String line, String word) {
        String[] tokens = tokenize(line);
        String wordChoices[] = word.split("/");
        for (String eachWord : wordChoices) {
            String[] ex=tokenize(eachWord);
            for(String tkn: ex)
            for (String token : tokens) {
                if (token.equalsIgnoreCase(tkn)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean contains(String word, char letter) {
        word = word.toLowerCase();
        char[] c = word.toCharArray();

        for (char ch : c) {
            if (ch == letter) {
                return true;
            }
        }
        return false;
    }

    public static char processAlphabet(String code) {

        for (String str : codes) {
            if (code.equalsIgnoreCase(str)) {
                return code.charAt(0);
            }
        }
        return code.charAt(0);
    }

    public static String getCode(char ch) {
        for (String code : codes) {
            if (code.charAt(0) == ch) {
                return code;
            }
        }
        return null;

    }

}
