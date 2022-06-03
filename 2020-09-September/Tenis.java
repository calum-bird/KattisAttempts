import java.io.*;

public class Tenis
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] names = br.readLine().split(" ");

        int alien = 0;
        if(names[0].equals("federer")) alien = 1;
        if(names[1].equals("federer")) alien = 2;

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0)
        {
            String[] matches = br.readLine().split(" ");

            // 1 for a, 2 for b
            int[] setsWon = new int[matches.length];

            boolean matchCompleted = false;

            int index = 0;
            for(String match: matches)
            {
                int a = match.charAt(0) - 48;
                int b = match.charAt(2) - 48;

                if(a > b)
                {
                    if(a < 6)
                    {
                        /*
                        sb.append("ne: ");
                        sb.append("The winner did not win 6 games in this set: ");
                        sb.append(a);
                        sb.append(':');
                        sb.append(b);
                        sb.append('\n');
                        */
                        sb.append("ne\n");
                        matchCompleted = true;
                        break;
                    }
                    else 
                    {
                        if(a >= 6 && a - b >= 2)
                        {
                            setsWon[index] = 1;
                        }
                        else if(a == 7 && b == 6)
                        {
                            setsWon[index] = 1;
                        }
                        else
                        {
                            /*
                            sb.append("ne: ");
                            sb.append("The winner did not win 2 or more additional games against their opponent: ");
                            sb.append(a);
                            sb.append(':');
                            sb.append(b);
                            sb.append('\n');
                            */
                            sb.append("ne\n");
                            matchCompleted = true;
                            break;
                        }
                    }
                }
                else if(b > a)
                {
                    if(b < 6)
                    {
                        /*
                        sb.append("ne: ");
                        sb.append("The winner did not win 6 games in this set: ");
                        sb.append(a);
                        sb.append(':');
                        sb.append(b);
                        sb.append("\n");
                        */
                        sb.append("ne\n");
                        matchCompleted = true;
                        break;
                    }
                    else 
                    {
                        if(b >= 6 && b - a >= 2)
                        {
                            setsWon[index] = 2;
                        }
                        else if(b == 7 && a == 6)
                        {
                            setsWon[index] = 2;
                        }
                        else
                        {
                            /*
                            sb.append("ne: ");
                            sb.append("The winner did not win 2 or more additional games against their opponent: ");
                            sb.append(a);
                            sb.append(':');
                            sb.append(b);
                            sb.append('\n');
                            */
                            sb.append("ne\n");
                            matchCompleted = true;
                            break;
                        }
                        setsWon[index] = 2;
                    }
                }
                else if(a==b)
                {
                    /*
                    sb.append("ne: ");
                    sb.append("Nobody won: ");
                    sb.append(a);
                    sb.append(':');
                    sb.append(b);
                    sb.append("\n");
                    */
                    sb.append("ne\n");
                    matchCompleted = true;
                    break;
                }

                index++;
            }

            int aCounter = 0;
            int bCounter = 0;
            if(!matchCompleted)
            {
                for(int i: setsWon)
                {
                    if(i == 1)
                    {
                        if(alien == 2)
                        {
                            /*
                            sb.append("ne: ");
                            sb.append("An alien lost: ");
                            sb.append(":\n");
                            */
                            sb.append("ne\n");
                            matchCompleted = true;
                            break;
                        }

                        aCounter++;
                    }
                    else if(i == 2)
                    {
                        if(alien == 1)
                        {
                            /*
                            sb.append("ne: ");
                            sb.append("An alien lost: ");
                            sb.append(":\n");
                            */
                            sb.append("ne\n");
                            matchCompleted = true;
                            break;
                        }

                        bCounter++;
                    }
                }
            }

            if(!matchCompleted && aCounter != 2 && bCounter != 2)
            {
                /*
                sb.append("ne: A: ");
                sb.append(aCounter);
                sb.append(" B: ");
                sb.append(bCounter);
                sb.append(" so ");
                sb.append("neither won the game\n");
                */
                sb.append("ne\n");
            }
            else if(!matchCompleted)
            {
                sb.append("da\n");
            }
        }

        //System.out.println("-------");
        System.out.print(sb);

        br.close();
    }
}