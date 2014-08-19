public class Ex16{

    private static void rotate(int[][] m, int n) {
        for( int layer=0; layer < n/2; ++layer ){
            int first = layer;
            int last  = n - 1 - layer;

            for( int i = first; i < last; ++i ){
                int offset = i - first;
                int top;

                //save top in a tmp var (like swapping)
                top     = m[first][i];

                //  top     <--------  left
                m[first][i] = m[last-offset][first];

                //  left    <--------  bottom
                m[last-offset][first] = m[last][last-offset];

                //  bottom  <--------  right
                m[last][last-offset] = m[i][last];

                //  right   <--------  top
                m[i][last] = top;

                System.out.println("rotating:");
                print_matrix(m);
            }
        }
    }

        /*
         *
         *                 top
         *
         *                 n/2
         *                  |
         *      |-----------|----------|
         *      |0| =======>|     2|1|0|
         *      |-          |     | | ||
         *      |1| =======>|     | | ||
         *      |-          |     | | ||
         *      |2| =======>|     | | ||
         *      |           |     | | ||
         *      |           |     | | ||
         * left |           |     | | ||     right
         *      |           |     v v v|
         * _____|___________|__________|____  (n+1)/2
         *      |^ ^ ^      |          |
         *      || | |      |          |
         *      || | |      |          |
         *      || | |      |          |
         *      || | |      |<======  2|
         *      || | |      |         -|
         *      || | |      |<======  1|
         *      || | |      |         -|
         *      |0|1|2|     |<====== |0|
         *      |-----------|----------|
         *                  |
         *
         *                bottom
         *
         *  outer "layer" when r=0, c will iteratre from 0 to (n+1)/2
         *
         *  when r=1, it will move the the "1 layer"
         *  when r=2, it will move the the "2 layer"
         *
         *  cyclic rotation of all items in layer 0, then cyclic rotation
         *  of all items in layer 1, etc.
         *  
         *  i.e. all 0's in upper left quadrant will rotate into the 0's 
         *  in the upper left quad, etc.
         *
         *  upper left -> uper right -> bottom right -> bottom left
         *
         */
    private static void rotate2(int[][] m, int n) {
        for(int r=0; r < n/2; ++r){
            for(int c=0; c < (n+1)/2; ++c){

                int tmp = m[r][c];

                // top <-- left
                m[r][c]         = m[n-1-c][r];
            //note the switching of [r][c] -> [c][r] with every transposition

                // left <-- bot
                m[n-1-c][r]     = m[n-1-r][n-1-c];

                // bot <-- right
                m[n-1-r][n-1-c] = m[c][n-1-r];

                // right <-- top
                m[c][n-1-r]     = tmp;

                System.out.println("rotating:");
                print_matrix(m);
            }
        }
    }

    /*
     * source: http://stackoverflow.com/questions/2893101/how-to-rotate-a-n-x-n-matrix-by-90-degrees
     *
     * for(int i=0; i<n/2; i++)
     *   for(int j=0; j<(n+1)/2; j++)
     *     cyclic_roll(m[i][j], m[n-1-j][i], m[n-1-i][n-1-j], m[j][n-1-i]);
     *
     * void cyclic_roll(int &a, int &b, int &c, int &d)
     * {
     *   int temp = a;
     *   a = b;
     *   b = c;
     *   c = d;
     *   d = temp;
     * }
     */
    private static void exch(int[][] m, int top, int right, int bottom, int left){

        //TODO: replicate the swap modularity using exch

        /*          
         *          top
         *      |-----------|
         *      | | | | | | |
         *      |-----------|
         *      |_|       |_|
         *      |_|       |_|
         * left |_|       |_| right
         *      |_|       |_|
         *      |-----------|
         *      | | | | | | |
         *      |-----------|
         *         bottom
         *
         */
    }


    private static void print_matrix(int[][] matrix) {
        for( int row=0; row < matrix.length; ++row ){
            for( int col=0; col < matrix[row].length; ++col ){
                System.out.printf("%02d ", matrix[row][col]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){

        //5 x 5 matrix (must be symetric?)
        int[][] my_matrix = {   {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20},
                                {21, 22, 23, 24, 25}    };

        System.out.println("Before: ");
        print_matrix(my_matrix);
        System.out.println("");

        //rotate(my_matrix, 5);
        rotate2(my_matrix, 5);

    }

}
