package stacksandqueue;

import java.util.Stack;

// Each tower is basically a stack
class Tower {
	Stack<Integer> discs ;
	int index;
	public Tower(int i){
		discs = new Stack<Integer>();
		index = i ;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public void displayTower(){
		System.out.println("Tower "+this.index+" "+this.discs.toString());
	}
	
	public void addToDestination(int disc){
		
		if(!this.discs.isEmpty() && this.discs.peek() < disc){
			System.out.println("Error moving discs");
		}
		else{
			this.discs.push(disc);
		}
	}

	public void moveTop(Tower source, Tower destination){
		int top = source.discs.pop();
		destination.addToDestination(top);
		System.out.println("Moving disc "+top+ " from "+source.index+ " to "+destination.index);
	}
	
	public void moveDisks(int n, Tower source, Tower destination, Tower buffer){
		//System.out.println("SOurce is "+source.index+ " b "+buffer.index+ " des "+destination.index);
		if(n>0){
			moveDisks(n-1, source,buffer, destination);
			moveTop(source, destination);
			moveDisks(n-1, buffer, destination, source);
		}
	}
}

public class TowerOfHanoi {

	public static void main(String[] args) {
		
		// Initialize 3 towers
		int n = 3 ;
		Tower [] towers = new Tower[n];
		for(int i=0; i < n; i++){
			towers[i] = new Tower(i);
		}
		
		//For tower 0 which is origin initialize the disc
		int numDisks = 3;
		for(int i=numDisks; i >0; i--){
			towers[0].discs.push(i);
		}
		
		//towers[0].displayTower();
		towers[0].moveDisks(numDisks, towers[0], towers[2], towers[1]);
		
	} // end main

}
