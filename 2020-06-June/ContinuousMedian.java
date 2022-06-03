import java.util.*;
import java.io.*;

public class ContinuousMedian
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        while(cases-- > 0)
        {
            PriorityQueue<Integer> min = new PriorityQueue<>(); //Min heap
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); //Min heap

            int sum = 0;

            int n = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            for(int i = 0; i < n; i++)
            {
                int val = Integer.parseInt(nums[i]);
                min.offer(val);
                max.offer(min.poll());

                if(min.size() < max.size())
                {
                    min.offer(max.poll());
                }

                if(min.size() > max.size())
                {
                    sum += min.peek();
                }
                else
                {
                    sum += Math.floor((min.peek()+max.peek())/2.00);
                }
            }

            System.out.println((int)sum);
        }

        br.close();
    }
}