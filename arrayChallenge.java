package com.example.demo;

import java.util.*;


/**
 Array Challenge - Coderbyte
 Have the function ArrayChallenge(strArr) read the array of strings stored in strArr, which will contain 2 elements:
  the first element will be a sequence of characters, and the second element will be a long string of comma-separated words,
  in alphabetical order, that represents a dictionary of some arbitrary length. For example: strArr can be: ["hellocat",
  "apple,bat,cat,goodbye,hello,yellow,why"]. Your goal is to determine if the first element in the input can be split into two words,
  where both words exist in the dictionary that is provided in the second input. In this example, the first element can be split into two words:
  hello and cat because both of those words are in the dictionary.
 Your program should return the two words that exist in the dictionary separated by a comma. So for the example above, your program should return hello,cat.
  There will only be one correct way to split the first element of characters into two words. If there is no way to split string into two words that exist in
  the dictionary, return the string not possible. The first element itself will never exist in the dictionary as a real word.
 Once your function is working, take the final output string and concatenate it with your ChallengeToken, and then replace every third character with an X.

 Your ChallengeToken: fjruwh7vye5c
 */
public class DemoApplication {

	private static List<String> ArrayChallenge(String s, String[] dict) {
		Set<String> dictSet = new HashSet<>(Arrays.asList(dict));
		int[] dp = new int[s.length() + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - dict.length);
		int[] pre = new int[s.length() + 1];
		String[] words = new String[s.length() + 1];
		for(int i=1;i<=s.length();i++) {
			String subS = s.substring(0, i);
			if(dictSet.contains(subS)) {
				dp[i] = 1;
				pre[i] = 0;
				words[i] = subS;
			}
			else {
				for(int j=0;j<i;j++) {
					if(dictSet.contains(s.substring(j, i))) {
						if(dp[j] + 1 < dp[i]) {
							words[i] = s.substring(j, i);
							pre[i] = j;
							dp[i] = dp[j] + 1;
						}
					}
				}
			}
		}
		List<String> res = new ArrayList<>();
		if(dp[dp.length - 1] == Integer.MAX_VALUE - dict.length)
			return res;
		int max = dp.length - 1;
		res.add(words[dp.length - 1]);
		while(max > 0) {
			if(words[pre[max]] != null)
				res.add(words[pre[max]]);
			max = pre[max];
		}
		Collections.reverse(res);
		return res;
	}

	public static String every3rd(String finalOutput, int n) {
		if (n < 1) {
			throw new IllegalArgumentException("Value greater than 0 required");
		}
		StringBuilder result = new StringBuilder(finalOutput);
		for (int i = n - 1; i < finalOutput.length(); i += n) {
			result.setCharAt(i, 'X');
		}
		return result.toString();
	}

	public static void main(String[] args) {

		String s1 = "baseball";
		String[] dict1 = {"a","all","b","ball","bas","base","cat","code","d","e","quit","z"};
		var result = ArrayChallenge(s1, dict1);
		System.out.println(result);
		System.out.println(every3rd("base,ballfjruwh7vye5c", 3));

		// keep this function call here
//		Scanner s = new Scanner(System.in);
//		System.out.print(ArrayChallenge(s.nextLine()));
//	}

	}
}