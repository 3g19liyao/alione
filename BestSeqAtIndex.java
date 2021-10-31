package LiKou;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSeqAtIndex {
    public static void main(String[] args) {
        System.out.println(bestSeqAtIndex(new int[]{8378,8535,8998,3766,648,6184,5506,5648,3907,6773},new int[]{9644,849,3232,3259,5229,314,5593,9600,6695,4340}));
    }
    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < len ;i++){
            list.add(height[i]);
        }
        Arrays.sort(height);
        int[] weight1 = new int[len];
        for(int i = 0;i < len;i++){
            weight1[i] = weight[list.indexOf(height[i])];
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = dp[0];
        System.out.println(height[0]+"..."+weight1[0]);
        for(int i = 1;i < len;i++){
            System.out.println(height[i]+"..."+weight1[i]);
            dp[i] = 1;
            for(int j = i;j >= 0;j--){
                if(weight1[i] > weight1[j] && height[i] != height[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
            System.out.println(dp[i]);
        }
        return max;
    }
}
