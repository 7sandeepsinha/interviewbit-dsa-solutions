package interview;

import java.util.LinkedList;
import java.util.Queue;

class QData
{
    int v;
    int dist;
}

public class SnakesAndLadder{

    static int minThrow(int n, int arr[]){
        // code here
        int visited[] = new int[31];
        int move[] = new int[31];
        for(int i=0;i<31;i++)
            move[i]=-1;
        for(int i=0;i<arr.length-1;i+=2)
        {
            move[arr[i]]=arr[i+1];
        }

        Queue<QData> q = new LinkedList<>();
        QData qe = new QData();
        qe.v = 1;
        qe.dist = 0;


        visited[1] = 1;
        q.add(qe);


        while (!q.isEmpty())
        {
            qe = q.remove();
            int v = qe.v;
            visited[v]=1;

            if (v == 30)
                break;


            for (int j = v + 1; j <= (v + 6) && j < 31; ++j)
            {

                if (visited[j] == 0)
                {
                    QData a = new QData();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;


                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
        return qe.dist;
    }
}