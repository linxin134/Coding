import java.util.*;

/**
 * @author
 * @create 2018-08-10 17:23
 **/
public class Solution2017_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(sc.nextInt(),0);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;i++){
                    int color = i^j;
                    if(map.containsKey(color)){
                        map.put(color,1);
                }
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
