package com.example.mantenimiento;

import android.widget.EditText;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
            @Field("pint_oxid_est") boolean getPinturaEstatus,
            @Field("OBSERVACION_TAPON") String obsConectores,
            @Field("OBSERVACION_ELEMENTOS") String obsElementos,
            @Field("OBSERVACION_LIJADO") String obsSecciones,
            @Field("OBSERVACION_PINTURA") String obsPintura

    );

    @POST("api/pararayos/create")
    Call<PararayoResponsePMI> storePararayosPMI(
                @Field("idMantenimiento") int idMantenimiento,
                @Field("ptn_fardy_lim") boolean getPuntaLimpieza,
                @Field("ptn_fardy_est") boolean getPuntaEstatus,
                @Field("OBSERVACION_FARADAY") String obsPuntaFaraday
    );

    @POST("api/brazos/create")
    Call<BrazosResponsePMI> storeBrazosPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("carcasa_lim") boolean getCarcasaLimpieza,
            @Field("carcasa_est") boolean getCarcasaEstatus,
            @Field("tub_conx_lim") boolean getTuberiaLimpieza,
            @Field("tub_conx_est") boolean getTuberiaEstatus,
            @Field("OBSERVACION_CARCASA") String obsCarcasa,
            @Field("OBSERVACION_TUBERIA") String obsTuberia
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
            @Field("cam_an_est") boolean getAnaliEstatus,
            @Field("OBSERVACION_RADIO") String obsRadio,
            @Field("OBSERVACION_CAM_PTZ") String obsPTZ,
            @Field("OBSERVACION_CAM_FIJ") String obsFija,
            @Field("OBSERVACION_CAM_ANC") String obsAna
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
          @Field("filtros_est") boolean getFiltrosEstatus,
          @Field("OBSERVACION_TUBERIA") String obsTub,
          @Field("OBSERVACION_TAPA") String obsTapa,
          @Field("OBSERVACION_CABLES") String obsCabIn,
          @Field("OBSERVACION_EXTERIOR") String obsExt,
          @Field("OBSERVACION_FIJACION") String obsFijacion,
          @Field("OBSERVACION_ORIENTACION") String obsOrientacion,
          @Field("OBSERVACION_CAB_NEU") String obsCable,
          @Field("OBSERVACION_VENTILADOR") String obsVentilador,
          @Field("OBSERVACION_FILTROS") String obsFiltros
    );

    @POST("api/anuncio/create")
    Call<AnuncioResponsePMI> storeAnuncioPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("estr_lim") boolean getEstructuraLimpieza,
            @Field("estr_est") boolean getEstructuraEstatus,
            @Field("orient_lim") boolean getOrientacionLimpieza,
            @Field("orient_est") boolean getOrientacionEstatus,
            @Field("OBSERVACION_ESTRUCTURA") String obsEstructura,
            @Field("OBSERVACION_ORIENTACION") String obsOrientacion
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
            @Field("act_firw_est") boolean getFimwareEstatus,
            @Field("OBSERVACION_VALIDACION") String obsValidacion,
            @Field("OBSERVACION_AJUSTE") String obsTornillos,
            @Field("OBSERVACION_ACABADO") String obsSuperficie,
            @Field("OBSERVACION_REVISION") String obsConexiones,
            @Field("OBSERVACION_REEMPLAZO") String obsCableado,
            @Field("OBSERVACION_FIRMWARE") String obsFimware
    );

    @POST("api/registro/create")
    Call<RegistroResponsePMI> storeRegistroPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("tap_galb_lim") boolean getGalvLimpieza,
            @Field("tap_galb_est") boolean getGalvEstatus,
            @Field("torn_seg_lim") boolean getTorxLimpieza,
            @Field("torn_seg_est") boolean getTorxEstatus,
            @Field("OBSERVACION_GALB") String obsGalv,
            @Field("OBSERVACION_SEG") String obsTorx
    );

    @POST("api/anclas/create")
    Call<AnclasResponsePMI> storeAnclasPMI(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("cuerda_lim") boolean getCuerdaLimpieza,
            @Field("cuerda_est") boolean getCuerdaEstatus,
            @Field("tr_rond_lim") boolean getPiezasLimpieza,
            @Field("tr_rond_est") boolean getPiezasEstatus,
            @Field("OBSERVACION_CUERDA") String obsCuerda,
            @Field("OBSERVACION_TR_ROND") String obsPiezas
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
            @Field("pGrout_est") boolean getGroutEstatus,
            @Field("OBSERVACION_NIVEL") String obsNivel,
            @Field("OBSERVACION_SUPER") String obsAcab,
            @Field("OBSERVACION_SUPERFICIE") String obsExp,
            @Field("OBSERVACION_GROUT") String obsGrout
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
      @Field("cNV_est") boolean getCablesNEstatus,
      @Field("OBSERVACION_NIVELP") String obsNivel,
      @Field("OBSERVACION_REGISTRO") String obsRegistro,
      @Field("OBSERVACION_ESTADO") String obsEstado,
      @Field("OBSERVACION_CABN") String obsCables
    );


    //LPR
    @POST("api/pararayosLPR/create")
    Call<PararayoResponseLPR> storePararayosLPR(
            @Field("idMantenimiento") int idMantenimiento,
            @Field("pFaraday_lim") boolean getPuntaLimpieza,
            @Field("pFaraday_est") boolean getPuntaEstatus,
            @Field("mastil_lim") boolean getMastilLimpieza,
            @Field("mastil_est") boolean getMastilEstatus,
            @Field("OBSERVACION_FARADAY") String obsPuntaFaraday,
            @Field("OBSERVACION_MASTIL") String obsMastil
    );

    @POST("api/equipamientoLPR/create")
    Call<EquipResponseLPR> storeEquipLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("radio_lim") boolean getRadioLimpieza,
      @Field("radio_est") boolean getRadioEstatus,
      @Field("cam_lpr_lim") boolean getCamLimpieza,
      @Field("cam_lpr_est") boolean getCamEstatus,
      @Field("OBSERVACION_RADIO") String obsRadio,
      @Field("OBSERVACION_CAM_LPR") String obsCam
    );


    @POST("api/electrificacionLPR/create")
    Call<ElectResponseLPR> storeElecLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("ali_elec_lim") boolean getRevisionLimpieza,
      @Field("ali_elec_est") boolean getRevisionEstatus,
      @Field("OBSERVACION_REVISION_ALIM") String obsRevision
    );

    @POST("api/gabineteLPR/create")
    Call<GabResponseLPR> storeGabLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("tuberia_lim") boolean getTubLicLimpieza,
      @Field("tuberia_est") boolean getTubLicEstatus,
      @Field("tapa_lim") boolean getTorSegLimpieza,
      @Field("tapa_est") boolean getTorSegEstatus,
      @Field("cab_int_lim") boolean getCabLimpieza,
      @Field("cab_int_est") boolean getCabEstatus,
      @Field("ext_gab_lim") boolean getExtLimpieza,
      @Field("ext_gab_est") boolean getExtEstatus,
      @Field("cierna_lim") boolean getCierLimpieza,
      @Field("cierna_est") boolean getCierEstatus,
      @Field("cab_neu_lim") boolean getCabNeuLimpieza,
      @Field("cab_neu_est") boolean getCabNeuEstatus,
      @Field("vent_lim") boolean getVentLimpieza,
      @Field("vent_est") boolean getVentEstatus,
      @Field("filt_lim") boolean getFiltLimpieza,
      @Field("filt_est") boolean getFiltEstatus,
      @Field("sil_lim") boolean getSilLimpieza,
      @Field("sil_est") boolean getSilEstatus,
      @Field("OBSERVACION_TUBERIA") String obsTub,
      @Field("OBSERVACION_TAPA") String obsTor,
      @Field("OBSERVACION_CABLES") String obsCab,
      @Field("OBSERVACION_EXTERIOR") String obsExt,
      @Field("OBSERVACION_CIERNA") String obsCier,
      @Field("OBSERVACION_CAB_NEU") String obsCabN,
      @Field("OBSERVACION_VENTILADOR") String obsVent,
      @Field("OBSERVACION_FILTROS") String obsFilt,
      @Field("OBSERVACION_SILICON") String obsSil
    );

    @POST("api/registroLPR/create")
    Call<RegistroResponseLPR> storeRegLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("tap_gal_lim") boolean getGalvLimpieza,
      @Field("tap_gal_est") boolean getGalvEstatus,
      @Field("torn_lim") boolean getTorxLimpieza,
      @Field("torn_est") boolean getTorxEstatus,
      @Field("OBSERVACION_GALB") String obsTubGalv,
      @Field("OBSERVACION_SEG") String obsTor
    );

    @POST("api/anclasLPR/create")
    Call<AnclasResponseLPR> storeAnclasLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("cuerda_gal_lim") boolean getCuerdaLimpieza,
      @Field("cuerda_gal_est") boolean getCuerdaEstatus,
      @Field("tu_rop_ron_lim") boolean getPiezasLimpieza,
      @Field("tu_rop_ron_est") boolean getPiezasEstatus,
      @Field("OBSERVACION_CUERDA_GAL") String obsCuerda,
      @Field("OBSERVACION_PIEZAS") String obsPiezas
    );

    @POST("api/cimentacionLPR/create")
    Call<CimResponseLPR> storeCimLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("super_cim_lim") boolean getAcabLimpieza,
      @Field("super_cim_est") boolean getAcabEstatus,
      @Field("super_sin_lim") boolean getExpLimpieza,
      @Field("super_sin_est") boolean getExpEstatus,
      @Field("grout_lim") boolean getGroutLimpieza,
      @Field("grout_est") boolean getGroutEstatus,
      @Field("OBSERVACION_ACABADO_SUP") String obsAcab,
      @Field("OBSERVACION_SUPERFICEI_CIM") String obsExp,
      @Field("OBSERVACION_GROUT") String obsGrout
    );

    @POST("api/estructuraLPR/create")
    Call<EstResponseLPR> storeEstLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("tor_brida_lim") boolean getTorbLimpieza,
      @Field("tor_brida_est") boolean getTorbEstatus,
      @Field("galv_lim") boolean getGalvLimpieza,
      @Field("galv_est") boolean getGalvEstatus,
      @Field("OBSERVACION_TOR") String obsTor,
      @Field("OBSERVACION_GALV") String obsGalv
    );

    @POST("api/sistemaLPR/create")
    Call<SistemaResponseLPR> storeSisLPR(
      @Field("idMantenimiento") int idMantenimiento,
      @Field("nPiso_lim") boolean getNivelLimpieza,
      @Field("nPiso_est") boolean getNivelEstatus,
      @Field("rPieza_lim") boolean getRegistroLimpieza,
      @Field("rPieza_est") boolean getRegistroEstatus,
      @Field("eConec_lim") boolean getEstadoCLimpieza,
      @Field("eConec_est") boolean getEstadoCEstado,
      @Field("cNV_lim") boolean getCablesNLimpieza,
      @Field("cNV_est") boolean getCablesNEstatus,
      @Field("OBSERVACION_NIVELP") String obsNivel,
      @Field("OBSERVACION_REGISTRO") String obsRegistro,
      @Field("OBSERVACION_ESTADO") String obsEstado,
      @Field("OBSERVACION_CABN") String obsCables
    );

    @PUT("api/mantenimiento/edit/{id}")
    Call<ObsResponseLPR> updateOBSLPR(
            @Path("id") int idMantenimiento,
            @Field("obser_grl") String obsGrl
    );

    @PUT("api/mantenimiento/edit/{id}")
    Call<ObsResponsePMI> updateOBSPMI(
            @Path("id") int idMantenimiento,
            @Field("obser_grl") String obsGrl
    );








}
