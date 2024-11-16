package ad.practice.playground.solution;

public class Solution {
        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            boolean last;
            public TrieNode(){
                for(int i = 0; i<26;i++){
                    child[i] = null;
                }
                last = false;
            }
        }
    
        class Trie{
            TrieNode root;
            public Trie(){
                this.root = new TrieNode();
            }
    
            public void insert(String word){
                TrieNode node = root;
                for(int i = 0;i < word.length();i++){
                    char c = word.charAt(i);
                    if(root.child[c-'a'] == null){
                        TrieNode newNode = new TrieNode();
                        node.child[c-'a'] = newNode;
                    }
                    node = node.child[c-'a'];
                }
                node.last = true;
            }
            public boolean search (String word){
                TrieNode node = new TrieNode();
                int n = word.length();
                for(int i = 0;i<n; i++){
                    char c = word.charAt(i);
                    if(node.child[c-'a'] == null) return false;
                    node = node.child[c-'a'];
                }
                return node.last;
            }
        }
        public boolean wordBreak(String s, String[] words) {
            Trie trie = new Trie();
            for(String t : words){
                trie.insert(t);
            }
            return trie.search(s);
        }
    }
    

