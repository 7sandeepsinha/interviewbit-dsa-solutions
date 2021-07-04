package org.sandeep.Searching;

public class MaximumHeightOfStaircase {
    public int solve(int A) {
        int low = 0, high = A;
        while(low<=high)
        {
            int mid = (high - low)/2 + low;
            if((long)mid*(mid+1)/2 > A)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }
}
