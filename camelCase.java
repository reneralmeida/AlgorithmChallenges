package easy;

/**
 String Challenge - Coderbyte
 Have the function StringChallenge(str) take the str parameter being passed and return it in proper camel case format where the first letter of each
 word is capitalized (excluding the first letter). The string will only contain letters and some combination of delimiter punctuation characters separating each word.

 For example: if str is "BOB loves-coding" then your program should return the string bobLovesCoding.
 Once your function is working, take the final output string and concatenate it with your ChallengeToken, and then replace every third character with an X.

 Your ChallengeToken: fjruwh7vye5c
 */
public class CamelCase {

	public static String[] StringChallenge(String str) {
		// code goes here
		return str
				.toLowerCase()
				.replaceAll("([^a-z])", " ")
				.replaceAll(" +", " ")
				.trim().split(" ");
	}

	private static String camelCase(String str) {
		StringBuilder camel = new StringBuilder();
		String[] words = StringChallenge(str);
		int index = 0;
		for (String word : words) {
			if (index == 0) {
				camel.append(word);
			} else {
				camel.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
			}
			index++;
		}
		return camel.toString();
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


	public static void main (String[] args) {

		var result1 = camelCase("_RENER_loves_coding_");
		System.out.println(result1);

		System.out.println(every3rd("renerLovesCodingfjruwh7vye5c", 3));

		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge(s.nextLine()));
	}

}