public class ChangeMaker
{
    public static int[] change_DP(int n, int[] d)
    {
        int k = d.length;
        int [] C = new int[n+1];
        int [] a = new int[n+1];
        int [] b = new int[n+1];
        int temp;

        //j is the amount of money
        //j loops from 1 - n, C[j]
        for (int j = 1; j <= n; j++)
        {
            int min = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++)
            {
                if (j - d[i] >= 0)
                {
                    if (C[j-d[i]] < min)
                    {
                        min = C[j-d[i]];
                        index = i;
                    }

                }
            }
            //amt of coins
            C[j] = min + 1;
            //largest coin value in d array using
            a[j] = index; //i value of min
            //filling B
            for (int w = 0; w <= C[j]; w++)
            {
                b[j] = d[a[j]];
                System.out.println("b[" + j + "]: " + b[j]);
            }
            //System.out.println("b[j]: " + b[j]);

        }
        return a;
    }

    public static int min(int[] num)
    {
        int min = num[0];
        for (int i = 0; i < num.length; i++)
        {
            if (num[i] < min)
            {
                min = num[i];
            }
        }
        return min;
    }


    public static void main(String[] args)
    {
        //min works
//        int[] data = {10,20,30,40,50,60,71,80,90,91};
//        int [] test = {5, 10, 20, 7, 1, 4};
//        int mini = min(data);
//        System.out.println(mini);
        int money  = 50;
        int [] d = {100, 25, 10, 5, 1};

        int [] change = change_DP(money, d);
        for (int i = 0; i < change.length - 1; i++)
        {
            System.out.println("i: " + i + " change: " + change[i]);
        }



    }

}
