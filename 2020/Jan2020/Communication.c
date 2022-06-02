#include <stdio.h>

int main()
{
	int n;
	int lookup[256];
	
	//Read in n
	scanf("%d", &n);
	
	
	//Precompute our desired values
	for(int i = 0; i < 256; i++)
	{
		int val = i^(i<<1);
		printf("Value: %d", val);
		lookup[i] = val;
	}
}
