import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 *
 *
 */
public class Solution {
    public int maxPoints(Point[] points) {

        if( points == null || points.length == 0 ){
            return 0;
        }
        int max = 0;
        HashMap<Double,Integer> map = new HashMap<Double, Integer>();

        for(int i = 0 ;i<points.length ;i++){
            int duplicate = 1;
            int vertical = 0;
            for(int j = i+1; j<points.length;j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        duplicate = duplicate +1;
                    }
                    else{
                        vertical = vertical +1;
                    }
                }else{
                    double slope = points[i].y == points[j].y?0.0:((points[j].y - points[i].y)*1.0/(points[j].x - points[i].x));
                    if(map.get(slope) != null){
                        map.put(slope,map.get(slope)+1);
                    }else{
                        map.put(slope,1);
                    }
                }
            }

            for(Integer val: map.values()){
                if(val+duplicate > max){
                    max = val+duplicate;
                }
            }
            max = Math.max(vertical + duplicate, max);
            /** Most IMPORTANT STEP */
            map.clear();
        }
        return max;
    }
}