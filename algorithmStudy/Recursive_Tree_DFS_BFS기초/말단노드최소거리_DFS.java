package algorithmStudy.Recursive_Tree_DFS_BFS기초;

public class 말단노드최소거리_DFS {

    static class Node{
        int data;
        Node lt,rt;
        public Node(int val){
            data = val;
            lt = rt =null;
        }
    }
    Node root;
    public static int DFS(int L, Node root){
        if(root.lt == null && root.rt == null) return L;
        else{
            return Math.min(DFS(L+1,root.lt),DFS(L+1,root.rt));
        }
    }
    public static void main(String args[]) {
        말단노드최소거리_DFS tree = new 말단노드최소거리_DFS();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(DFS(0, tree.root));
    }
}
