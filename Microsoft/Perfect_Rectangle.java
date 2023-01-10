package com.microsoft;

import java.util.HashSet;
import java.util.Set;

public class Perfect_Rectangle {
	public boolean isRectangleCover(int[][] rectangles) {
		/*
		 * The Larger Rectangle will have sum equal to all other smaller rectangels.
		 * Count of all points should be even and that of all the four corner points should be one.
		 */
        Set<String> set = new HashSet<>();
        int totalAreaSum = 0;

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int a1 = Integer.MIN_VALUE;
        int b1 = Integer.MIN_VALUE;

        for(int[] rectangle : rectangles){

            int x = rectangle[0], y = rectangle[1];
            int a = rectangle[2], b = rectangle[3];

            x1 = Math.min(x1, x);
            y1 = Math.min(y1, y);
            a1 = Math.max(a1, a);
            b1 = Math.max(b1, b);

            totalAreaSum += (a - x) * (b - y);

            String[] points = new String[4];

            points[0] = x + "-" + b;
            points[1] = a + "-" + b;
            points[2] = a + "-" + y;
            points[3] = x + "-" + y;

            for(String point : points)
                if(set.contains(point))
                    set.remove(point);
                else
                    set.add(point);
        }

        if(totalAreaSum != (a1 - x1) * (b1 - y1))
            return false;
        
        if(set.size() != 4 || !(set.contains(x1 + "-" + b1) && set.contains(a1 + "-" + b1) && set.contains(a1 + "-" + y1) && set.contains(x1 + "-" + y1)))
            return false;

        return true;
    }
}
