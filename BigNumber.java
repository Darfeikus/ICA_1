import java.util.*;
class BigNumber implements Comparable<BigNumber>{
	
	String number;

	BigNumber(String s){
		number=s;
		if (s.length()>64)
			throw new BigNumberOverflowException();
		for (int i = 0;i<s.length();i++) {
			if((int)(s.charAt(i))<48 || (int)(s.charAt(i))>57)
				throw new InvalidBigNumberException("Contains Non Digits");
		}	
	}

	BigNumber(){
		number="0";
	}

	int length(){
		return number.length();
	}

	String str(){
		return number;
	}

	int intt(String s){
		return Integer.parseInt(s);
	}

	BigNumber add(BigNumber other){
		String sum = "";
		String first ="";
		String second = "";
		int carry=0;
		if (this.compareTo(other)>=0) {
			second=other.str();
			int dif = this.compareTo(other);
			for (int i = 0;i<dif;i++)
				second="0"+second;
			first = number;
		}
		else{
			second=this.str();
			int dif = other.compareTo(this);
			for (int i = 0;i<dif;i++)
				second="0"+second;	
			first = other.str();
		}
		for (int i = first.length()-1;i>=0;i--) {
			int tSum = intt(Character.toString(first.charAt(i)))+intt(Character.toString(second.charAt(i)))+carry;
			carry=0;
			if(tSum>9){
				carry=1;
				tSum=tSum%10;
			}
			sum=Integer.toString(tSum)+sum;
			if(i==0 && carry==1)
				sum=carry+sum;
		}
		return new BigNumber(sum);
	}

	BigNumber subs(BigNumber other){
		String sub = "";
		String first ="";
		String second = "";
		int extraSub=0;
		if (this.compareNumericValue(other)>=0) {
			second=other.str();
			int dif = this.compareTo(other);
			for (int i = 0;i<dif;i++)
				second="0"+second;
			first = number;
		}
		else{
			throw new ArithmeticException("Not posible to substract");
		}

		for (int i = first.length()-1;i>=0;i--) {
			int upDigit=intt(Character.toString(first.charAt(i)))-extraSub;
			int downDigit=intt(Character.toString(second.charAt(i)));
			int tSub=0;
			if (upDigit<downDigit) {
				if(upDigit==-1)
					upDigit=9;
				else
					upDigit=upDigit+10;
				tSub = upDigit-downDigit;
				extraSub=1;
			}
			else{
				tSub = upDigit-downDigit;
				extraSub=0;	
			}
			if (i==0 && tSub==0) {
				sub=sub;
			}
			else
				sub=Integer.toString(tSub)+sub;
		}
		
		return new BigNumber(sub);	
	}

	BigNumber mult(BigNumber other){
		String mult = "";
		String first ="";
		String second = "";
		ArrayList<BigNumber> sums = new ArrayList<BigNumber>();
		int noSum = 0;
		int carry=0;
		if (this.compareTo(other)>=0) {
			first = number;
			second=other.str();
		}
		else{
			first = other.str();
			second = number;
		}
		for (int i =second.length()-1;i>=0;i--) {
			String tempBN="";
			carry=0;
			for (int k = 0;k<noSum;k++)
				tempBN+="0";
			int multiple = intt(Character.toString(second.charAt(i)));
			for (int j =first.length()-1;j>=0;j--) {
				int tMult= multiple * intt(Character.toString(first.charAt(j))) + carry;
				String stMult = Integer.toString(tMult);
				if (tMult>9) {
					carry=intt(Character.toString(stMult.charAt(0)));
					stMult=Character.toString(stMult.charAt(1));
				}
				else{
					carry=0;
					stMult=Character.toString(stMult.charAt(0));
				}
				tempBN=stMult+tempBN;
				if(j==0 && carry>0)
					tempBN=carry+tempBN;					
			}
			sums.add(new BigNumber(tempBN));
			noSum++;
		}
		BigNumber totalSum = new BigNumber();
		for (int i = 0;i<sums.size();i++) {
			totalSum=sums.get(i).add(totalSum);
		}

		return totalSum;
	}

	BigNumber div(BigNumber other){
		BigNumber quotient = null;
		if (this.compareNumericValue(other)==0)
			quotient=new BigNumber("1");
		else if(this.compareNumericValue(other)==-1){
			throw new ArithmeticException("Not possible division");
		}
		else{
					
			}
			System.out.println("El residuo es  " + residue);
		}
		return quotient;
	}

	public int compareTo(BigNumber other){
		if (number.length()==other.length())
			return 0;
		else if (number.length()>other.length())
			return number.length()-other.length();
		else
			return number.length()-other.length();
	}

	public int compareNumericValue(BigNumber other){
		boolean equals=true;
		String first =this.str();
		String second =other.str();
		if (this.compareTo(other)>=0) {
			int dif = this.compareTo(other);
			for (int i = 0;i<dif;i++)
				second="0"+second;
		}
		else{
			int dif = other.compareTo(this);
			for (int i = 0;i<dif;i++)
				first="0"+first;	
		}
		for (int i =0;i<first.length();i++) {
			if (intt(Character.toString(first.charAt(i)))>intt(Character.toString(second.charAt(i))))
				return 1;
			else if (intt(Character.toString(first.charAt(i)))<intt(Character.toString(second.charAt(i))))
				return -1;
		}
		return 0;

	}

	public String toString(){
		return number;
	}
}
