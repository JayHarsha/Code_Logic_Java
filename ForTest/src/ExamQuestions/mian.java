package ExamQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class mian {

	public static void main(String []args) {
//		int[] nums = new int[] {1,1,2,2,2,3,4};
//		HashMap<Integer,Integer> map = new HashMap<>();
//        //int[] newarray = new int[nums.length];
//        int k=0;
//        for(int i : nums) {
//        	if(!map.containsKey(i)) {
//        		map.put(i, 1);
//        	}
//        	else {
//        		map.put(i, map.get(i)+1);
//        	}
//        }

        String ex= null;
		splitString("ZOHO");
		//System.out.println(addFactorials(145));

	}

	/**
	 * returns true if factorials of individual numbers in a number is equal to that number.
	 * @param input
	 * @return
	 */
	public static boolean addFactorials(int input){
		boolean ifFactEqual = false;
		List<Integer> numList = seperateNumToList(input);
		int indNum=0;
		for(Integer num: numList){
			indNum = indNum+fact(num);
			//System.out.println("Only Facts : "+fact(num));
			//System.out.println("Sum of Facts : "+indNum);
		}
		if(indNum == input){
			return ifFactEqual = true;
		}
		return ifFactEqual;
	}

	public static List<Integer> seperateNumToList(int num){
		boolean fact = false;
		String num1 = Integer.toString(num);
//		int length = num1.length();
//		int j =1;
//		if(length>1) {
//			for (int i = 0; i < length - 1; i++) {
//				j = j * 10;
//			}
//		}
//		List<Integer> numListNew = new ArrayList<Integer>();
//		for(Character charVar : num1.toCharArray()){
//			numListNew.add(Character.getNumericValue(charVar));
//		}

//		System.out.println(j);
//		List<Integer> numList = new ArrayList<Integer>();
//		if(length == (Integer.toString(j)).length()){
//			for(int i=0 ;i<length; i++){
//				if(j>=1){
//					//System.out.println("J is : "+j);
//					int digit = num/j;
//					num = num%j;
//					//System.out.println("Num : "+num);
//					//System.out.println("Digit : "+digit);
//					j=j/10;
//					numList.add(digit);
//				}
//			}
//		}
		//List<String> numListString = Stream.of(num1.split("")).toList();
		List<Integer> numListInt = Integer.toString(num).chars().map(Character :: getNumericValue).boxed().toList();

		System.out.println(numListInt);

		return numListInt;
	}

	public static int fact(int num){
		if(num ==0){
			return 1;
		}
		return num* fact(num-1);
	}

	/**
	 * Splits and arranges the String according to the frequency of the String
	 * input  : AABBBCDD
	 * output : BBBAADDC
	 * @param input
	 */
	public static void splitString(String input){
		List<Character> charList = new ArrayList<Character>();
		int length = input.length();
		for(int i=0; i<length;i++){
			charList.add(input.charAt(i));
		}
		System.out.println(charList);
		LinkedHashMap<Character,Integer> mapList = new LinkedHashMap<>();
		for(Character alpha : charList){
			if(mapList.containsKey(alpha)){
				mapList.put(alpha,mapList.get(alpha)+1);
			}
			else{
				mapList.put(alpha,1);
			}
		}
		System.out.println(mapList);
		LinkedHashMap<Character, Integer> sortedMap = mapList.entrySet()
				.stream()
				.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new
				));

		System.out.println("SortedMap : " + sortedMap);
		StringBuilder stringBuild = new StringBuilder();
		for(HashMap.Entry<Character, Integer> map : sortedMap.entrySet()){
            stringBuild.append(String.valueOf(map.getKey()).repeat(map.getValue()));
		}
		System.out.println("OUTPUT: "+ stringBuild);
	}

	public static List<Integer> minSumSubArray(List<Integer> minArray, int target){
		//[1,2,3,5], 7
		List<Integer> minSubArray = new ArrayList<>();
		for(int i=0; i<minArray.size(); i++){
			if(minArray.get(i) == target){
				minSubArray.add(i);
				return minSubArray;
			}
			for(int j=1; i<minArray.size(); j++){
				if(minArray.get(i)+minArray.get(j) >= target){
					 minSubArray.add(i);
					 minSubArray.add(j);
					 return minSubArray;
				}
			}
		}
		return null;
	}
}