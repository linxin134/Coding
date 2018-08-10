import java.util.Scanner;

/**
 背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。
 物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值
 为6。将哪些物品放入背包可使得背包中的总价值最大？
 **/
public class SoultionOne {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m=10,n=3;
        int[] w = {0, 3, 4, 5};
        int[] v = {0, 4, 5, 6};
        int[][] arr = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(w[i]<=j) {
                    if(arr[i-1][j]<arr[i-1][j-w[i]]+v[i]){
                        arr[i][j] = arr[i-1][j-w[i]]+v[i];
                    }else{
                        arr[i][j] = arr[i-1][j];
                    }

                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        System.out.println(arr[n][m]);
    }
}
