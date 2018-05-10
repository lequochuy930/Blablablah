package vn.khoapham.manager;

/**
 * Created by Nguyen Huu Kim on 5/4/2017.
 */

public class td {
    private String image;
    private String gia;
    private String loai;
    private String dientich;
    private String diachi;
    private String khoa;
    private String vitri;
    private String dt;
    private String email;
    private String cmt;
    private String mota;
    private String fk;
    public td(String gia, String loai, String dientich, String diachi,String khoa,String image) {
        this.gia = gia;
        this.loai = loai;
        this.dientich = dientich;
        this.diachi = diachi;
        this.khoa=khoa;
        this.image = image;
    }

    public td(String gia, String loai, String dientich, String diachi,String khoa,String image,String vitri,String dt,String email,String mota,String fk) {
        this.gia = gia;
        this.loai = loai;
        this.dientich = dientich;
        this.diachi = diachi;
        this.khoa=khoa;
        this.image = image;
        this.dt = dt;
        this.email = email;
        this.fk = fk;
        this.vitri = vitri;
        this.mota = mota;
    }

    public String getImage() {
        return image;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getCmt() {
        return cmt;
    }

    public String getDt() {
        return dt;
    }

    public String getVitri() {
        return vitri;
    }

    public String getEmail() {
        return email;
    }

    public String getMota() {
        return mota;
    }

    public String getFk() {
        return fk;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}
