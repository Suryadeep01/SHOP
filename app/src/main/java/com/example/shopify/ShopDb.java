package com.example.shopify;

public class ShopDb {
    private static ShopDb single_instance = null;

     int[] Male = {R.drawable.menshirt1, R.drawable.menshirt2, R.drawable.srw, R.drawable.sre, R.drawable.menshirt4};
     int[] Female = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f5, R.drawable.f6};
     int[] Kids = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5};

    public static synchronized ShopDb getInstance()
    {

        if (single_instance == null)
            single_instance = new ShopDb();

        return single_instance;
    }

    public int getProduct(int i,int j){

            switch (i) {
                case 0 : {
                    return  ShopDb.getInstance().Male[j];
                }
                case 1: {
                    return  ShopDb.getInstance().Female[j];
                }
                case 2: {
                    return  ShopDb.getInstance().Kids[j];
                }
            }
        return  0;
    }


}
