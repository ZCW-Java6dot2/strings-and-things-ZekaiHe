package io.zipcoder;


import com.sun.tools.javac.code.Attribute;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        Integer counter = 0;
        String [] x = input.split(" ");
        for(String y:x){
            Character z = y.charAt(y.length()-1);
            if((z.toString()).equals("y") || (z.toString()).equals("z")){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String newWord = "";
        String newWordArr [] = base.split(remove);
        for(String words: newWordArr){
            newWord += words;
        }
        return newWord;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        String isLeftover = input;
        String notLeftover = input;
        Integer isCount = 0;
        Integer notCount = 0;

        for(int i = 0; i <= isLeftover.length(); i++){
            Integer x = isLeftover.indexOf("is");
            if (x!=-1){
                isLeftover = isLeftover.substring(x+2);
                isCount++;
            }
        }

        for(int i = 0; i <= notLeftover.length(); i++){
            Integer y = notLeftover.indexOf("not");
            if (y!=-1){
                notLeftover = notLeftover.substring(y+3);
                notCount++;
            }
        }

        if(isCount == notCount) {
            return true;
        }
        else    {
            return false;
        }

    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        boolean loopBroken = false;
        boolean g = false;
        Integer happyG = 0;
        Integer numOfG = 0;
        Integer length = input.length() - 2;

        for (int i = 1; i <= length; i++) {
            Character x = input.charAt(i);
            Character left = input.charAt(i - 1);
            Character right = input.charAt(i + 1);

            String sX = x.toString();
            String sLeft = left.toString();
            String sRight = right.toString();

            if(i ==1 && !sX.equals("g") && sLeft.equals("g")){ //tests edge cases of "gxxxggxx"
                g = false;
                loopBroken = true;
                break;
            }

            if (sX.equals("g")) {
                numOfG++;
                if (sLeft.equals("g") || sRight.equals("g")) {
                    happyG++;
                }
            }

            if(i == length && !sX.equals("g") && sRight.equals("g")){ //tests edge cases of "xxxggxxg"
                g = false;
                loopBroken = true;
                break;
            }

        }

        if (numOfG>0 && loopBroken==false) {
            if (happyG == numOfG) {
                g = true;
            } else {
                g = false;
            }
        }

        return g;
    }

    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        Integer length = input.length();
        Integer count = 0;

        if(input.length()>=3) {
            for (int i = 0; i <= length - 3; i++) {
                String x = input.substring(i, i+1);
                String right1 = input.substring(i + 1, i+2);
                String right2 = input.substring(i + 2, i+3);

                if (right1.equals(x) && right2.equals(x)) {
                    count++;
                }
            }
        }
        return count;
    }
}
