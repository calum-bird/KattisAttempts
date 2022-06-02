import java.util.*;
import java.io.*;

public class BlackFriday
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int playerCount = Integer.parseInt(br.readLine());
        String[] roles = br.readLine().split(" ");

        HashMap<Integer, Integer> rollOccurances = new HashMap<Integer, Integer>();
        ArrayList<Integer> original = new ArrayList<Integer>();
        for(int i = 0; i < playerCount; i++)
        {
            int role = Integer.parseInt(roles[i]);
            if(rollOccurances.containsKey(role))
            {
                int curr = rollOccurances.get(role);
                rollOccurances.replace(role, curr+1);
            }
            else
            {
                rollOccurances.put(role, 1);
            }
            
            original.add(role);
        }

        ArrayList<Integer> unique = new ArrayList<Integer>();

        for(Map.Entry<Integer, Integer> pair: rollOccurances.entrySet())
        {
            if(pair.getValue() == 1)
            {
                unique.add(pair.getKey());
            }
        }

        if(unique.size() > 0)
        {
            Collections.sort(unique);
            System.out.print(original.indexOf(unique.get(unique.size()-1)) + 1);
        }
        else
        {
            System.out.print("none");
        }
        

        

        br.close();
    }
}