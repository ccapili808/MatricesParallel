import java.util.Arrays;

public class CSC {
        int[] values;
        int[] colptrs;
        int[] rows;

        public CSC(int[][] mat)
        {
            convertToCSC(mat);
            printCSC();
        }

        public void convertToCSC(int[][] mat)
        {
            int n = mat.length;
            int m = mat[0].length;
            int nnz = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                    if(mat[i][j] != 0)
                        nnz++;
            }
            values = new int[nnz];
            colptrs = new int[m+1];
            rows = new int[nnz];
            int k = 0;
            for(int j = 0; j < m; j++)
            {
                colptrs[j] = k;
                for(int i = 0; i < n; i++)
                {
                    if(mat[i][j] != 0)
                    {
                        values[k] = mat[i][j];
                        rows[k] = i;
                        k++;
                    }
                }
            }
            colptrs[m] = k;
            this.colptrs = colptrs;
            this.values = values;
            this.rows = rows;
        }


        public void printCSC()
        {
            //print the matrix use this.
            System.out.println("Values: " + Arrays.toString(this.values));
            System.out.println("Rows: " + Arrays.toString(this.rows));
            System.out.println("Colptrs: " + Arrays.toString(this.colptrs));
        }

        public int[] getCSC_values()
        {
            return this.values;
        }

        public int[] getCSC_rows()
        {
            return this.rows;
        }

        public int[] getCSC_colptrs()
        {
            return this.colptrs;
        }

        public int getCSC_nnz()
        {
            return this.values.length;
        }
}
