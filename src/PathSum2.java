import java.util.ArrayList;
import java.util.List;

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]


* */

public class PathSum2 {

    /*
    * We can use backtracking to find our solutions.
    *
    * We traverse all paths in the tree. If a path doesn't sum to SUM, we back track.
    * Otherwise, if we have reached a leaf node the sum is 0, we add it to our result.
    *
    * Time: O(n). Since we are traversing the whole tree
    * Space: O(h). At anytime, our internal stack can grow up to h.
    *
    * */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        pathSum(root, result, new ArrayList(), sum);
        return result;
    }

    public void pathSum(TreeNode root,
                        List<List<Integer>> result,
                        List<Integer> path,
                        int sum) {
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && sum==root.val){
            result.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        pathSum(root.left, result, path, sum-root.val);
        pathSum(root.right, result, path, sum-root.val);
        path.remove(path.size()-1);
    }
}
