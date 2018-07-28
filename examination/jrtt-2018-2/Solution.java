import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 链接：https://www.nowcoder.com/questionTerminal/66b68750cf63406ca1db25d4ad6febbf
 来源：牛客网
 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，
 每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊
 的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 输入描述:
 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4
 行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,
 q<=300000 k是整型
 输出描述:
 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 示例1
 输入
 5
 1 2 3 3 5
 3
 1 2 1
 2 4 5
 3 5 3
 输出
 1
 0
 2
 样例解释:
 有5个用户，喜好值为分别为1、2、3、3、5，
 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 **/
public class Solution {
    static class Node{
        private int index;
        private int val;

        public Node(int index,int val){
            this.index = index;
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
    class myComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.getVal() > o2.getVal()){
                return 1;
            } else if(o1.getVal() < o2.getVal()){
                return -1;
            } else {
                if(o1.getIndex() > o2.getIndex()){
                    return 1;
                } else if(o1.getIndex() < o2.getIndex()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }

    public void sort(Node[] arr){
        Arrays.sort(arr,new myComparator());
    }

    public int findLeft(Node[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(arr[mid].getVal() > k){
                right = mid - 1;
            }
            if(arr[mid].getVal() < k){
                left = mid + 1;
            }
            if(arr[mid].getVal() == k){
                if(mid == 0){
                    return mid;
                } else if( arr[mid-1].getVal() >= k) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public int findRight(Node[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(arr[mid].getVal() > k){
                right = mid - 1;
            }
            if(arr[mid].getVal() < k){
                left = mid + 1;
            }
            if(arr[mid].getVal() == k){
                if(mid == arr.length-1){
                    return mid;
                } else if( arr[mid+1].getVal() <= k) {
                    left = mid + 1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public int findRange(Node[] arr, int k, int start, int end){
        int left = start;
        int right = end;
        int mid = 0;
        while(left<=right){
            mid = (left + right)/2;
            if(arr[mid].getIndex() > k){
                right = mid - 1;
            }
            if(arr[mid].getIndex() < k){
                left = mid + 1;
            }
            if(arr[mid].getIndex() == k){
                return mid;
            }
        }
        return mid;
    }

    public int search(Node[] arr,int[] query){
        int left = findLeft(arr,query[2]);
        int right = findRight(arr,query[2]);
        if(left==-1 && right !=-1){
            return right+1;
        }
        if(left!=-1 && right==-1){
            return arr.length-left;
        }
        if(left==-1 && right==-1){
            return 0;
        }
        int start = findRange(arr,query[0]-1,left,right);
        int end = findRange(arr,query[1]-1,left,right);
        if(start==-1&&end==-1){
            return right - left +1;
        }
        if(start==-1){
            start = left;
        }
        if(end==-1){
            end = right;
        }
        return end -start+1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Node(i,sc.nextInt());
        }
        int q = sc.nextInt();
        int query[][] =new int[q][3];
        for(int i=0;i<q;i++){
            for(int j=0;j<3;j++){
                query[i][j] = sc.nextInt();
            }
        }
        solution.sort(arr);
        for(int i=0;i<q;i++){
            System.out.println(solution.search(arr,query[i]));
        }
    }
}





















