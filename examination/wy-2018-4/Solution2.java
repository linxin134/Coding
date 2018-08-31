import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author
 * @create 2018-08-09 19:31
 **/
public class Solution2 {

    static class Work{
        private int pi;
        private int di;

        public int getPi() {
            return pi;
        }

        public void setPi(int pi) {
            this.pi = pi;
        }

        public int getDi() {
            return di;
        }

        public void setDi(int di) {
            this.di = di;
        }
    }

    static  class MyCompartor implements Comparator<Work>{
        @Override
        public int compare(Work o1, Work o2) {
            if(o1.getDi()>o2.getDi()){
                return 1;
            } else if (o1.getDi()<o2.getDi()){
                return -1;
            } else {
              if(o1.getPi() > o2.getDi()){
                  return  1;
              } else {
                  return -1;
              }
            }
        }
    }

    public int getSuitPi(int ai,Work[] works){
        int left = 0;
        int right = works.length -1;
        int mid = 0;
        while(left<=right){
             mid = (left+right)/2;
            if(works[mid].getDi()>ai){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(right<0)
            return 0;
        return works[right].getPi();
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        Work[] works = new Work[n];
        int[] ai = new int[m];

        for(int i =0 ;i<n;i++){
            Work work = new Work();
            work.setDi(sc.nextInt());
            work.setPi(sc.nextInt());
            works[i] = work;
        }
        for(int i = 0;i<m;i++){
            ai[i] = sc.nextInt();
        }
        Arrays.sort(works, new MyCompartor());
        for(int i =1;i<works.length;i++){
            if(works[i].getPi()<works[i-1].getPi()){
                works[i].setPi(works[i-1].getPi());
            }
        }
        Solution2 s= new Solution2();
        for(int i = 0;i<m;i++){
            System.out.println(s.getSuitPi(ai[i],works));
        }
     }
}
