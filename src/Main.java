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
    }
}