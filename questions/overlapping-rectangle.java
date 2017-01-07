/*
They need help writing an algorithm to find the intersection of two users' love rectangles. 

Time - O(1)
Space - O(1)

*/

  public class RangeOverlap {

    Integer startPoint;
    Integer length;

    public RangeOverlap(Integer startPoint, Integer length) {
        this.startPoint = startPoint;
        this.length = length;
    }
}

public RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

    // find the highest start point and lowest end point.
    // the highest ("rightmost" or "upmost") start point is
    // the start point of the overlap.
    // the lowest end point is the end point of the overlap.
    
    int highestStartPoint = Math.max(point1, point2);
    int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

    // return null overlap if there is no overlap
    
    if (highestStartPoint >= lowestEndPoint) {
        return new RangeOverlap(null, null);
    }

    // compute the overlap length
    int overlapLength = lowestEndPoint - highestStartPoint;

    return new RangeOverlap(highestStartPoint, overlapLength);
}

public Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

    // get the x and y overlap points and lengths
    RangeOverlap xOverlap = findRangeOverlap(rect1.leftX, rect1.width, rect2.leftX, rect2.width);
    RangeOverlap yOverlap = findRangeOverlap(rect1.bottomY, rect1.height, rect2.bottomY, rect2.height);

    // return null rectangle if there is no overlap
    if (xOverlap.length == null || yOverlap.length == null) {
        return new Rectangle();
    }

    return new Rectangle(
        xOverlap.startPoint,
        yOverlap.startPoint,
        xOverlap.length,
        yOverlap.length
    );
}

/*
Bonus
What if we had an array of rectangles and wanted to find all the rectangular overlaps between all possible pairs of two rectangles within the array? 
Note that we'd be returning an array of rectangles.

What if we had an array of rectangles and wanted to find the overlap between all of them, 
if there was one? Note that we'd be returning a single rectangle.
*/
