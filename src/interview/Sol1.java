package interview;

public class Sol1 {

    public static void main(String[] args) {
        String str = "ABCD";
        int i = 0;
        int j = str.length()-1;
        while( i < str.length() && j >= 0 ){
            if(i >= j){
                System.out.println(str);
                break;
            }
            char lC = str.charAt(i);
            char rC = str.charAt(j);

            str = str.replace(str.charAt(i), rC); // DBCD
            str = str.replace(str.charAt(j), lC); // ABCA
            i++;
            j--;
        }
    }
}
// i  j
// ABCD
// lc = A, rc = D