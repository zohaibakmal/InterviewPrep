import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

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


	/*
	* Time O(n)
	* Space O(n)
	*
	* */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List <List<Integer>> result = new ArrayList<List<Integer>>();


		LinkedList <TreeNode> level = new LinkedList<TreeNode>();
		if (root!=null){
			level.add(root);
		}

		while (!level.isEmpty()){
			LinkedList<TreeNode> newLevel = new LinkedList<TreeNode>();
			List<Integer> currentLevel = new ArrayList<Integer>();
			while (!level.isEmpty()){
				TreeNode current = level.remove();

				currentLevel.add(current.val);
				if (current.left!=null){
					newLevel.add(current.left);
				}
				if(current.right!=null){
					newLevel.add(current.right);
				}

			}
			level = newLevel;
			result.add(currentLevel);
		}
		return result;
	}


	/*
	 * Time O(n)
	 * Space O(h)
	 * We can implement a simple modification of pre-order traversal where we pass level+1 to the next recursive call.
	 *
	 * */
	public List<List<Integer>> levelOrderRecursive(TreeNode root) {
		List <List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root, 0);
		return  result;

	}

	public void helper (List<List<Integer>> result, TreeNode root, int height){
		if(root==null){
			return;
		}
		List <Integer> currentLevel = null;

		//Level not contained in the list
		if(result.size() == height){
			/*
			* Levels are always traversed in order. So if this is the first time we've visited level i,
			* we must have seen levels 0 through i-1. We can therefore safely add the level at the end.
			* */
			currentLevel = new ArrayList<Integer>();
			result.add(currentLevel);
		}else{
			// we have already visited this level. So get the level from the list.
			currentLevel = result.get(height);
		}
		// add value of current node and recurse.
		currentLevel.add(root.val);
		helper (result,root.left, height+1);
		helper (result,root.right, height+1);
	}




}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
