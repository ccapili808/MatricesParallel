import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        int[][] mat = {{1, 0, 2},
                       {0, 3, 0},
                       {4, 0, 5}};
        System.out.println("CSC");
        CSC csc = new CSC(mat);
        System.out.println();

        System.out.println("CSR");
        CSR csr = new CSR(mat);
        System.out.println();

        System.out.println("COO");
        COO coo = new COO(mat);
        System.out.println();



        COO coo_A = new COO(mat);
        int[][] transpose = transposeMat(mat);
        COO coo_B = new COO(transpose);
        cooMat(coo_A, coo_B, mat.length);
    }

    private static void cooMat(COO coo_A, COO coo_B, int n)
    {
        int rowPtrA = 0; int rowPtrB = 0;
        for(int i=0; i< n; i++)
        {
            int tmp = 0;
          for(int j=rowPtrA; j< coo_A.getCOO_nnz(); j++)
          {
              if(coo_A.getCOO_rows()[j] == i)
              {
                  for(int k = rowPtrB; k< coo_B.getCOO_nnz(); k++)
                  {
                      if(coo_B.getCOO_rows()[k] == i)
                      {
                          if(coo_A.getCOO_cols()[j] == coo_B.getCOO_cols()[k])
                            {
                                System.out.println("COOA[J].val + COOB[K].val " + coo_A.getCOO_values()[j] + " * " + coo_B.getCOO_values()[k]);
                                tmp += coo_A.getCOO_values()[j] * coo_B.getCOO_values()[k];
                                rowPtrB = k;
                                break;
                            }
                      }
                  }

              }
              else {
                    rowPtrA = j;
                    break;
              }
          }
        }
    }

    private static int[][] transposeMat(int[][] mat)
    {
        int[][] transpose = new int[mat.length][mat[0].length];
        for(int i=0; i< mat.length; i++)
        {
          for(int j=0; j< mat[0].length; j++)
          {
            transpose[i][j] = mat[j][i];
          }
        }
        return transpose;
    }


}