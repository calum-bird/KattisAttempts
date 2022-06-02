import java.io.*;
import java.util.*;

public class Substrings
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			String str = br.readLine();
			
			SuffixArray sa = new SuffixArray(str);
			
			bw.write(sa.unique() + "\n");
		}
		
		br.close();
		bw.close();
	}
}

class SuffixArray
{
	int ALPHABET_SZ = 256, N;
	int[] T, lcp, sa, sa2, rank, tmp, c;

    	public SuffixArray(String str)
    	{
      		this(toIntArray(str));
    	}

    	private static int[] toIntArray(String s)
    	{
     		int[] text = new int[s.length()];
      		for (int i = 0; i < s.length(); i++) text[i] = s.charAt(i);
      		return text;
    	}

    	// Designated constructor
    	public SuffixArray(int[] text)
    	{
      		T = text;
      		N = text.length;
      		sa = new int[N];
      		sa2 = new int[N];
      		rank = new int[N];
      		c = new int[Math.max(ALPHABET_SZ, N)];
      		construct();
      		kasai();
    	}
    	
    	private void construct()
    	{
      		int i, p, r;
      		for (i = 0; i < N; ++i) c[rank[i] = T[i]]++;
      		for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
      		for (i = N - 1; i >= 0; --i) sa[--c[T[i]]] = i;
      		for (p = 1; p < N; p <<= 1)
      		{
        		for (r = 0, i = N - p; i < N; ++i) sa2[r++] = i;
        		for (i = 0; i < N; ++i) if (sa[i] >= p) sa2[r++] = sa[i] - p;
        		Arrays.fill(c, 0, ALPHABET_SZ, 0);
        		for (i = 0; i < N; ++i) c[rank[i]]++;
        		for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
        		for (i = N - 1; i >= 0; --i) sa[--c[rank[sa2[i]]]] = sa2[i];
        		for (sa2[sa[0]] = r = 0, i = 1; i < N; ++i)
        		{
          			if (!(rank[sa[i - 1]] == rank[sa[i]]
              				&& sa[i - 1] + p < N
              				&& sa[i] + p < N
              				&& rank[sa[i - 1] + p] == rank[sa[i] + p])) r++;
          			sa2[sa[i]] = r;
        		}
        		tmp = rank;
        		rank = sa2;
        		sa2 = tmp;
        		if (r == N - 1) break;
        		ALPHABET_SZ = r + 1;
    		}
	}
	
	private void kasai()
	{
      		lcp = new int[N];
      		int[] inv = new int[N];
      		for (int i = 0; i < N; i++) inv[sa[i]] = i;
      		for (int i = 0, len = 0; i < N; i++)
      		{
        		if (inv[i] > 0)
        		{
          			int k = sa[inv[i] - 1];
          			while ((i + len < N) && (k + len < N) && T[i + len] == T[k + len]) len++;
          			lcp[inv[i] - 1] = len;
          			if (len > 0) len--;
        		}
      		}
    	}
    	
    	public int unique()
    	{
    		int ans = 0;
    		for (int i = 1; i < N; ++i)
    		{
			if (lcp[i] > lcp[i - 1])
			{
		        	ans += lcp[i] - lcp[i - 1];
		    	}
		}
		
		return ans;
		
		/*
    		int duplicates = 0;
      		for (int i = 0; i < N; i++)
      		{
        		duplicates += lcp[i];
      		}
		
		return ((N*(N+1))/2)-duplicates;*/
		
    	}
}
