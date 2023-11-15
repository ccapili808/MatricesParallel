import java.util.Arrays;

public class CSR {
    int[] values;
    int[] cols;
    int[] rowptrs;

    public CSR(int[][] mat)
    {
        convertToCSR(mat);
        printCSR();
    }

    public void convertToCSR(int[][] mat)
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
        cols = new int[nnz];
        rowptrs = new int[n+1];
        int k = 0;
        for(int i = 0; i < n; i++)
        {
            rowptrs[i] = k;
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] != 0)
                {
                    values[k] = mat[i][j];
                    cols[k] = j;
                    k++;
                }
            }
        }
        rowptrs[n] = k;
        this.rowptrs = rowptrs;
        this.values = values;
        this.cols = cols;
    }

    public void printCSR()
    {
        //print the matrix use this.
        System.out.println("Values: " + Arrays.toString(this.values));
        System.out.println("Cols: " + Arrays.toString(this.cols));
        System.out.println("Rowptrs: " + Arrays.toString(this.rowptrs));
    }

    public int[] getCSR_values()
    {
        return this.values;
    }

    public int[] getCSR_cols()
    {
        return this.cols;
    }

    public int[] getCSR_rowptrs()
    {
        return this.rowptrs;
    }

    public int getCSR_nnz()
    {
        return this.values.length;
    }
}
