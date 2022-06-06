public class Main {

    public static void main(String[] args)
    {
        //primitive datatype
        int a=10;
        //wrapperimplementation of primitive datatype
        //boxing
        Integer b=new Integer(a);
        //unboxing
        int x=b.intValue();
        System.out.println(x);
        //auto-boxing
        Integer y=a;
        //auto-unboxing
        x=y;
        
        try{
            int[] arr = new int[1];
            arr[0]=100;
            System.out.println(arr[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("exception ocured");
        }
        finally {
            System.out.println("I amin finally block");
        }
    }
}
