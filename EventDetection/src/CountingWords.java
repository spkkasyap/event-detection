// This program is to find the frequency of the words in Tweets
// @author prathyush

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CountingWords {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader(new FileReader("DexterTweets"));
		String tweet="";
		int count=0;
		while((tweet=br.readLine())!=null)
		{
			count++;
		}
		System.out.println("Number of tweets:"+count);
		br.close();
	}

}
