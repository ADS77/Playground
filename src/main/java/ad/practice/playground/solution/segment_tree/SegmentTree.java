package ad.practice.playground.solution.segment_tree;

public class SegmentTree {
    private int n;
    private int[] minTree, maxTree, sumTree;

    public SegmentTree(int[] arr){
        this.n = arr.length;
        this.minTree = new int[4*n];
        this.maxTree = new int[4*n];
        this.sumTree = new int[4*n];
        build(0,0,n-1,arr);
    }
    private void build(int node,int start, int end,int[]arr){
        if(start == end){
            minTree[node] = maxTree[node] = sumTree[node] = arr[start];
        }else {
            int mid = (start+end)/2;
            build(2*node+1, start, mid, arr);
            build(2*node+2, mid+1, end, arr);
            minTree[node] = Math.min(minTree[2*node+1],minTree[2*node+2]);
            maxTree[node] = Math.max(maxTree[2*node+1], maxTree[2*node+2]);
            sumTree[node] = sumTree[2*node+1] + sumTree[2*node+2];
        }
    }

    public int querySum(int l, int r){
        return querySum(0, l,r,0,n-1);
    }
    private int querySum(int node, int l, int r, int start, int end){
        // No overlap
        if(l > end || r < start) return 0;
        //complete overlap(does range of node lies between the query range)
        if(start >= l && end <= r) return sumTree[node];
        int mid = (start+end)/2;
        return querySum(2*node+1, l,r,start, mid) + querySum(2*node+2,l,r,mid+1, end);
    }

    public int queryMin(int l, int r){
        return queryMin(0, l, r, 0, n-1);
    }
    private int queryMin(int node, int l, int r, int start, int end){
        if(l > end || r < start) return Integer.MAX_VALUE;
        if(start>= l && end <= r)return minTree[node];
        int mid = (start+end)/2;
        return Math.min(queryMin(2*node+1, l,r,start, mid), queryMin(2*node+2,l,r,mid+1, end));
    }

    public int queryMax(int l, int r){
        return queryMax(0, l, r, 0, n-1);
    }
    private int queryMax(int node, int l, int r, int start, int end){
        if(l > end || r < start) return Integer.MIN_VALUE;
        if(start >= l && end <= r) return  maxTree[node];
        int mid = (start+end)/2;
        return Math.max(queryMax(2*node+1, l, r, start, mid), queryMax(2*node+2,l,r,mid+1, end));
    }



    public static void main(String []a){
        int [] A = {1,3,2,2,1,3,5,6,1};
        SegmentTree segmentTree = new SegmentTree(A);
        System.out.println("sum = "+segmentTree.querySum(3,6));
        System.out.println("min = " + segmentTree.queryMin(3,6));
        System.out.println("max = "+segmentTree.queryMax(3,6));
    }


}
