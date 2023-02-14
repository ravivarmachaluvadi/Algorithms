package com.example.techiedelight.Algorithms.tuf;

import java.util.*;
class PrintAllSubsequences{// Java code to print all possible
// subsequences for given array using
// recursion

		// Recursive function to print all
// possible subsequences for given array
		public static void printSubsequences(String[] arr, int index,
											 ArrayList<String> path)
		{

			// Print the subsequence when reach
			// the leaf of recursion tree
			if (index == arr.length)
			{

				// Condition to avoid printing
				// empty subsequence
				if (path.size() > 0)
					System.out.println(path);
			}

			else
			{

				// Subsequence without including
				// the element at current index
				printSubsequences(arr, index + 1, path);

				path.add(arr[index]);

				// Subsequence including the element
				// at current index
				printSubsequences(arr, index + 1, path);

				// Backtrack to remove the recently
				// inserted element
				path.remove(path.size() - 1);
			}
			return;
		}

		// Driver code
		public static void main(String[] args)
		{
			String[] arr = { "Atharva", "Gayatri","Ishraf", "Ravi","Sathiya","Thiayaga" };

			// Auxiliary space to store each path
			ArrayList<String> path = new ArrayList<>();

			printSubsequences(arr, 0, path);
		}
	}

// This code is contributed by Mukul Sharma
