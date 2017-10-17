### 题目

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### 分析

递归的完美体现。

### 实现

```java
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
}
```