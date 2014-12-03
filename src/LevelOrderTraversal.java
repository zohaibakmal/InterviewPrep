import java.util.ArrayList;
import java.util.List;


public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		//ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>();
		ArrayList <TreeNode> current = new ArrayList<TreeNode>();

		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		List <Integer> currentLevel = new ArrayList<Integer>();
		if (root==null){
			return levels;
		}
		currentLevel.add(root.val);

		current.add(root);
		while (current.size()>0){
			levels.add(currentLevel);

			ArrayList <TreeNode> parents = current;
			current = new ArrayList <TreeNode>();
			currentLevel = new ArrayList<Integer>();

			for(TreeNode node : parents){
				if (node.left!=null){
					current.add(node.left);
					currentLevel.add(node.left.val);
				}
				if (node.right!=null){
					current.add(node.right);
					currentLevel.add(node.right.val);
				}
			}

		}
		return levels;
	}


}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
