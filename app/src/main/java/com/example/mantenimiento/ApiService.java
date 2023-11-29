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
    Call<GabResponsePMI> storeGabPMI(
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
    Call<AnuncioResponsePMI> storeAnuncioPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("estr_lim") boolean getEstructuraLimpieza,
            @Field("estr_est") boolean getEstructuraEstatus,
            @Field("orient_lim") boolean getOrientacionLimpieza,
            @Field("orient_est") boolean getOrientacionEstatus
    );

    @POST("api/boton/create")
    Call<BotonResponsePMI> storeBotonPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("val_com_lim") boolean getValidacionLimpieza,
            @Field("val_com_est") boolean getValidacionEstatus,
            @Field("aju_tor_lim") boolean getTornillosLimpieza,
            @Field("aju_tor_est") boolean getTornillosEstatus,
            @Field("acab_lim") boolean getSuperficieLimpieza,
            @Field("acab_est") boolean getSuperficieEstatus,
            @Field("rev_conx_lim") boolean getConexionesLimpieza,
            @Field("rev_conx_est") boolean getConexionesEstatus,
            @Field("rem_cab_lim") boolean getCableadoLimpieza,
            @Field("rem_cab_est") boolean getCableadoEstatus,
            @Field("act_firw_lim") boolean getFimwareLimpieza,
            @Field("act_firw_est") boolean getFimwareEstatus
    );

    @POST("api/registro/create")
    Call<RegistroResponsePMI> storeRegistroPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("tap_galb_lim") boolean getGalvLimpieza,
            @Field("tap_galb_est") boolean getGalvEstatus,
            @Field("torn_seg_lim") boolean getTorxLimpieza,
            @Field("torn_seg_est") boolean getTorxEstatus
    );

    @POST("api/anclas/create")
    Call<AnclasResponsePMI> storeAnclasPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("cuerda_lim") boolean getCuerdaLimpieza,
            @Field("cuerda_est") boolean getCuerdaEstatus,
            @Field("tr_rond_lim") boolean getPiezasLimpieza,
            @Field("tr_rond_est") boolean getPiezasEstatus
    );

    @POST("api/cimentacion/create")
    Call<CimResponsePMI> storeCimentacionPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("nPiso_lim") boolean  getNivelLimpieza,
            @Field("nPiso_est") boolean getNivelEstatus,
            @Field("aSuper_lim") boolean getAcabLimpieza,
            @Field("aSuper_est") boolean getAcabEstatus,
            @Field("superficie_lim") boolean getExpLimpieza,
            @Field("superficie_est") boolean getExpEstatus,
            @Field("pGrout_lim") boolean getGroutLimpieza,
            @Field("pGrout_est") boolean getGroutEstatus
    );

    @POST("api/sistema/create")
    Call<SistemaResponsePMI> storeSistemaPMI(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("nPisoT_lim") boolean getNivelLimpieza,
      @Field("nPisoT_est") boolean getNivelEstatus,
      @Field("rPieza_lim") boolean getRegistroLimpieza,
      @Field("rPieza_est") boolean getRegistroEstatus,
      @Field("eConect_lim") boolean getEstadoCLimpieza,
      @Field("eConect_est") boolean getEstadoCEstado,
      @Field("cNV_lim") boolean getCablesNLimpieza,
      @Field("cNV_est") boolean getCablesNEstatus

    );



}
