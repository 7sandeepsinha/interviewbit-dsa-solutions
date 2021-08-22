package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Interview {
    public void merge(int[] arr, int l, int m , int r){ // 0 , 2, 4
        int n1 = m-l + 1 ; // 3
        int n2 = r -m; // 2

        int arrL[] = new int[n1];
        int arrR[] = new int[n2];

        for(int i=0;i<n1;i++){
            arrL[i] = arr[l+i];
        }

        for(int j=0;j<n2;j++){
            arrR[j] = arr[m+1+j];
        }

        int i=0,j=0;
        int k =l;
        while(i<(n1) && j < (n2)){
            if(arrL[i] <= arrR[j]){
                arr[k] = arrL[i];
                i++;
            }else{
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }

        while (i<(n1)){
            arr[k] = arrL[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = arrR[j];
            j++;
            k++;
        }

    }

    public int[] mergeSort(int[] arr, int l , int r){
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
        return arr;
    }

    public static boolean compareStrings(String str1, String str2){
        // 2 hashmap -> character , freq
        // sort the string -> compare
        // count array -> chracter ascii array -> 256 max O(1)

        if(str1.length() != str2.length())
                return false;

        int strArr1[] = new int[256];
        int strArr2[] = new int[256];

        Arrays.fill(strArr1,0);
        Arrays.fill(strArr2,0);

        for(int i=0; i<str1.length() && i< str2.length(); i++){
            strArr1[str1.charAt(i)]++;
            strArr2[str2.charAt(i)]++;
        }

        for(int i=0;i<256;i++){
            if(strArr1[i] != strArr2[i])
                return false;
        }

        return true;

    }



    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        int sum = 0;
        for(int i : arr){
            sum = sum + i;
        }

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int sum2 = integers.stream().reduce(0, (a,b) -> a + b);
        Interview i = new Interview();
        i.mergeSort(arr,0,arr.length-1);
        for(int q : arr){
            System.out.println(q);
        }

        // abcbbdea ,  eabdcabb
        // a-2,b-3,c-1,d-1,e-1 ///   e-1,a-2,b-3,c-1,d-1

        System.out.println(compareStrings("abcedaad", "eabdc"));



        /*
                    random _  _  _  _  _

                    B C D E
                      h   t

                   db.users.find( { id : "username" } , { address : 1 } )


                   select Employee.employeeId,
                   Employer.Employer.Name,
                   From Employee
                   Inner Join Employer On
                   Employer.employeeId = Employee.employeeId;

                   select name, max(salary) from employee
                   where salary in ( select salary from employee minus select max(salary)
                   from employee;

         */
    }
}
