package strings;



import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class WordsMinHeap implements Comparable<WordsMinHeap>{

	String word ; 
	int count;
	
	public WordsMinHeap(String word, int count){
		super();
		this.word = word;
		this.count = count;
	}


	@Override
	public int compareTo(WordsMinHeap o) {
		// TODO Auto-generated method stub
		return Double.compare(count, o.count);
	}
}

public class CountWords {

	Trie t = new Trie();
	PriorityQueue<WordsMinHeap> pq = new PriorityQueue<WordsMinHeap>();
	
	public void insertTrieAndHeap(String word){
		// Read each word and add it to a trie 
		//If already exists in trie, increment the counter
		if(t.search(word)){
			
		}
		
		
	}
	
	public static void main(String[] args){
		
		
		CountWords cw = new CountWords();
		String paragraph = "This is count word dynamic check this word";
		
		String spl[] = paragraph.split(" ");
		for (String word : spl){
			cw.insertTrieAndHeap(word);
		}
 	}
}
