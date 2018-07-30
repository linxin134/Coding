import java.util.*;

/**
 链接：https://www.nowcoder.com/questionTerminal/8da0ea4b4853464795f5c32634a1b06f
 来源：牛客网
 【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 输入描述:
 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 输出描述:
 一个非负整数，表示操作之后，连续最长的相同字母数量。
 示例1
 输入
 abcbaa 2
 输出
 2
 说明
 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 **/
public class SolutionThree {
    public static int dp(int l,int r,List<Integer> list){
        if(l==r){
            return 0;
        }
        if(l+1 == r){
            return list.get(r)-list.get(l)-1;
        }
        return dp(l+1,r-1,list)+list.get(r)-list.get(l)-(r-l);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] num = new int[26];
        for(int i = 0;i<str.length();i++){
            int k = str.charAt(i)-'a';
            if(map.containsKey(k)){
                map.get(k).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(k,list);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            List<Integer> list = entry.getValue();
            int maxTmp = 1;
            if(list.size()!=1){
                for(int i=0;i<list.size();i++){
                    for(int j=i+1;j<list.size();j++){
                        if(dp(i,j,list)<=m){
                            if(j-i+1>maxTmp){
                                maxTmp = j-i+1;
                            }
                        }
                    }
                }
            }
            num[entry.getKey()] = maxTmp;
        }
        Arrays.sort(num);
        System.out.println(num[num.length-1]);
    }
}
