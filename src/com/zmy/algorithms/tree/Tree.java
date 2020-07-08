package com.zmy.algorithms.tree;

import java.util.*;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.algorithms.tree
 * @projectName : project01
 * @date : 2020-06-17 22:12
 * @description :
 **/
// 树的节点类
class Node{
    int iData;
    double fdata;
    Node leftNode;
    Node rightNode;
}

// 节点中存储的人员信息类
/*class Person{
    int iData;
    double fdata;
}*/

// 二叉树类
public class Tree {
    private Node root;

    // 查找节点
    public Node find(int key){
        Node current = root;

        while(current.iData != key){
            if (current == null) return null;
            current = (key < current.iData) ? current.leftNode : current.rightNode;
        }

        return current;

    }

    // 插入结点
    public void insert(int id,double value){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fdata = value;

        if (root == null) { // 树中没有节点，就把第一个节点作为根节点
            root = newNode;
        }else{
            Node current = root; // 从根节点开始计算新节点的插入位置
            Node parent; // 新节点的父节点
            while (true) {
                parent  = current;
                if (id < current.iData) {
                    current = current.leftNode;
                    if (current == null) {
                        parent.leftNode = newNode;
                        return;
                    }
                }else{
                    current = current.rightNode;
                    if (current == null) {
                        parent.rightNode = newNode;
                        return ;
                    }
                }
            }
        }


    }

    /*
     * 二叉树按层遍历
     */
    public LinkedList<Node> layerTransfer(Tree tree){
        Queue<Node> queue = new LinkedList<>(); // 层遍历使用的队列
        Queue<Node> resultQueue = new LinkedList<>();// 层遍历后返回的队列
        if (tree.root == null) {
            System.out.println("当前二叉树为空树，不能进行按层遍历");
            return null;
        }
        queue.add(root); // 根节点入队列
        while (!queue.isEmpty()) { // 如果层遍历队列不为空就继续循环
            Node node = queue.poll();
            resultQueue.add(node);
            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }

            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }

        return (LinkedList<Node>) resultQueue;
    }


    // 二叉树前序遍历
    public void preTranverse(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        Node pNode = root;

        while(pNode != null || !stack.isEmpty()){
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.leftNode;
            }else{
                Node node = stack.pop();
                pNode = node.rightNode;
            }
        }
    }

    // 二叉树锯齿形遍历
    public List<List<Integer>> zigzagLevelOrder(Node root){
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>(); // 锯齿形遍历后的结果

        Queue<Node> queue = new LinkedList<>(); // 创建队列，用于存放遍历的节点
        queue.offer(root); // 将根节点进队列
        boolean isDouble = true; // 二叉树按层遍历，偶数行需要反转

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(); // list集合存储二叉树节点对应的值

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                level.add(cur.iData);
                if(cur.leftNode != null){
                    queue.offer(cur.leftNode);
                }
                if (cur.rightNode != null) {
                    queue.offer(cur.rightNode);
                }

                if (isDouble){
                    result.add(level);
                }else{
                    Collections.reverse(level);
                    result.add(level);
                }

                isDouble = !isDouble;
            }

        }
        return result;
    }

    // 删除结点
    // 删除节点有三种情况
    // 1.被删除的节点没有子节点 （被删除节点为子节点或者树中只有一个根节点）
    // 2.被删除的节点有一个子节点
    // 3.被删除的节点有两个子节点
    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.iData != id) {  // 查询节点
            parent = current;
            if (id < current.iData) {
                isLeftChild = true;
                current = current.leftNode;
            }else {
                isLeftChild = false;
                current = current.rightNode;
            }

            if (current == null) {
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(9,12);
        tree.insert(3,8);
        tree.insert(2,8);
        tree.insert(20,9);
        tree.insert(15,13);
        tree.insert(7,15);
        //tree.preTranverse(tree.root);

        List<List<Integer>> list = tree.zigzagLevelOrder(tree.root);
        for (int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }

        /*LinkedList<Node> list = tree.layerTransfer(tree);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
*/

    }
}
