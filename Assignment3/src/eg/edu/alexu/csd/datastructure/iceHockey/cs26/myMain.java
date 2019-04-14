package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import org.w3c.dom.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class myMain {
     static class  player implements IPlayersFinder
    {
        public  java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
        {
            char k = Integer.toString(team).charAt(0);
            Point[] Picture = new Point[100];
            char[][] photoArr = to2dArr(photo);
            ArrayList<LinkedList<Point>> allIndexes = new ArrayList<>();
            LinkedList<Point> index = new LinkedList<>();
            searchForPlayers(photoArr,k,threshold,index,allIndexes);
            getPoints(allIndexes);



            return Picture;
        }
        public char[][] to2dArr(String[] photo)
        {
            char[][] arr = new char[photo.length][photo[0].length()];
            for(int i =0;i<photo.length;i++ )
            {
                for(int j =0 ;j<photo[0].length();j++)
                {
                    arr[i][j] = photo[i].charAt(j);
                }
            }
            return  arr;
        }
        public void  checkMove(int i,int j ,char [][]arr,char  k,LinkedList<Point> index  ) /// value is k
        {
            if( isValid(i,j,arr))
            {
                if(arr[i][j] == k)
                {
                index.add(new Point(i,j));
                arr[i][j] = '*';
                checkMove(i,j+1,arr,k,index);
                checkMove(i,j-1,arr,k,index);
                checkMove(i+1,j,arr,k,index);
                checkMove(i-1,j,arr,k,index);
                }
            }
            return;
        }
        public boolean isValid(int i , int j, char[][] arr)
        {
            if(i < arr.length && j< arr[0].length && i>=0 && j>=0 )
                return true;
            return false;
        }

        public int searchForPlayers(char [][]arr,char k,int threshold,LinkedList<Point> index, ArrayList<LinkedList<Point>> allIndexes)
        {
            int cnt = 0; ///counter on the arraylist index
            int [][]visited = new int[arr.length][arr[0].length];
            for(int i = 0 ;i<arr.length ;i++ )
            {
                for(int j = 0 ;j<arr[0].length ;j++)
                {
                  if(isValid(i,j,arr) && arr[i][j] == k )
                  {
                      /// mark groups  (Recursive case )
                      arr[i][j] = '*';
                      checkMove(i,j+1,arr,k,index);
                      checkMove(i,j-1,arr,k,index);
                      checkMove(i+1,j,arr,k,index);
                      checkMove(i-1,j,arr,k,index);
                      /// search for the area
                      if(getArea(i,j,arr,visited)<threshold)
                      {
                          continue;
                      }
                      else
                      {
                          ///record the index and calc the point
                          allIndexes.add(index);
                          /// and store it in a game
                      }
                  }
                }
            }
            return 0;
        }

        public int getArea(int i,int j,char [][]arr,int [][]visited)
        {
            if(isValid(i,j,arr)==false ||  arr[i][j]!= '*' || visited[i][j] == 1)
                return 0;
            visited[i][j] = 1;
            int x = getArea(i+1,j,arr,visited);
             x = getArea(i-1,j,arr,visited);
             x = getArea(i,j+1,arr,visited);
             x = getArea(i,j-1,arr,visited);
            return  1
                    +getArea(i+1,j,arr,visited)
                    +getArea(i-1,j,arr,visited)
                    +getArea(i,j+1,arr,visited)
                    +getArea(i,j-1,arr,visited);
        }
        public Point[] getPoints(ArrayList <LinkedList<Point>> allIndexes)
        {
            Point[] teamPoints = new Point[allIndexes.size()];
            int ctr = 0;
            for(int i =0 ;i<allIndexes.size();i++ )
            {
                Point teamIndex = new Point(allIndexes.get(0).get(0));  /// first point

               for(Point j : allIndexes.get(i))
               {
                   if(j.x < teamIndex.x)
                   {
                       teamIndex.x = j.x;
                   }
                   if (j.y>teamIndex.y)
                   {
                       teamIndex.y = j.y;
                   }
               }
               teamIndex.x+=1;
               teamIndex.y+=1;
               teamPoints[ctr++] = teamIndex;
            }
            return teamPoints;
        }



    }
    public static  void main (String[] args )
    {
        player ref = new player();
        String[] a ={ "33JUBU33", "3U3O4433","O33P44NB","PO3NSDP3","VNDSD333","OINFD33X"};
        Point[] myFuckingPoints = new Point[4];
        myFuckingPoints = ref.findPlayers(a,3,16);
        for(int i =0 ;i<myFuckingPoints.length;i++)
        {
            System.out.println(myFuckingPoints[i]);
        }





    }

}
