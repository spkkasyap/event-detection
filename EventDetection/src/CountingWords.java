// This program is to find the frequency of the words in Tweets
// @author prathyush

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CountingWords {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br= new BufferedReader(new FileReader("DexterTweets"));
		BufferedWriter bw= new BufferedWriter(new FileWriter("DexterText"));
		String tweet="";
		int count=0;
		while((tweet=br.readLine())!=null)
		{
			String[] tweetparts=tweet.split(",");
			String text="";
			if(tweetparts.length==5)
				{
					text=tweetparts[4];
				}
			else
			{
				System.out.println("Tweet contains comma inside the text");
				for(int i=4;i<tweetparts.length;i++)
					text+=tweetparts[i];
			}
			bw.write(text+"\n");
			count++;
		}
		System.out.println("Number of tweets:"+count);
		br.close();
		bw.close();
	}

}
