package com.example.mantenimiento;

import retrofit2.Call;
import retrofit2.http.Body;
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

    @POST("api/poste/create")
    Call<PosteResponsePMI> storePostePMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("con_tapon_lim") boolean getConectoresLimpieza,
            @Field("con_tapon_est") boolean getConectoresEstatus,
            @Field("ele_aje_lim") boolean getElementosLimpieza,
            @Field("ele_aje_est") boolean getElementosEstatus,
            @Field("lij_san_lim") boolean getSeccionesLimpieza,
            @Field("lij_san_est") boolean getSeccionesEstatus,
            @Field("pint_oxid_lim") boolean getPinturaLimpieza,
            @Field("pint_oxid_est") boolean getPinturaEstatus

    );

    @POST("api/pararayos/create")
    Call<PararayoResponsePMI> storePararayosPMI(
                @Field("idMantenimiento") int idMantenimiento,
                @Field("ptn_fardy_lim") boolean getPuntaLimpieza,
                @Field("ptn_fardy_est") boolean getPuntaEstatus
    );

    @POST("api/brazos/create")
    Call<BrazosResponsePMI> storeBrazosPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("carcasa_lim") boolean getCarcasaLimpieza,
            @Field("carcasa_est") boolean getCarcasaEstatus,
            @Field("tub_conx_lim") boolean getTuberiaLimpieza,
            @Field("tub_conx_est") boolean getTuberiaEstatus
    );



}
