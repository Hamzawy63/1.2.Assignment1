package eg.edu.alexu.csd.datastructure.stack.cs26;

public class myMain {

    public static void main(String[] args) {
        try {
            System.out.println(divide(10,0));
        }catch ( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public static  int  divide(int a,int b)
    {
        if(b==0)
            throw new IllegalArgumentException("Divisor can not be zero");
        return a/b;
    }
}
