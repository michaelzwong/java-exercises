/**
 * LeetCode Medium.
 *
 * @author michaelwong
 *
 */
public class LC208 {
  private Trie[] characters;
  private boolean isLeaf;
  private Trie next;

  /** Initialize your data structure here. */
  public Trie() {
      characters = new Trie[26];
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
      // Keep track of the current trie we are on
      Trie cur = this;
      for(char c : word.toCharArray()) {
          Trie[] trieCharacters = cur.getCharacters();
          if(trieCharacters[c - 'a'] == null) {
              Trie newTrie = new Trie();
              trieCharacters[c - 'a'] = newTrie;
              cur = newTrie;
          } else {
              cur = trieCharacters[c - 'a'];
          }
      }
      cur.setLeaf(true);
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
      Trie cur = this;
      for(char c : word.toCharArray()) {
          Trie[] trieCharacters = cur.getCharacters();
          if(trieCharacters[c - 'a'] == null) {
              return false;
          }
          cur = trieCharacters[c - 'a'];
      }
      return cur.isLeaf();
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
      Trie cur = this;
      for(char c : prefix.toCharArray()) {
          Trie[] trieCharacters = cur.getCharacters();
          if(trieCharacters[c - 'a'] == null) {
              return false;
          }
          cur = trieCharacters[c - 'a'];
      }
      return cur != null;
  }

  public Trie[] getCharacters() {
      return characters;
  }

  public boolean isLeaf() {
      return isLeaf;
  }

  public void setLeaf(boolean value) {
      isLeaf = value;
  }
}
