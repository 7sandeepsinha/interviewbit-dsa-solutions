package org.sandeep.recursion;

import org.sandeep.PairData;

import java.util.ArrayList;

public class TowerOfHanoi {

    public void moveDisks(int n, ArrayList<Integer> source, ArrayList<Integer> dest, ArrayList<Integer> buffer){
        if(n <=0 )
            return;

        moveDisks(n-1, source, buffer, dest);
        moveTop(source, dest);
        moveDisks(n-1,buffer,dest,source);
    }

    public void moveTop(ArrayList<Integer> fromTower, ArrayList<Integer> toTower){
        if(toTower.size() > 1) {
            toTower.remove(toTower.size()-1);
        }
        toTower.add(fromTower.get(fromTower.size() -1 ));
    }

}

class Main{
    public static void main(String[] args) {
        //make the
        int[] A = {6,4,3,2,1};
        ArrayList<Integer> source = new ArrayList<>();
        for(int i : A){
            source.add(i);
        }
        ArrayList<Integer> dest = new ArrayList<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        int n = A.length;

        TowerOfHanoi t = new TowerOfHanoi();
        t.moveDisks(n, source, dest, buffer);
        System.out.println(source);

    }
}
