package com.example.mantenimiento;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("nombreU") String nombreU,
            @Field("password") String password
    );



    @POST("api/mantenimiento/create")
    Call<FormResponsePMI> storeMantenimientoPMI(
            @Field("idUsuario")int idUsuario,
            @Field("tipo_mantenimiento") String tipo_mantenimiento,
            @Field("pmi_id") String pmiID,
            @Field("folio") String folio,
            @Field("cuadrilla") String cuadrilla,
            @Field("fecha_visita") String fecha,
            @Field("placas_vehiculo") String placas,
            @Field("municipio") String municipio
    );

    @POST("api/mantenimiento/create")
    Call<FormResponseLPR> storeMantenimientoLPR(
      @Field("idUsuario") int idUsuario,
      @Field("tipo_mantenimiento") String tipo_mantenimiento,
      @Field("lpr_id") String lprID,
      @Field("folio") String folio,
      @Field("cuadrilla") String cuadrilla,
      @Field("fecha_visita") String fecha,
      @Field("placas_vehiculo") String placas,
      @Field("municipio") String municipio
    );

}
