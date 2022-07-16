// https://www.hackerrank.com/challenges/reduced-string/problem


class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        
        while (true) {
            // Used for loop termination
            int len = s.length();
            
            // "(.)" is a capturing group that captures any character
            // "\\1" is a backreference that will match the character captured by the first capturing group (i.e. the one captured by "(.)")
            s = s.replaceAll("(.)\\1", "");
            // If no changes were made to string, break loop
            if( s.length() == len ){
                break;
            }
        }

        return (s.isEmpty()) ? "Empty String" : s;

    }

}
