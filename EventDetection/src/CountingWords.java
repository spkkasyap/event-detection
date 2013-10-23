// This program is to find the frequency of the words in Tweets
// @author prathyush

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;


public class CountingWords {

	static TreeMap<Integer, String> transactionmap= new TreeMap<Integer, String>();
	static TreeMap<String, ArrayList<Integer>> itemmapping= new TreeMap<String, ArrayList<Integer>>();
	public static void main(String args[]) throws IOException
	{
		CountingWords object= new CountingWords();

		System.out.println("Number of tweets:"+count);

		object.WriteTransactionMap(count);
		object.WriteItemMap(count);

		System.out.println("size of words:"+itemmapping.size());
	
	}
	public void WriteTransactionMap(int count) throws IOException
	{
		BufferedWriter bw= new BufferedWriter(new FileWriter("TransactionMapping"));
		Iterator<Integer> it = transactionmap.keySet().iterator();
		while(it.hasNext())
		{
			int key= it.next();
			bw.write(key+":"+transactionmap.get(key)+"\n");
		}
		bw.close();
	}

	public void ReadTweetsFile(String filename) throws IOException
	{
		BufferedReader br= new BufferedReader(new FileReader("DexterTweets"));
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
			count++;
			String[] words= text.split(" ");
			int i=0;
			while(i<words.length && words[i].length()>4 && !words[i].contains("@"))
			{
				if(itemmapping.containsKey(words[i]))
				{
					ArrayList<Integer> list= itemmapping.get(words[i]);
					list.add(count);
					itemmapping.remove(words[i]);
					itemmapping.put(words[i], list);
				}
				else
				{
					ArrayList<Integer> temp= new ArrayList<Integer>();
					temp.add(count);
					itemmapping.put(words[i], temp);
				}
				i++;
			}

			transactionmap.put(count, text);
		}
		br.close();
	}
	
	public void WriteItemMap(int count) throws IOException
	{
		BufferedWriter bw1= new BufferedWriter(new FileWriter("ItemMapping"));
		Iterator<String> it1 = itemmapping.keySet().iterator();
		while(it1.hasNext())
		{
			String key1= it1.next();
			if(itemmapping.get(key1).size()>count/1000)
				bw1.write(key1+":"+itemmapping.get(key1)+"\n");
		}
		bw1.close();
	}

}
