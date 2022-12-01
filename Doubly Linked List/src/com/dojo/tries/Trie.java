package com.dojo.tries;

public class Trie {
	public Node root;
	
	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
//		GETS THE ROOT NODE
		Node currentNode = this.root;
		
//		ITERATES OVER EVERY CHARACTER IN THE WORD
		for(int i = 0; i < word.length(); i++) {
//			currentLetter is the character / letter at that iteration
			Character currentLetter = word.charAt(i);
//			check if the currentLetter is in the map of the current node
			Node child = currentNode.children.get(currentLetter);
			
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}
			
			currentNode = child;
		}
		
		currentNode.isCompleteWord = true;
	}
}
