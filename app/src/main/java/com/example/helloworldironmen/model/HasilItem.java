package com.example.helloworldironmen.model;

import com.google.gson.annotations.SerializedName;

public class HasilItem{

    @SerializedName("daerah_batik")
    private String daerahBatik;

    @SerializedName("harga_rendah")
    private Integer hargaRendah;

    @SerializedName("harga_tinggi")
    private Integer hargaTinggi;

    @SerializedName("nama_batik")
    private String namaBatik;

    @SerializedName("makna_batik")
    private String maknaBatik;

    @SerializedName("link_batik")
    private String linkBatik;

    @SerializedName("id")
    private Integer id;

    @SerializedName("hitung_view")
    private Integer hitungView;

    public void setDaerahBatik(String daerahBatik){
        this.daerahBatik = daerahBatik;
    }

    public String getDaerahBatik(){
        return daerahBatik;
    }

    public void setHargaRendah(Integer hargaRendah){
        this.hargaRendah = hargaRendah;
    }

    public Integer getHargaRendah(){
        return hargaRendah;
    }

    public void setHargaTinggi(Integer hargaTinggi){
        this.hargaTinggi = hargaTinggi;
    }

    public Integer getHargaTinggi(){
        return hargaTinggi;
    }

    public void setNamaBatik(String namaBatik){
        this.namaBatik = namaBatik;
    }

    public String getNamaBatik(){
        return namaBatik;
    }

    public void setMaknaBatik(String maknaBatik){
        this.maknaBatik = maknaBatik;
    }

    public String getMaknaBatik(){
        return maknaBatik;
    }

    public void setLinkBatik(String linkBatik){
        this.linkBatik = linkBatik;
    }

    public String getLinkBatik(){
        return linkBatik;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setHitungView(Integer hitungView){
        this.hitungView = hitungView;
    }

    public Integer getHitungView(){
        return hitungView;
    }
}