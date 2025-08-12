package org.atak.problems;

import java.util.*;

/** Advanced Interview Problems These include system design concepts and complex algorithms */
public class InterviewAdvanced {

  public static void main(String[] args) {
    InterviewAdvanced advanced = new InterviewAdvanced();

    // Test LRU Cache
    System.out.println("=== LRU Cache Implementation ===");
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("Get 1: " + cache.get(1)); // returns 1
    cache.put(3, 3); // evicts key 2
    System.out.println("Get 2: " + cache.get(2)); // returns -1 (not found)
    cache.put(4, 4); // evicts key 1
    System.out.println("Get 1: " + cache.get(1)); // returns -1 (not found)
    System.out.println("Get 3: " + cache.get(3)); // returns 3
    System.out.println("Get 4: " + cache.get(4)); // returns 4

    // Test Word Ladder
    System.out.println("\n=== Word Ladder ===");
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println("Ladder length: " + advanced.ladderLength("hit", "cog", wordList));

    // Test Course Schedule
    System.out.println("\n=== Course Schedule ===");
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println("Can finish courses: " + advanced.canFinish(4, prerequisites));

    // Test Number of Islands
    System.out.println("\n=== Number of Islands ===");
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    System.out.println("Number of islands: " + advanced.numIslands(grid));
  }

  /**
   * Problem 1: LRU Cache Implementation Time Complexity: O(1) for both get and put Space
   * Complexity: O(capacity)
   */
  static class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      cache = new HashMap<>();
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      if (cache.containsKey(key)) {
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
      }
      return -1;
    }

    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        Node node = cache.get(key);
        node.value = value;
        moveToHead(node);
      } else {
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addNode(newNode);
        if (cache.size() > capacity) {
          Node tail = popTail();
          cache.remove(tail.key);
        }
      }
    }

    private void addNode(Node node) {
      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(Node node) {
      Node prev = node.prev;
      Node next = node.next;
      prev.next = next;
      next.prev = prev;
    }

    private void moveToHead(Node node) {
      removeNode(node);
      addNode(node);
    }

    private Node popTail() {
      Node res = tail.prev;
      removeNode(res);
      return res;
    }

    class Node {
      int key;
      int value;
      Node prev;
      Node next;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

  /**
   * Problem 2: Word Ladder (BFS) Time Complexity: O(N * L * 26) where N is wordList length, L is
   * word length Space Complexity: O(N)
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int level = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String current = queue.poll();
        if (current.equals(endWord)) return level;

        char[] chars = current.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char original = chars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            chars[j] = c;
            String newWord = new String(chars);
            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
              queue.offer(newWord);
              visited.add(newWord);
            }
          }
          chars[j] = original;
        }
      }
      level++;
    }
    return 0;
  }

  /**
   * Problem 3: Course Schedule (Topological Sort) Time Complexity: O(V + E) Space Complexity: O(V +
   * E)
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    int[] inDegree = new int[numCourses];
    for (int[] prereq : prerequisites) {
      graph.get(prereq[1]).add(prereq[0]);
      inDegree[prereq[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;
      for (int neighbor : graph.get(course)) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    return count == numCourses;
  }

  /**
   * Problem 4: Number of Islands (DFS) Time Complexity: O(M * N) Space Complexity: O(M * N) in
   * worst case
   */
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int numIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          numIslands++;
          dfs(grid, i, j);
        }
      }
    }
    return numIslands;
  }

  private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0'; // Mark as visited
    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }

  /**
   * Problem 5: Implement Trie (Prefix Tree) Time Complexity: O(L) for insert and search, O(L) for
   * startsWith Space Complexity: O(ALPHABET_SIZE * L * N) where L is average word length, N is
   * number of words
   */
  static class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (!node.children.containsKey(c)) {
          node.children.put(c, new TrieNode());
        }
        node = node.children.get(c);
      }
      node.isEnd = true;
    }

    public boolean search(String word) {
      TrieNode node = searchPrefix(word);
      return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
      TrieNode node = searchPrefix(prefix);
      return node != null;
    }

    private TrieNode searchPrefix(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (node.children.containsKey(c)) {
          node = node.children.get(c);
        } else {
          return null;
        }
      }
      return node;
    }

    class TrieNode {
      Map<Character, TrieNode> children = new HashMap<>();
      boolean isEnd = false;
    }
  }

  /**
   * Problem 6: Serialize and Deserialize Binary Tree Time Complexity: O(N) Space Complexity: O(N)
   */
  public String serialize(TreeNode root) {
    if (root == null) return "null";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();
    if ("null".equals(val)) return null;

    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.left = deserializeHelper(queue);
    root.right = deserializeHelper(queue);
    return root;
  }

  // TreeNode class
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
