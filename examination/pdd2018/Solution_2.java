import sun.security.krb5.SCDynamicStoreConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author
 * @create 2018-08-29 19:11
 **/
public class Solution_2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        Long[] a = new Long[n];
        for(int i=0;i<n;i++){
            a[i]= sc.nextLong();
        }
        int max = 0;
        int min = 0;
        for(int i=0;i<3;i++){
            for(int j=i;j<n;j++){
                if(a[j]>a[max]){
                    max = j;
                }

            }
            swap(a,max,i);
        }
        for(int i=0;i<3;i++){
            for(int j=i;j<n-i;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            swap(a,min,n-i-1);
        }
        Long v1=1L;
        Long v2=1L;
        for(int i=0;i<3;i++){
            v1*=a[i];
        }
        if(a[a.length-2]<0&&a[0]>0){
            v2 = a[a.length-1]*a[a.length-2]*a[0];
            System.out.println(v1>v2?v1:v2);
        } else {
            System.out.println(v1);
        }
    }
    public static void swap(Long[] a,int x,int y){
        Long temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}


