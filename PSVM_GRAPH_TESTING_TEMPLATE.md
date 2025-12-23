# LeetCode Problem PSVM Testing Template

## Overview
This document provides a reusable template for writing a `public static void main()` method that:
1. Creates sample input data for any LeetCode problem
2. Calls an empty algorithm method with the input
3. Verifies the results and prints test output

The method provided is **always empty** - you implement the logic yourself.

---

## Quick Reference

### When to Use This Template
- Any LeetCode problem (arrays, strings, trees, graphs, linked lists, etc.)
- Need to test your algorithm with sample inputs
- Want a consistent pattern for all problem types

### Key Components
1. **Input Creation** - Set up sample test data
2. **Algorithm Invocation** - Call your empty solution method
3. **Result Output** - Print and verify results

---

## Generic Template Structure

```java
public class YourProblemName {

    // ============ EMPTY METHOD TO IMPLEMENT ============
    public <ReturnType> solveMethod(<InputType> input) {
        // TODO: Implement your solution here
        return null;
    }

    // ============ MAIN METHOD - SAMPLE EXECUTION ============
    public static void main(String[] args) {
        YourProblemName solution = new YourProblemName();

        // STEP 1: Create sample input
        <InputType> input = <create input>;

        // STEP 2: Call algorithm
        <ReturnType> result = solution.solveMethod(input);

        // STEP 3: Print results
        System.out.println("=== Test Results ===");
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
```

---

## Example 1: Array Problem - Two Sum

```java
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // TODO: Implement your solution here
        return null;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println("=== Two Sum Test ===");
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(result));
        
        if (result != null && result.length == 2) {
            System.out.println("✓ Test passed!");
        } else {
            System.out.println("✗ Test failed!");
        }
    }
}
```

---

## Example 2: String Problem - Palindrome

```java
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // TODO: Implement your solution here
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";

        boolean result1 = solution.isPalindrome(input1);
        boolean result2 = solution.isPalindrome(input2);

        System.out.println("=== Palindrome Test ===");
        System.out.println("Input 1: \"" + input1 + "\"");
        System.out.println("Output 1: " + result1 + " (Expected: true)");
        System.out.println();
        System.out.println("Input 2: \"" + input2 + "\"");
        System.out.println("Output 2: " + result2 + " (Expected: false)");
    }
}
```

---

## Example 3: Graph Problem - Clone Graph

```java
import com.zenith.structures.GraphNode;

public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        // TODO: Implement your solution here
        return null;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Create sample graph: 1 -- 2
        //                      |    |
        //                      +----+
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        GraphNode clonedGraph = solution.cloneGraph(node1);

        System.out.println("=== Clone Graph Test ===");
        System.out.println("Original node: " + node1 + " (value: " + node1.val + ")");
        System.out.println("Cloned node: " + clonedGraph);
        if (clonedGraph != null) {
            System.out.println("Cloned value: " + clonedGraph.val);
            System.out.println("Are different objects? " + (node1 != clonedGraph));
        }
    }
}
```

---

## Example 4: LinkedList Problem - Reverse Linked List

```java
import com.zenith.structures.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // TODO: Implement your solution here
        return null;
    }

    private void printList(ListNode head) {
        System.out.print("List: ");
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Create list: 1 -> 2 -> 3 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("=== Reverse Linked List Test ===");
        System.out.print("Original: ");
        solution.printList(head);

        ListNode reversed = solution.reverseList(head);

        System.out.print("Reversed: ");
        solution.printList(reversed);
    }
}
```

---

## Example 5: Tree Problem - Level Order Traversal

```java
import com.zenith.structures.TreeNode;
import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // TODO: Implement your solution here
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();

        // Create tree:     1
        //                 / \
        //                2   3
        //               / \
        //              4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println("=== Level Order Traversal Test ===");
        System.out.println("Tree root value: " + root.val);
        System.out.println("Result: " + result);
        System.out.println("Expected: [[1], [2, 3], [4, 5]]");
    }
}
```

---

## Input Creation Patterns by Problem Type

### Arrays
```java
int[] arr = {1, 2, 3, 4, 5};
int[][] matrix = {{1, 2}, {3, 4}};
```

### Strings
```java
String s = "hello";
```

### LinkedList
```java
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
```

### Trees
```java
TreeNode root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
```

### Graphs
```java
GraphNode node1 = new GraphNode(1);
GraphNode node2 = new GraphNode(2);
node1.neighbors.add(node2);
```

### Collections
```java
List<Integer> list = Arrays.asList(1, 2, 3);
Map<String, Integer> map = new HashMap<>();
map.put("key", 1);
```

---

## PSVM Method Checklist

- [ ] Import necessary classes (Arrays, List, TreeNode, GraphNode, etc.)
- [ ] Keep algorithm method **completely empty** with just a return statement
- [ ] Create meaningful sample input data
- [ ] Call the algorithm method with the sample input
- [ ] Print clear input/output information
- [ ] Handle null returns gracefully
- [ ] Use descriptive output messages
- [ ] Include expected vs actual results when applicable

---

## Best Practices

1. **Always Keep Method Empty** - Only add the TODO comment
2. **Use Multiple Test Cases** - Show different scenarios in main
3. **Clear Output Format** - Make it obvious what's input and what's output
4. **Handle Null Cases** - Check if result is null before accessing properties
5. **Provide Expected Results** - Comment or print what the output should be
6. **Test Edge Cases** - Include at least one edge case (empty, single element, etc.)
7. **Use Helper Methods** - For complex printing (like printing lists/trees)

---

## Output Format Example

```
=== Algorithm Test ===
Input: [1, 2, 3, 4, 5]
Target: 7
Output: [0, 3]
Expected: [0, 3]
✓ Test passed!
```

---

## Notes
- The main method is where you test your implementation
- Keep the algorithm method empty - implement it yourself
- Use `System.out.println()` for clear, readable output
- Always import the data structures you use
- For complex data structures, create helper print methods
- Test with at least 2-3 different inputs
