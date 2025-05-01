/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emreyazici
 */
public class BinarySearchTree {
    BSTNode root;
    
    public void insert(int score, String username, String level) {
        BSTNode newNode = new BSTNode(score, username, level);

        if (root == null) {
            root = newNode;
            return;
        }

        BSTNode temp = root;
        while (temp != null) {
            if (score > temp.score) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            } else if (score < temp.score) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            } else {
                return;
            }
        }
    }
    
    public String inorder() {
        String result = inorder(root);
        if (result.endsWith(", ")) {
            result = result.substring(0, result.length() - 2); // sondaki ", " kaldır
        }
        return result;
    }

    private String inorder(BSTNode node) {
        if (node == null) {
            return "";
        }
        String left = inorder(node.left);
        String current = node.score + " (" + node.level + "), ";
        String right = inorder(node.right);
        return left + current + right;
    }
    
//    private void inorder(BSTNode node){
//        if (node!=null) {
//            inorder(node.left);
//            System.out.println(node.score+" ");
//            inorder(node.right);
//        }
//    }
//    
//    void inorder(){
//        System.out.println("Inorder: ");
//        inorder(root);
//        System.out.println();
//    }
}
