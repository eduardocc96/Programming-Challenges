/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        Node tails[]=transformNodes(root);
        tails[0].left=tails[1];
        tails[tails.length-1].right=tails[0];
        return tails[0];
        
    }
    
    
    public Node[] transformNodes(Node node){
        if(node==null) return null;
        Node left[]=transformNodes(node.left);//i want the biggest value to my left
        Node right[]=transformNodes(node.right);//i want the smallest value to my right
        //position 0 will have the smallest value, position 1 will have the biggest value
        if(left!=null){//i will link to the biggest value of my left
            node.left=left[1];
            left[1].right=node;
        }
        if(right!=null){//i will link to the smallest value of my right
            node.right=right[0];
            right[0].left=node;
        }
        Node result[]=new Node[2];
        //populate the space for the smallest value of subtree, the smallest of my left or me
        if(left==null){
            result[0]=node;
        }else{
            result[0]=left[0];
        }
        if(right==null){
            result[1]=node;
        }else{
            result[1]=right[1];
        }
        return result;
    }
}