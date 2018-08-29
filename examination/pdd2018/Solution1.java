import java.util.Scanner;

/**
 * @author
 * @create 2018-08-29 17:18
 **/
public class Solution1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int offset,n,l1,l2;
        for(;;) {
            offset = sc.nextInt();
            n = sc.nextInt();
            l1 = sc.nextInt();
            l2 = sc.nextInt();
            int start1, end1, start2, end2;
            if (l1 <= offset) {
                start1 = l1;
                end1 = l1;
                if (n > l1 + l2 - offset) {
                    start2 = offset - l1;
                    end2 = l2;
                }
                else{
                    start2 = offset - l1;
                    end2 = offset - l1 + n;
                }
            } else {
                start1 = offset;
                if (n <= (l1 - offset)) {
                    end1 = offset+n;
                    start2 = 0;
                    end2 = 0;
                } else  {
                    end1 = l1;
                    start2 = 0;
                    if (n <= (l1 + l2 - offset))
                        end2 = offset-l1+n;
                    else
                        end2 = l2;
                }
            }
            System.out.println(start1+" "+ end1+" "+ start2+" "+end2);
        }
    }
}
