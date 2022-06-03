import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ACMScoring
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		ArrayList<Problem> problems = new ArrayList<Problem>();
		ArrayList<String> lines = new ArrayList<String>();
		
		//Get input
		String line = br.readLine();
		while(!line.contains("-1"))
		{
			lines.add(line);
			line = br.readLine();
		}
		
		
		//Parse input
		for(int i = 0; i < lines.size(); i++)
		{
			String[] lineParts = lines.get(i).split(" ");
			Problem p = problemsContainsName(lineParts[1], problems);
			if(p != null)
			{
				p.addAttempt((lineParts[2].contains("right")) ? true:false, Integer.parseInt(lineParts[0]));
			}
			else if(p == null)
			{
				Problem newProblem = new Problem(lineParts[1]);
				newProblem.addAttempt((lineParts[2].contains("right")) ? true:false, Integer.parseInt(lineParts[0]));
				problems.add(newProblem);
			}
		}
		
		//Total up the scores
		int score = 0;
		int solved = 0;
		
		for(int i = 0; i < problems.size(); i++)
		{
			Problem p = problems.get(i);
			//bw.write(p.getProblemName());
			if(p.getSolved())
			{
				score += p.getScore();
				solved++;
			}
		}
		
		bw.write(Integer.toString(solved) + " " + Integer.toString(score));
		//bw.write(Integer.toString(problems.size()));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static Problem problemsContainsName(String name, ArrayList<Problem> problems)
	{
		for(Problem p: problems)
		{
			if(p.getProblemName().contains(name))
			{
				return p;
			}
		}
		
		return null;
	}
}

class Problem
{
	private String _name;
	private int _score = 0;
	private boolean _succeeded = false;
	
	public Problem(String name)
	{
		_name = name;
	}
	
	public void addAttempt(boolean success, float time)
	{
		if(success)
		{
			_succeeded = true;
			_score += time;
		}
		else
		{
			_score += 20;
		}
	}
	public int getScore() {return (_succeeded) ? _score :0;}
	public boolean getSolved() {return (_succeeded) ? true:false;}
	public String getProblemName() {return _name;}
	
}