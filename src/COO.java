import java.util.Arrays;

public class COO {
    int[] values;
    int[] cols;
    int[] rows;

    public COO(int[][] mat)
    {
        convertToCOO(mat);
        printCOO();
    }

    public void convertToCOO(int[][] mat)
    {
        //TODO: convert mat to COO format
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
        rows = new int[nnz];
        int k = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                if(mat[i][j] != 0)
                {
                    values[k] = mat[i][j];
                    cols[k] = j;
                    rows[k] = i;
                    k++;
                }
        }
        this.values = values;
        this.cols = cols;
        this.rows = rows;
    }


    public void printCOO()
    {
        //print the matrix use this.
        System.out.println("Values: " + Arrays.toString(this.values));
        System.out.println("Cols: " + Arrays.toString(this.cols));
        System.out.println("Rows: " + Arrays.toString(this.rows));
    }

    public int[] getCOO_values()
    {
        return this.values;
    }

    public int[] getCOO_cols()
    {
        return this.cols;
    }

    public int[] getCOO_rows()
    {
        return this.rows;
    }

    public int getCOO_nnz()
    {
        return this.values.length;
    }
}
