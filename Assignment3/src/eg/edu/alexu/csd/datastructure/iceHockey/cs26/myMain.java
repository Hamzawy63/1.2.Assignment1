package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import org.w3c.dom.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class myMain {
     static class  player implements IPlayersFinder
    {
        public  java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
        {
            char k = Integer.toString(team).charAt(0);
            Point[] Picture = new Point[100];
            char[][] photoArr = to2dArr(photo);
            ArrayList<ArrayList<Point>> allIndexes = new ArrayList<>();
            ArrayList<Point> index = new ArrayList<>();
            searchForPlayers(photoArr,k,threshold,index,allIndexes);
            return getPoints(allIndexes);
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
        public void  checkMove(int i,int j ,char [][]arr,char  k,ArrayList<Point> index  ) /// value is k
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

        public void searchForPlayers(char [][]arr,char k,int threshold,ArrayList<Point> index, ArrayList<ArrayList<Point>> allIndexes)
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
                  //    visited[i][j] =1;
                      arr[i][j] = '*';
                      index.add(new Point(i,j));
                      checkMove(i,j+1,arr,k,index);
                      checkMove(i,j-1,arr,k,index);
                      checkMove(i+1,j,arr,k,index);
                      checkMove(i-1,j,arr,k,index);
                      /// search for the area
                      int uselessbutuseful = getArea(i,j,arr,visited) ;
                      if(4*uselessbutuseful<threshold)
                      {
                          index.clear();
                          continue;
                      }
                      else
                      {
                          ///record the index and calc the point
                          /**
                          for(Point x : index)
                          {
                              allIndexes.get(cnt).add(x);
                          }
                           **/
                          allIndexes.add(cnt,new ArrayList<Point>(1));
                          allIndexes.get(cnt++).addAll(index);
                          index.clear();
                          /// and store it in a game

                      }
                  }
                }
            }

        }

        public int getArea(int i,int j,char [][]arr,int [][]visited)
        {
            if(isValid(i,j,arr)==false ||  arr[i][j]!= '*' || visited[i][j] == 1)
                return 0;
            visited[i][j] = 1;
            int x = getArea(i+1,j,arr,visited);
            int y = getArea(i-1,j,arr,visited);
            int z = getArea(i,j+1,arr,visited);
            int m = getArea(i,j-1,arr,visited);

            return  (1+x+y+z+m);

        }
        public Point[] getPoints(ArrayList <ArrayList<Point>> allIndexes)
        {
            Point[] teamPoints = new Point[allIndexes.size()];
            int ctr = 0;
            for(int i =0 ;i<allIndexes.size();i++ )
            {
                Point teamIndex = new Point(allIndexes.get(i).get(0));  /// first point
                int minX = teamIndex.x,minY =teamIndex.y,maxX =teamIndex.x,maxY =teamIndex.y;

               for(Point j : allIndexes.get(i))
               {
                   if(j.x > maxX)
                       maxX = j.x;
                   else if(j.x<minX)
                       maxY = j.y;


                   if(j.y > maxY)
                       maxY = j.y;
                   else if (j.y<minY)
                       minY = j.y;
               }
               teamPoints[ctr++] = new Point(minY+maxY+1,minX+maxX+1);

            }
            return (teamPoints);
        }
        public Point[] sort(Point[] teamPositions )
        {
            Point[] teamPoints = new Point[teamPositions.length];
            int minX = teamPositions[0].x;
            int index =0;
            int cnt = 0;
            for(int i =0 ;i<teamPositions.length;i++ )
            {
                if(teamPositions[i].x < minX )
                {
                    minX = teamPositions[i].x;
                    index = i;
                }
                teamPoints[cnt++] = teamPositions[index];

            }

            return  teamPoints;
        }



    }
    public static  void main (String[] args )
    {
        player ref = new player();
        String[] a ={ "44444H44S4", "K444K4L444","4LJ44T44XH","444O4VIF44", "44C4D4U444","4V4Y4KB4M4","G4W4HP4O4W", "4444ZDQ4S4","4BR4Y4A444","4G4V4T4444"};
        Point[] myFuckingPoints = new Point[15];
        myFuckingPoints = ref.findPlayers(a,4,16);
        for(int i =0 ;i<myFuckingPoints.length;i++)
        {
            System.out.println(myFuckingPoints[i]);
        }





    }

}
