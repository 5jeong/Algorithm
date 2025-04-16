package baekjoon.silver;

import java.util.Scanner;

// 트리순회
public class Baekjoon_1991 {
    static Node[] tree;
    static StringBuilder ans;

    static class Node {
        char left, right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new Node[26];

        for (int i = 0; i < n; i++) {
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);
            tree[a - 'A'] = new Node(b, c);
        }
        ans = new StringBuilder();
        preOrder('A');
        ans.append("\n");
        inOrder('A');
        ans.append("\n");
        postOrder('A');

        System.out.println(ans);
    }

    // 전위 순회
    static void preOrder(char root) {
        if (root == '.') {
            return;
        }

        ans.append(root);
        Node node = tree[root - 'A'];
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    static void inOrder(char root) {
        if (root == '.') {
            return;
        }

        Node node = tree[root - 'A'];
        inOrder(node.left);
        ans.append(root);
        inOrder(node.right);
    }

    // 후위 순회
    static void postOrder(char root) {
        if (root == '.') {
            return;
        }

        Node node = tree[root - 'A'];
        postOrder(node.left);
        postOrder(node.right);
        ans.append(root);
    }
}
