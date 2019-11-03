package com.jack.learn.datastructure;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>
 *     二叉树实现
 * </p>
 *
 * @author liweijian.
 * @date 2019/9/22.
 */
public class BST {

    /**
     * 构建二叉树
     * @param inputList 输入列表
     * @return 二叉树
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (CollectionUtils.isEmpty(inputList)) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }

        return node;
    }

    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraveral(node.left);
        System.out.println(node.data);
        inOrderTraveral(node.right);
    }

    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.data);
    }

    /**
     * 二叉树节点的实现
     */
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}
        ));
        TreeNode node = createBinaryTree(inputList);
        preOrderTraveral(node);
    }
}
