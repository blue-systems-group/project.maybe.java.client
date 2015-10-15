package edu.buffalo.cse.maybeclient.rest;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by xcv58 on 10/15/15.
 */
public class ServiceFactory {
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
