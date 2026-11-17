# LeetCode Patterns (Java)

Solutions to **81 LeetCode problems**, organised by the **pattern** that cracks them rather than by problem number. The aim is to learn a pattern once and recognise it under any problem statement.

Each solution is a self-contained class with a `main()` that runs the official examples and prints the actual vs. expected output (template: [PSVM_GRAPH_TESTING_TEMPLATE.md](PSVM_GRAPH_TESTING_TEMPLATE.md)).

## Run a solution

```bash
./mvnw -q compile
java -cp target/classes com.zenith.patterns.dynamicProgramming.bitmasking.ShortestPathAllNodes
```

Requires Java 21.

## Layout

```
src/main/java/com/zenith/
├── patterns/     one package per pattern (DP is split into sub-patterns)
├── structures/   shared ListNode, TreeNode, GraphNode, Heaps
└── basics/       building blocks (DFS on graphs)
```

## Problem index

### Backtracking

| # | Problem | Solution |
|---|---|---|
| 51 | N-Queens | [NQueens.java](src/main/java/com/zenith/patterns/backtracking/NQueens.java) |
| 46 | Permutations | [Permutations.java](src/main/java/com/zenith/patterns/backtracking/Permutations.java) |
| 78 | Subsets | [Subsets.java](src/main/java/com/zenith/patterns/backtracking/Subsets.java) |

### BFS

| # | Problem | Solution |
|---|---|---|
| – | Binary Tree Level Order Traversal | [BinaryTreeLevelOrderTraversal.java](src/main/java/com/zenith/patterns/bfs/BinaryTreeLevelOrderTraversal.java) |
| – | Rotting Oranges | [RottingOranges.java](src/main/java/com/zenith/patterns/bfs/RottingOranges.java) |

### Binary Tree Traversal

| # | Problem | Solution |
|---|---|---|
| – | Binary Tree Paths | [BinaryTreePaths.java](src/main/java/com/zenith/patterns/binaryTreeTraversal/BinaryTreePaths.java) |
| – | Kth Smallest In BST | [KthSmallestInBST.java](src/main/java/com/zenith/patterns/binaryTreeTraversal/KthSmallestInBST.java) |
| – | Max Path Sum | [MaxPathSum.java](src/main/java/com/zenith/patterns/binaryTreeTraversal/MaxPathSum.java) |

### DFS

| # | Problem | Solution |
|---|---|---|
| – | Clone Graph | [CloneGraph.java](src/main/java/com/zenith/patterns/dfs/CloneGraph.java) |
| – | Course Schedule II | [CourseScheduleII.java](src/main/java/com/zenith/patterns/dfs/CourseScheduleII.java) |
| – | Path Sum2 | [PathSum2.java](src/main/java/com/zenith/patterns/dfs/PathSum2.java) |

### Dynamic Programming → Bitmasking

| # | Problem | Solution |
|---|---|---|
| 2305 | Fair Distribution of Cookies | [FairDistributionCookies.java](src/main/java/com/zenith/patterns/dynamicProgramming/bitmasking/FairDistributionCookies.java) |
| 1986 | Minimum Number of Work Sessions to Finish the Tasks | [MinWorkSessions.java](src/main/java/com/zenith/patterns/dynamicProgramming/bitmasking/MinWorkSessions.java) |
| 847 | Shortest Path Visiting All Nodes | [ShortestPathAllNodes.java](src/main/java/com/zenith/patterns/dynamicProgramming/bitmasking/ShortestPathAllNodes.java) |

### Dynamic Programming → Catalan Numbers

| # | Problem | Solution |
|---|---|---|
| 22 | Generate Parentheses | [GenerateParentheses.java](src/main/java/com/zenith/patterns/dynamicProgramming/catalanNumbers/GenerateParentheses.java) |
| 96 | Unique Binary Search Trees | [UniqueBinarySearchTrees.java](src/main/java/com/zenith/patterns/dynamicProgramming/catalanNumbers/UniqueBinarySearchTrees.java) |

### Dynamic Programming → Count Distinct Ways

| # | Problem | Solution |
|---|---|---|
| 2266 | Count Number of Texts | [CountNumberOfTexts.java](src/main/java/com/zenith/patterns/dynamicProgramming/countDistinctWays/CountNumberOfTexts.java) |
| 91 | Decode Ways | [DecodeWays.java](src/main/java/com/zenith/patterns/dynamicProgramming/countDistinctWays/DecodeWays.java) |

### Dynamic Programming → Digit DP

| # | Problem | Solution |
|---|---|---|
| 357 | Count Numbers with Unique Digits | [CountUniqueDigits.java](src/main/java/com/zenith/patterns/dynamicProgramming/digitDP/CountUniqueDigits.java) |
| 233 | Number of Digit One | [NumberDigitOne.java](src/main/java/com/zenith/patterns/dynamicProgramming/digitDP/NumberDigitOne.java) |
| 902 | Numbers At Most N Given Digit Set | [NumbersAtMostN.java](src/main/java/com/zenith/patterns/dynamicProgramming/digitDP/NumbersAtMostN.java) |

### Dynamic Programming → DP on Graphs

| # | Problem | Solution |
|---|---|---|
| 787 | Cheapest Flights Within K Stops | [CheapestFlightsKStops.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnGraphs/CheapestFlightsKStops.java) |
| 1334 | Find the City With the Smallest Number of Neighbors at a Threshold Distance | [FindCitySmallestNeighbors.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnGraphs/FindCitySmallestNeighbors.java) |

### Dynamic Programming → DP on Grids

| # | Problem | Solution |
|---|---|---|
| 329 | Longest Increasing Path in a Matrix | [LongestIncreasingPathMatrix.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnGrids/LongestIncreasingPathMatrix.java) |
| 64 | Minimum Path Sum | [MinPathSum.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnGrids/MinPathSum.java) |
| 62 | Unique Paths | [UniquePaths.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnGrids/UniquePaths.java) |

### Dynamic Programming → DP on Trees

| # | Problem | Solution |
|---|---|---|
| 968 | Binary Tree Cameras | [BinaryTreeCameras.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnTrees/BinaryTreeCameras.java) |
| 124 | Binary Tree Maximum Path Sum | [BinaryTreeMaxPathSum.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnTrees/BinaryTreeMaxPathSum.java) |
| 337 | House Robber III | [HouseRobberIII.java](src/main/java/com/zenith/patterns/dynamicProgramming/dpOnTrees/HouseRobberIII.java) |

### Dynamic Programming → Fibonacci Sequence

| # | Problem | Solution |
|---|---|---|
| 70 | Climbing Stairs (practice scaffold) | [ClimbingStairs.java](src/main/java/com/zenith/patterns/dynamicProgramming/fibonacciSequence/ClimbingStairs.java) |
| 509 | Fibonacci Number (practice scaffold) | [FibonacciNumber.java](src/main/java/com/zenith/patterns/dynamicProgramming/fibonacciSequence/FibonacciNumber.java) |
| 746 | Min Cost Climbing Stairs (practice scaffold) | [MinCostClimbingStairs.java](src/main/java/com/zenith/patterns/dynamicProgramming/fibonacciSequence/MinCostClimbingStairs.java) |

### Dynamic Programming → 0/1 Knapsack

| # | Problem | Solution |
|---|---|---|
| 1049 | Last Stone Weight II | [LastStoneWeightII.java](src/main/java/com/zenith/patterns/dynamicProgramming/knapsack01/LastStoneWeightII.java) |
| 416 | Partition Equal Subset Sum (practice scaffold) | [PartitionEqualSubsetSum.java](src/main/java/com/zenith/patterns/dynamicProgramming/knapsack01/PartitionEqualSubsetSum.java) |
| 494 | Target Sum (practice scaffold) | [TargetSum.java](src/main/java/com/zenith/patterns/dynamicProgramming/knapsack01/TargetSum.java) |

### Dynamic Programming → Longest Common Subsequence

| # | Problem | Solution |
|---|---|---|
| 583 | Delete Operation for Two Strings | [DeleteOperationForTwoStrings.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestCommonSubsequence/DeleteOperationForTwoStrings.java) |
| 1143 | Longest Common Subsequence | [LongestCommonSubsequence.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestCommonSubsequence/LongestCommonSubsequence.java) |
| 1092 | Shortest Common Supersequence | [ShortestCommonSupersequence.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestCommonSubsequence/ShortestCommonSupersequence.java) |

### Dynamic Programming → Longest Common Subsequence → Edit Distance

| # | Problem | Solution |
|---|---|---|
| 72 | Edit Distance | [EditDistance.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestCommonSubsequence/editDistance/EditDistance.java) |
| 712 | Minimum ASCII Delete Sum for Two Strings | [MinimumASCIIDeleteSum.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestCommonSubsequence/editDistance/MinimumASCIIDeleteSum.java) |

### Dynamic Programming → Longest Palindromic Subsequence

| # | Problem | Solution |
|---|---|---|
| 516 | Longest Palindromic Subsequence | [LongestPalindromicSubsequence.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestPalindromicSubsequence/LongestPalindromicSubsequence.java) |
| 1312 | Minimum Insertion Steps to Make a String Palindrome | [MinimumInsertionSteps.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestPalindromicSubsequence/MinimumInsertionSteps.java) |
| 647 | Palindromic Substrings | [PalindromicSubstrings.java](src/main/java/com/zenith/patterns/dynamicProgramming/longestPalindromicSubsequence/PalindromicSubstrings.java) |

### Dynamic Programming → Matrix Chain Multiplication

| # | Problem | Solution |
|---|---|---|
| 312 | Burst Balloons | [BurstBalloons.java](src/main/java/com/zenith/patterns/dynamicProgramming/matrixChainMultiplication/BurstBalloons.java) |
| 1039 | Minimum Score Triangulation of Polygon | [MinScoreTriangulation.java](src/main/java/com/zenith/patterns/dynamicProgramming/matrixChainMultiplication/MinScoreTriangulation.java) |

### Dynamic Programming → Probability DP

| # | Problem | Solution |
|---|---|---|
| 688 | Knight Probability in Chessboard | [KnightProbability.java](src/main/java/com/zenith/patterns/dynamicProgramming/probabilityDP/KnightProbability.java) |
| 837 | New 21 Game | [New21Game.java](src/main/java/com/zenith/patterns/dynamicProgramming/probabilityDP/New21Game.java) |
| 808 | Soup Servings | [SoupServings.java](src/main/java/com/zenith/patterns/dynamicProgramming/probabilityDP/SoupServings.java) |

### Dynamic Programming → State Machine DP

| # | Problem | Solution |
|---|---|---|
| 309 | Best Time to Buy and Sell Stock with Cooldown | [BestTimeBuySellCooldown.java](src/main/java/com/zenith/patterns/dynamicProgramming/stateMachineDP/BestTimeBuySellCooldown.java) |
| 123 | Best Time to Buy and Sell Stock III | [BestTimeBuySellStockIII.java](src/main/java/com/zenith/patterns/dynamicProgramming/stateMachineDP/BestTimeBuySellStockIII.java) |

### Dynamic Programming → String Partition

| # | Problem | Solution |
|---|---|---|
| 132 | Palindrome Partitioning II | [PalindromePartitioningII.java](src/main/java/com/zenith/patterns/dynamicProgramming/stringPartition/PalindromePartitioningII.java) |
| 139 | Word Break | [WordBreak.java](src/main/java/com/zenith/patterns/dynamicProgramming/stringPartition/WordBreak.java) |

### Dynamic Programming → Unbounded Knapsack

| # | Problem | Solution |
|---|---|---|
| 322 | Coin Change | [CoinChange.java](src/main/java/com/zenith/patterns/dynamicProgramming/unboundedKnapsack/CoinChange.java) |
| 518 | Coin Change 2 | [CoinChange2.java](src/main/java/com/zenith/patterns/dynamicProgramming/unboundedKnapsack/CoinChange2.java) |
| 279 | Perfect Squares | [PerfectSquares.java](src/main/java/com/zenith/patterns/dynamicProgramming/unboundedKnapsack/PerfectSquares.java) |

### Fast Slow Pointers

| # | Problem | Solution |
|---|---|---|
| – | Find Duplicate Number | [FindDuplicateNumber.java](src/main/java/com/zenith/patterns/fastSlowPointers/FindDuplicateNumber.java) |
| – | Happy Number | [HappyNumber.java](src/main/java/com/zenith/patterns/fastSlowPointers/HappyNumber.java) |
| – | Linked List Cycle | [LinkedListCycle.java](src/main/java/com/zenith/patterns/fastSlowPointers/LinkedListCycle.java) |

### Linked List In Place Reversal

| # | Problem | Solution |
|---|---|---|
| – | Reverse Linked List | [ReverseLinkedList.java](src/main/java/com/zenith/patterns/linkedListInPlaceReversal/ReverseLinkedList.java) |
| – | Reverse Linked List II | [ReverseLinkedListII.java](src/main/java/com/zenith/patterns/linkedListInPlaceReversal/ReverseLinkedListII.java) |
| – | Swap Node In Pairs | [SwapNodeInPairs.java](src/main/java/com/zenith/patterns/linkedListInPlaceReversal/SwapNodeInPairs.java) |

### Matrix Traversal

| # | Problem | Solution |
|---|---|---|
| 733 | Flood Fill (practice scaffold) | [FloodFill.java](src/main/java/com/zenith/patterns/matricTraversal/FloodFill.java) |
| 200 | Number of Islands (practice scaffold) | [NumIslands.java](src/main/java/com/zenith/patterns/matricTraversal/NumIslands.java) |
| 130 | Surrounded Regions (practice scaffold) | [SurroundedRegions.java](src/main/java/com/zenith/patterns/matricTraversal/SurroundedRegions.java) |

### Merge Intervals

| # | Problem | Solution |
|---|---|---|
| – | Insert Interval | [InsertInterval.java](src/main/java/com/zenith/patterns/mergeIntervals/InsertInterval.java) |
| – | Merge Interval | [MergeInterval.java](src/main/java/com/zenith/patterns/mergeIntervals/MergeInterval.java) |
| – | Non Overlapping Interval | [NonOverlappingInterval.java](src/main/java/com/zenith/patterns/mergeIntervals/NonOverlappingInterval.java) |

### Modified Binary Search

| # | Problem | Solution |
|---|---|---|
| – | Binary Search | [BinarySearch.java](src/main/java/com/zenith/patterns/modifiedBinarySearch/BinarySearch.java) |
| – | Min In Rotated Array | [MinInRotatedArray.java](src/main/java/com/zenith/patterns/modifiedBinarySearch/MinInRotatedArray.java) |
| – | Search2d Matrix II | [Search2dMatrixII.java](src/main/java/com/zenith/patterns/modifiedBinarySearch/Search2dMatrixII.java) |
| – | Search In Rotated Array | [SearchInRotatedArray.java](src/main/java/com/zenith/patterns/modifiedBinarySearch/SearchInRotatedArray.java) |

### Monotonic Stack

| # | Problem | Solution |
|---|---|---|
| – | Daily Temperatures | [DailyTemperatures.java](src/main/java/com/zenith/patterns/monotonicStack/DailyTemperatures.java) |
| – | Largest Rectangle In Histogram | [LargestRectangleInHistogram.java](src/main/java/com/zenith/patterns/monotonicStack/LargestRectangleInHistogram.java) |
| – | Next Greater Element I | [NextGreaterElementI.java](src/main/java/com/zenith/patterns/monotonicStack/NextGreaterElementI.java) |

### Sliding Window

| # | Problem | Solution |
|---|---|---|
| – | Length Of Longest Substring | [LengthOfLongestSubstring.java](src/main/java/com/zenith/patterns/slidingWindow/LengthOfLongestSubstring.java) |
| – | Max Average | [MaxAverage.java](src/main/java/com/zenith/patterns/slidingWindow/MaxAverage.java) |
| – | Minimum Window Substring | [MinimumWindowSubstring.java](src/main/java/com/zenith/patterns/slidingWindow/MinimumWindowSubstring.java) |

### Top K Elements

| # | Problem | Solution |
|---|---|---|
| – | K Pair With Smallest Sums | [KPairWithSmallestSums.java](src/main/java/com/zenith/patterns/topKElements/KPairWithSmallestSums.java) |
| – | Kth Frequent Element | [KthFrequentElement.java](src/main/java/com/zenith/patterns/topKElements/KthFrequentElement.java) |
| – | Kth Largest Element | [KthLargestElement.java](src/main/java/com/zenith/patterns/topKElements/KthLargestElement.java) |

### Two Pointers

| # | Problem | Solution |
|---|---|---|
| – | Container With Most Water | [ContainerWithMostWater.java](src/main/java/com/zenith/patterns/twoPointers/ContainerWithMostWater.java) |
