public class Assignment01Q05 {

    /**
     * checks if a includes b.
     * @param a
     * @param b
     * @return false if there exists i s.t. a[i]=false and b[i]=true, otherwise true
     */
    private static boolean arrayIncludes(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i] && b[i])
                return false;
        }
        return true;
    }

    public static int findShortestPath(int[][] m, int start, int end) {
        if (start == end)
            return 0;

        // all points that have been visited
        boolean[] visitedPoints = new boolean[m.length];
        // (calculated in loop) points that can be accessed from visitedPoints
        boolean[] newPoints = new boolean[m.length];
        // newPoints that are not in visitedPoints
        boolean[] completelyNewPoints = new boolean[m.length];
        visitedPoints[start] = true;
        completelyNewPoints[start] =true;
        int steps = 0;

        while (true) {
            steps++;
            // Add all points which can be visited immediately from any of the points that
            // have been visited
            for (int i = 0; i < completelyNewPoints.length; i++) {
                if (completelyNewPoints[i]) {
                    int[] pointsToAdd = m[i];
                    for (int j = 0; j < pointsToAdd.length; j++) {
                        newPoints[j] |= pointsToAdd[j] == 1;
                    }
                }
            }

            // if no new points can be reached
            if (arrayIncludes(visitedPoints, newPoints))
                return -1;
            if (newPoints[end])
                return steps;

            for (int i = 0; i < newPoints.length; i++) {
                completelyNewPoints[i] = newPoints[i] && !visitedPoints[i];
            }
            // add newPoints to visitedPoints
            for (int i = 0; i < newPoints.length; i++) {
                visitedPoints[i] |= newPoints[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}