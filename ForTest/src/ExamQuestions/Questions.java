package ExamQuestions;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    public static void main(){
        System.out.println("Main method : "+reverseStrAtI("string"));

    }

    public static String reverseStrAtI(String input){
        //String
        StringBuilder newString = new StringBuilder();
        List<Character> charList  =new ArrayList<>();
        for(int i =0; i<input.length(); i++){
            charList.add(input.charAt(i));
        }
//        System.out.println("List of Chars : "+charList);
        for(Character ch : charList){
            if(ch=='i'){
                System.out.println("Chars : "+ch);
                newString.reverse();
            }else{
                newString.append(ch);
            }
        }
        return newString.toString();
    }

}
