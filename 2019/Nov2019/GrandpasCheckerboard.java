import java.io.*;
import java.util.*;

public class GrandpasCheckerboard
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] board = new char[n][n];
		
		for(int i = 0; i < n; i++)
		{
			char[] line = br.readLine().toCharArray();
			
			for(int j = 0; j < line.length; j++)
			{
				board[i][j] = line[j];
			}
		}
		
		//Every row must have same num of white & black squares
		//Every column also has same num of white & black squares
		//No row or column has three consecutive squares of the same colour
		
		boolean failed = false;
		for(int i = 0; i < n && !failed; i++)
		{
			int wCountRow = 0, bCountRow = 0, wCountCol = 0, bCountCol = 0;
			int wContinuousRow = 0, bContinuousRow = 0, wContinuousCol = 0, bContinuousCol = 0;
			
			for(int j = 0; j < n && !failed; j++)
			{
				if(board[i][j] == 'W')
				{
					wCountRow++;
					bContinuousRow = 0;
					wContinuousRow++;
				}
				else
				{
					bCountRow++;
					bContinuousRow++;
					wContinuousRow = 0;
				}
			}
			
			for(int j = 0; j < n && !failed; j++)
			{
				if(board[j][i] == 'W')
				{
					wCountCol++;
					bContinuousCol = 0;
					wContinuousCol++;
				}
				else
				{
					bCountCol++;
					bContinuousCol++;
					wContinuousCol = 0;
				}
				
				if(wContinuousCol > 2 || wContinuousRow > 2 || bContinuousCol > 2 || bContinuousRow > 2)
				{
					bw.write("0\n");
					failed = true;
				}
			}
			
			
			if(wCountRow != bCountRow || wCountCol != bCountCol && !failed)
			{
				bw.write("0\n");
				failed = true;
			}
		}
		
		if(!failed)
		{
			bw.write("1\n");
		}
		
		br.close();
		bw.close();
	}
}
