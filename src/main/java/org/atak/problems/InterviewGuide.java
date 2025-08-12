package org.atak.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/** Interview Preparation Guide Comprehensive study material and mock interview questions */
public class InterviewGuide {

  public static void main(String[] args) {
    System.out.println("=== INTERVIEW PREPARATION GUIDE ===\n");

    // Print study guide
    printStudyGuide();

    // Print mock interview questions
    printMockQuestions();

    // Print common patterns
    printCommonPatterns();
  }

  private static void printStudyGuide() {
    System.out.println("📚 STUDY GUIDE FOR CODING INTERVIEWS");
    System.out.println("====================================\n");

    System.out.println("1. DATA STRUCTURES TO MASTER:");
    System.out.println("   • Arrays and Strings (most common)");
    System.out.println("   • HashMaps and HashSets");
    System.out.println("   • Stacks and Queues");
    System.out.println("   • Linked Lists");
    System.out.println("   • Trees (Binary Trees, BST)");
    System.out.println("   • Graphs (DFS, BFS)");
    System.out.println("   • Heaps (Priority Queues)");
    System.out.println("   • Tries (Prefix Trees)");

    System.out.println("\n2. ALGORITHMS TO KNOW:");
    System.out.println("   • Two Pointers Technique");
    System.out.println("   • Sliding Window");
    System.out.println("   • Binary Search");
    System.out.println("   • Dynamic Programming");
    System.out.println("   • Backtracking");
    System.out.println("   • Topological Sort");
    System.out.println("   • Union Find");
    System.out.println("   • Kadane's Algorithm");

    System.out.println("\n3. TIME COMPLEXITY ANALYSIS:");
    System.out.println("   • Always mention time and space complexity");
    System.out.println("   • Be ready to optimize solutions");
    System.out.println("   • Know Big O notation well");

    System.out.println("\n4. CODING BEST PRACTICES:");
    System.out.println("   • Write clean, readable code");
    System.out.println("   • Handle edge cases");
    System.out.println("   • Use meaningful variable names");
    System.out.println("   • Add comments for complex logic");
    System.out.println("   • Test with examples");

    System.out.println("\n5. INTERVIEW TIPS:");
    System.out.println("   • Clarify the problem first");
    System.out.println("   • Think out loud");
    System.out.println("   • Start with brute force if needed");
    System.out.println("   • Optimize step by step");
    System.out.println("   • Ask questions about constraints");
    System.out.println("   • Be honest about what you don't know");
  }

  private static void printMockQuestions() {
    System.out.println("\n🎯 MOCK INTERVIEW QUESTIONS");
    System.out.println("==========================\n");

    System.out.println("EASY LEVEL:");
    System.out.println("1. Reverse a string in-place");
    System.out.println("2. Find the missing number in an array");
    System.out.println("3. Check if a string is a palindrome");
    System.out.println("4. Find the first non-repeating character");
    System.out.println("5. Merge two sorted arrays");

    System.out.println("\nMEDIUM LEVEL:");
    System.out.println("1. Implement LRU Cache");
    System.out.println("2. Word Ladder (BFS)");
    System.out.println("3. Course Schedule (Topological Sort)");
    System.out.println("4. Number of Islands (DFS)");
    System.out.println("5. Serialize/Deserialize Binary Tree");
    System.out.println("6. Implement Trie (Prefix Tree)");
    System.out.println("7. Maximum Subarray Sum (Kadane's)");
    System.out.println("8. Valid Parentheses");

    System.out.println("\nHARD LEVEL:");
    System.out.println("1. Design a URL shortener");
    System.out.println("2. Design a rate limiter");
    System.out.println("3. Design a distributed cache");
    System.out.println("4. Implement a thread-safe cache");
    System.out.println("5. Design a recommendation system");
  }

  private static void printCommonPatterns() {
    System.out.println("\n🔍 COMMON PROBLEM PATTERNS");
    System.out.println("=========================\n");

    System.out.println("1. ARRAY/STRING PATTERNS:");
    System.out.println("   • Two Pointers: Use when you need to compare elements");
    System.out.println("   • Sliding Window: Use for subarray/substring problems");
    System.out.println("   • Prefix Sum: Use for range sum queries");
    System.out.println("   • Kadane's: Use for maximum subarray problems");

    System.out.println("\n2. TREE PATTERNS:");
    System.out.println("   • DFS (Pre/In/Post order): Use for traversal");
    System.out.println("   • BFS (Level order): Use for level-wise processing");
    System.out.println("   • Recursive: Use for tree construction/modification");

    System.out.println("\n3. GRAPH PATTERNS:");
    System.out.println("   • DFS: Use for connected components, cycles");
    System.out.println("   • BFS: Use for shortest path, level-wise");
    System.out.println("   • Topological Sort: Use for dependency resolution");
    System.out.println("   • Union Find: Use for connected components");

    System.out.println("\n4. DYNAMIC PROGRAMMING PATTERNS:");
    System.out.println("   • 1D DP: Use for linear problems");
    System.out.println("   • 2D DP: Use for matrix problems");
    System.out.println("   • Memoization: Use for recursive optimization");
    System.out.println("   • Tabulation: Use for iterative optimization");
  }

  /** Mock Interview Question 1: Design a Rate Limiter This is a common system design question at */
  static class RateLimiter {
    private Map<String, Queue<Long>> requests;
    private int maxRequests;
    private long windowSize;

    public RateLimiter(int maxRequests, long windowSizeInSeconds) {
      this.requests = new HashMap<>();
      this.maxRequests = maxRequests;
      this.windowSize = windowSizeInSeconds * 1000; // Convert to milliseconds
    }

    public boolean isAllowed(String userId) {
      long currentTime = System.currentTimeMillis();

      if (!requests.containsKey(userId)) {
        requests.put(userId, new LinkedList<>());
      }

      Queue<Long> userRequests = requests.get(userId);

      // Remove old requests outside the window
      while (!userRequests.isEmpty() && currentTime - userRequests.peek() > windowSize) {
        userRequests.poll();
      }

      // Check if we can allow this request
      if (userRequests.size() < maxRequests) {
        userRequests.offer(currentTime);
        return true;
      }

      return false;
    }
  }

  /** Mock Interview Question 2: Thread-Safe Cache - Common concurrency question */
  static class ThreadSafeCache<K, V> {
    private final Map<K, V> cache;
    private final Object lock = new Object();

    public ThreadSafeCache() {
      this.cache = new HashMap<>();
    }

    public V get(K key) {
      synchronized (lock) {
        return cache.get(key);
      }
    }

    public void put(K key, V value) {
      synchronized (lock) {
        cache.put(key, value);
      }
    }

    public boolean containsKey(K key) {
      synchronized (lock) {
        return cache.containsKey(key);
      }
    }

    public void remove(K key) {
      synchronized (lock) {
        cache.remove(key);
      }
    }

    public int size() {
      synchronized (lock) {
        return cache.size();
      }
    }
  }

  /** Mock Interview Question 3: URL Shortener Design System design question commonly asked */
  static class URLShortener {
    private Map<String, String> shortToLong;
    private Map<String, String> longToShort;
    private static final String CHARS =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    public URLShortener() {
      this.shortToLong = new HashMap<>();
      this.longToShort = new HashMap<>();
    }

    public String shorten(String longUrl) {
      if (longToShort.containsKey(longUrl)) {
        return longToShort.get(longUrl);
      }

      String shortUrl = generateShortUrl();
      while (shortToLong.containsKey(shortUrl)) {
        shortUrl = generateShortUrl();
      }

      shortToLong.put(shortUrl, longUrl);
      longToShort.put(longUrl, shortUrl);
      return shortUrl;
    }

    public String expand(String shortUrl) {
      return shortToLong.get(shortUrl);
    }

    private String generateShortUrl() {
      StringBuilder sb = new StringBuilder();
      Random random = new Random();
      for (int i = 0; i < SHORT_URL_LENGTH; i++) {
        sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
      }
      return sb.toString();
    }
  }

  /** Practice Problem: Find Kth Largest Element - Common interview question */
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.offer(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return minHeap.peek();
  }

  /** Practice Problem: Valid Anagram String manipulation question */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] charCount = new int[26];

    for (char c : s.toCharArray()) {
      charCount[c - 'a']++;
    }

    for (char c : t.toCharArray()) {
      charCount[c - 'a']--;
      if (charCount[c - 'a'] < 0) return false;
    }

    return true;
  }

  /** Practice Problem: Maximum Product Subarray Dynamic programming question */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];
    int minEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int temp = maxEndingHere;
      maxEndingHere = Math.max(nums[i], Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]));
      minEndingHere = Math.min(nums[i], Math.min(temp * nums[i], minEndingHere * nums[i]));
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }
}
