package com.test;
/*We create nodes bottom-up, and assign them to its parents. 
 * The bottom-up approach enables us to access the list in its order while creating nodes.
 * The list’s length could be found in O(N) time by traversing the entire list’s once. 
 * The recursive calls traverse the list and create tree’s nodes by the list’s order, which also takes O(N) time. 
 * Therefore, the overall run time complexity is still O(N).
 * */
public class SortedListToBST {

	static ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
