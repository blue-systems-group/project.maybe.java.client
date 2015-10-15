package edu.buffalo.cse.maybeclient.rest;

import retrofit.Call;
import retrofit.http.*;

import java.util.List;

/**
 * Created by xcv58 on 10/15/15.
 */
public interface MaybeRESTService {
    @GET("devices/{deviceID}")
    Call<List<Device>> getDevice(@Path("deviceID") String deviceID);

//    @PUT("devices/{deviceID}")
//    Observable<Device> putDevice(@Path("deviceID") String deviceID, @Body Device device);

    @POST("devices/")
    Call<Device> postDevice(@Body Device device);

    @DELETE("devices/{deviceID}")
    Call<EmptyResponse> delDevice(@Path("deviceID") String deviceID);
//    @POST("logs/{deviceID}/{packageName}")
//    Observable<LogResponse> postLog(@Path("deviceID") String deviceID, @Path("packageName") String packageName, @Body MaybeLog logObject);
//
//    @POST("logs/{deviceID}/{packageName}")
//    Observable<LogResponse> postLog(@Path("deviceID") String deviceID, @Path("packageName") String packageName, @Body String string);
}
