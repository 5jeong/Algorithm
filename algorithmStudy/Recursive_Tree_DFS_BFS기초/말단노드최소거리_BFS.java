package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.util.LinkedList;
import java.util.Queue;

public class 말단노드최소거리_BFS {
    static class Node{
        int data;
        Node lt,rt;
        public Node(int val){
            data = val;
            lt = rt =null;
        }
    }
    Node root;
    public static int BFS( Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L=0;
        while(!q.isEmpty()){
            int len =q.size();
            for(int i=0;i<len;i++){
                Node cur = q.poll();
                if(cur.lt == null && cur.rt==null){
                    return L;
                }
                if(cur.lt != null){
                    q.offer(cur.lt);
                }
                if(cur.rt != null){
                    q.offer(cur.rt);
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String args[]) {
        말단노드최소거리_BFS tree = new 말단노드최소거리_BFS();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(BFS(tree.root));
    }
}
