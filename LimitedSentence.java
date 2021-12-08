//idan malka
//315655647
public class LimitedSentence {
/**
*Fields of department 
*/
	private String sentence; 
	private char delimiter;
	/*
	 * this is the default method
	 * @return default parameters.
	 * */
	public LimitedSentence() {
		this.delimiter = ' ';
		this.sentence = "" ;
	}/**
	a method that gets a char and place it between sentences
	@param delimiter char 32 .
	@return delimiter and empty sentence if not by the rules that given
	*/
	public LimitedSentence(char delimiter) {
		this.delimiter = delimiter;
		sentence = "";
		final int diff = 32;
		if(this.delimiter >= 'A' && this.delimiter <= 'Z' && this.delimiter >= 'a' && this.delimiter <= 'z' ) {
			delimiter = diff;
		}
	}/**
	a copy constructor of sentence and delimiter*/
	public LimitedSentence(LimitedSentence other) {
		this.sentence = new String(other.sentence);
		this.delimiter = other.delimiter;
		
	}/*
	@return sentence 
	**/
	public String getSentence() {
		return this.sentence;
	}/**
	@return delimiter*/
	public char getDelimiter() {
		return delimiter;
	}/**
	a method that gives you the first letter in the sentence 
	@return char at index(0)
	*/
	public char getFirstLetter() {
		if(sentence == "") {
			return 0;
		}
		return sentence.charAt(0);
	}/**
	@return middle letter in sentence
	*/
	public char getMiddleLetter() {
		if(sentence == "") {
			return 0;
		}
		int i = sentence.length() ;
		char posM = 0 ;
		if(sentence.length() % 2 ==  0) {
			 posM = sentence.charAt((i/2));
			return posM;
		}
		else if(sentence.length() % 2 != 0) {
			 posM = sentence.charAt((i/2));
		}return posM;
	}/**
	@return last letter in the sentence.
	*/
	public char getLastLetter() {
		if(sentence == "") {
			return 0;
		}
		int i = sentence.length();
		char posL = 0;
		posL = sentence.charAt(i-1);
		return posL;
	}/**
	a method that adds a word to the ending of the sentence 
	@param counter , a loop to check chars if eligible.
	@return a new sentence*/
	public boolean appendWordEnd(String toAppend) {
		int count = 0 ; 
		for(int i=0; i<toAppend.length();i++) {
			if(toAppend.charAt(i) >= 65 && toAppend.charAt(i) <= 90 || toAppend.charAt(i) >= 97 && toAppend.charAt(i) <= 122) {
				count++;
				if(sentence == "") {
					sentence += toAppend;
					return true;
				}
				else if(count == toAppend.length() && toAppend.length()+sentence.length() <=25) {
					sentence = sentence + this.delimiter + toAppend;
					return true;
				}
			}
		}return false;
	}/**
	a method that adds a word at the beginning of the sentence 
	@param counter and a loop to check chars .
	@return a new sentence*/
	public boolean appendWordFront(String toAppend) {
		int count = 0;
		for(int i=0; i<toAppend.length();i++) {
			if(toAppend.charAt(i) >= 'A' && toAppend.charAt(i) <= 'Z' || toAppend.charAt(i) >= 'a' && toAppend.charAt(i) <= 'z') {
				count++;
				if(sentence == "") {
					sentence += toAppend;
					return true;
				}
				else if(count == toAppend.length() && toAppend.length()+sentence.length() <=25 && sentence != "") {
					sentence = toAppend + this.delimiter + sentence;
					return true;
				}
			}
		}return false;
		
	}/**
	a method that gets a number and gives you the word within those index number
	@param string that is empty for the word , and a delimiter , and a counter
	@return the word that is requested
	*/
	
	 public String getIthWord(int i) {
		 int count = 0;
		 String first = "";
		 char find1 = delimiter;
		 for(int j=0 ; j<sentence.length();j++) {
			 if(sentence.charAt(j) == find1) {
				 count++;
				 if(count-1 < i) {
					 first ="";
				 }
				 if(count-1 == i) {
					 break;
				 }
			 }else if(sentence.charAt(j)!= find1) {
				 first += sentence.charAt(j);
			 }
		 }if(count < i ) {
			 first = "";
		 }
		 return first;
				
	 }/**
	 does the same as the previous method and gives you the words at a reverse versa
	 @param string for new reverse word , a counter , a delimiter .
	 @return the word that requested in reverse . */
	 public String getIthWordReversed(int i) {
		 int count = 0;
		 String first = "";
		 String rev = "";
		 char find1 = delimiter;
		 for(int j=0 ; j<sentence.length();j++) {
			 if(sentence.charAt(j) == find1) {
				 count++;
				 if(count-1 < i) {
					 first ="";
				 }if(count-1 == i) {
					 break;
				 }else if (count -1 > i) {
					 first = "";
				 }

			 }else if(sentence.charAt(j)!= find1) {
				 first += sentence.charAt(j);
			 }
			 
		 }if(count < i ) {
			 first = "";
		 }
		 for(int k=first.length()-1;k>=0;k--) {
			 rev += first.charAt(k);
		 }
		 return rev;

	 }/**
	 a method that count words in the sentence .
	 @param 2 int to count and a delimiter and a loop.
	 @return the number of words in the sentence .
	 */
	 public int countWords() {
		 int numbers = 0;
		 int j=0;
		 char find2 = delimiter;
		 for(j=0;j<sentence.length();j++) {
			 if(sentence.charAt(j)==find2) {
				 numbers++;
			 }
		 }if(sentence.charAt(sentence.length()-1) != find2) {
			 numbers +=1;
		 }
		 return numbers;
	 }/**
	 a method that reverse the upper case and lower case of the characters
	 @param a new string 
	 @return the same sentence with upper and lower case upside down. */
	 public void reverseUpperLower() {
		 String s = "";
		 int j=0;
		 for(j=0;j<sentence.length();j++) {
			 if(sentence.charAt(j) >= 'A' && sentence.charAt(j)<= 'Z') {
				s += (char)(this.sentence.charAt(j)+32);
			 }else if(sentence.charAt(j) >= 'a' && sentence.charAt(j) <= 'z') {
				 s += (char)(this.sentence.charAt(j)-32);
			 }else {
				 s += (char)(this.sentence.charAt(j));
			 }
		 }this.sentence =s;
		 
	 }
	 public String toString() {
		 return this.sentence;
	 }
	 
}
