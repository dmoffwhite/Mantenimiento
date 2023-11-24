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

    @POST("api/equipamiento/create")
    Call<EquipResponsePMI> storeEquipPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("radio_lim") boolean getRadioLimpieza,
            @Field("radio_est") boolean getRadioEstatus,
            @Field("cam_ptz_lim") boolean getPTZLimpieza,
            @Field("cam_ptz_est") boolean getPTZEstatus,
            @Field("cam_fij_lim") boolean getFijaLimpieza,
            @Field("cam_fij_est") boolean getFijaEstatus,
            @Field("cam_an_lim") boolean getAnaliLimpieza,
            @Field("cam_an_est") boolean getAnaliEstatus
    );

    @POST("api/gabinete/create")
    Call<GabResponsePMI> storeGab(
          @Field("idMantenimiento") int idMantenimiento,
          @Field("tub_lim") boolean geTuberiaLimpieza,
          @Field("tub_est") boolean geTuberiaEstatus,
          @Field("tapa_lim") boolean getTapaLimpieza,
          @Field("tapa_est") boolean getTapaEstatus,
          @Field("cables_lim") boolean getCabInLimpieza,
          @Field("cables_est") boolean getCabInEstatus,
          @Field("ext_gab_lim") boolean getExteriorLimpieza,
          @Field("ext_gab_est") boolean getExteriorEstatus,
          @Field("fij_clem_lim") boolean getFijacionLimpieza,
          @Field("fij_clem_est") boolean getFijacionEstatus,
          @Field("orientacion_lim") boolean getOrientacionLimpieza,
          @Field("orientacion_est") boolean getOrientacionEstatus,
          @Field("cable_neu_lim") boolean getCablenNLimpieza,
          @Field("cable_neu_est") boolean getCableNEstatus,
          @Field("ventilador_lim") boolean getVentiladorLimpieza,
          @Field("ventilador_est") boolean getVentiladorEstatus,
          @Field("filtros_lim") boolean getFiltrosLimpieza,
          @Field("filtros_est") boolean getFiltrosEstatus
    );

    @POST("api/anuncio/create")
    Call<AnuncioResponsePMI> storeAnuncio(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("estr_lim") boolean getEstructuraLimpieza,
            @Field("estr_est") boolean getEstructuraEstatus,
            @Field("orient_lim") boolean getOrientacionLimpieza,
            @Field("orient_est") boolean getOrientacionEstatus
    );




}
