public class Assignment01Q05 {

    /**
     * checks if a includes b.
     * 
     * @param a
     * @param b
     * @return false if there exists i s.t. a[i]=0 and b[i]=1, otherwise true
     */
    private static boolean arrayIncludes(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i])
                return false;
        }
        return true;
    }

    public static int findShortestPath(int[][] m, int start, int end) {
        if (start == end)
            return 0;
        int[] visitedPoints = new int[m.length];
        int[] newPoints = new int[visitedPoints.length];
        visitedPoints[start] = 1;
        int steps = 0;

        while (true) {
            steps++;
            // Add all points which can be visited immediately from any of the points that
            // have been visited
            for (int i = 0; i < visitedPoints.length; i++) {
                if (visitedPoints[i] == 1) {
                    int[] pointsToAdd = m[i];
                    for (int j = 0; j < pointsToAdd.length; j++) {
                        newPoints[j] |= pointsToAdd[j];
                    }
                }
            }

            // if no new points can be reached
            if (arrayIncludes(visitedPoints, newPoints))
                return -1;
            if (newPoints[end] == 1)
                return steps;
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