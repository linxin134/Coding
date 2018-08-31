import java.util.*;

/**
 * @author
 * @create 2018-08-30 15:18
 **/
public class Solution_3 {
    private  HashSet<String> set = new HashSet<>();
    private List<String> list = new ArrayList<>();


    public HashSet<String> getSet() {
        return set;
    }

    public void setSet(HashSet<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String[] s = s1.split(" ");
//        int n = s[0].length()+s[1].length();
//        int[][] res = new int[s[1].length()][n];
//        int temp=0;
//        for(int i = s[1].length()-1;i<=0;i--){
//            for(int j= s[0].length()-1;i<=0;i--){
//                res[i][n-i]=(s[1].charAt(i)*s[0].charAt(j)+temp)%10;
//                temp = (s[1].charAt(i)*s[0].charAt(j)+temp)/10;
//            }
//        }
//        temp=0;
//        for(int i=n-1;i>=0;i--){
//            int sum=0;
//            for (int j=0;j<s[1].length();j++){
//                sum+=res[i][j];
//            }
//            if((sum+temp)!=0){
//                res[i][0]=(sum+temp)%10;
//                temp = (sum+temp)/10;
//            }
//        }

        Scanner sc = new Scanner(System.in);
        int n,m;
        n= sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();
        Solution_3 s=new Solution_3();
        HashSet<String> set = s.getSet();
        char[][] c = new char[n][m];
        for(int i =0;i<n;i++){
            c[i]=sc.nextLine().toCharArray();
            set.add(String.copyValueOf(c[i]));
        }
       char[] cc  = new char[m];
        s.getWord(c,cc,0,m,n,true,-1);
        List<String> list=s.getList();
        if(list.size()==0){
            System.out.println("-");
        }else {
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println(list.get(0));
        }
    }

    public void getWord(char[][] arr,char[] c,int j,int m, int n,boolean same,int index){
       if(j<m){
           for(int k=0;k<n;k++) {
               c[j]=arr[k][j];
               if(same) {
                   if(index == -1||index == k)
                       getWord(arr, c, j + 1, m, n, true, k);
                   else
                       getWord(arr, c, j + 1, m, n, false, k);
               }
               else {
                   getWord(arr, c, j + 1, m, n, false, k);
               }
           }
       }else {
           if(!same) {
               if (set.contains(String.copyValueOf(c))) {
                   list.add(String.copyValueOf(c));
               }
           }
       }

    }
}
