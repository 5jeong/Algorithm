package algorithmStudy.Recursive_Tree_DFS_BFS기초;
//이진트리 순회(전위순회, 중위순회, 후위순회)
class Node{
    int data;
    Node lt,rt;
    public Node(int val){
        data = val;
        lt = rt =null;
    }
}
public class 이진트리순회_DFS {
    Node root;
    public static void DFS(Node root){
        if(root == null) return;
        else{
            // 전위 순회
            System.out.print(root.data+" ");
            DFS(root.lt);
            // 중위 순회 System.out.print(root.data+" ");
            DFS(root.rt);
            // 후위 순회 System.out.print(root.data+" ");
        }
    }
    public static void main(String[] args){
        이진트리순회_DFS tree = new 이진트리순회_DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        DFS(tree.root);
    }
}
