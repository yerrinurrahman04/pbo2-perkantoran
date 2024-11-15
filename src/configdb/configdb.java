/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configdb;
import com.mysql.cj.xdevapi.Result;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class configdb {
    
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/2210010362_pbo2";
    private static final String username = "root";
    private static final String password = "";
    public Connection KoneksiDB;
    
    public configdb() {}

    // Mendapatkan koneksi ke database
    public Connection getKoneksiDB() {
        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException error) {
            System.err.println("Gagal membuat koneksi: " + error.getMessage());
        }
        return koneksi;
    }

    public void SimpanSuratDinamis(int id_surat, int id_bulk, String sender, String title, String description, String status, String create_at, String modified_at, int create_by, String modified_by, String no_naskah, String tgl_surat){
        try {
            if (duplicateKey("surat", "id_surat", "id_surat")){
                JOptionPane.showMessageDialog(null, "ID sudah Terdaftar");
            } else{
                String SQL = "INSERT INTO surat (id_surat,id_bulk,sender,title,description,status,create_at,modified_at,create_by,modified_by,no_naskah,tgl_surat) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement simpan = getKoneksiDB().prepareStatement(SQL);
                simpan.setInt(1, id_surat);
                simpan.setInt(2, id_bulk);
                simpan.setString(3, sender);
                simpan.setString(4, title);
                simpan.setString(5, description);
                simpan.setString(6, status);
                simpan.setString(7, create_at);
                simpan.setString(8, modified_at);
                simpan.setInt(9, create_by);
                simpan.setString(10, modified_by);
                simpan.setString(11, no_naskah);
                simpan.setString(12, tgl_surat);
                simpan.executeUpdate();
                
                System.out.println("Data Berhasil Disimpan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");
                
                simpan.close();
                getKoneksiDB().close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void SimpanDisposisiDinamis(int id_disposisi, int id_surat, String pengirim, String penerima, String instruksi, String status, String create_at, int create_by, String modified_by, String modified_at){
        try {
            if (duplicateKey("disposisi", "id_disposisi", "id_disposisi")){
                JOptionPane.showMessageDialog(null, "ID sudah Terdaftar");
            } else{
                String SQL = "INSERT INTO disposisi (id_disposisi,id_surat,pengirim,penerima,instruksi,status,create_at,create_by,modified_by,modified_at) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement simpan = getKoneksiDB().prepareStatement(SQL);
                simpan.setInt(1, id_disposisi);
                simpan.setInt(2, id_surat);
                simpan.setString(3, pengirim);
                simpan.setString(4, penerima);
                simpan.setString(5, instruksi);
                simpan.setString(6, status);
                simpan.setString(7, create_at);
                simpan.setInt(8, create_by);
                simpan.setString(9, modified_by);
                simpan.setString(10, modified_at);
                simpan.executeUpdate();
                
                System.out.println("Data Berhasil Disimpan");
                JOptionPane.showMessageDialog(null,"Data Berhasil Ditambah");
                
                simpan.close();
                getKoneksiDB().close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean duplicateKey(String NamaTabel, String PrimaryKey, String value) { 
        boolean hasil=false;

        try {
            Statement sts = getKoneksiDB().createStatement();
            ResultSet rs = sts.executeQuery("SELECT * FROM "+NamaTabel+" WHERE "+PrimaryKey+" ='"+value+"'");

            hasil = rs.next();

            rs.close();
            sts.close(); 
            getKoneksiDB().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return hasil;
    }
    
    public String getFieldTabel(String[] FieldTabelnya) {
    String hasilnya = "";
    int deteksiIndexAkhir = FieldTabelnya.length - 1;

    try {
        for (int i = 0; i < FieldTabelnya.length; i++) {
            if (i == deteksiIndexAkhir) {
                hasilnya = hasilnya + FieldTabelnya[i];
            } else {
                hasilnya = hasilnya + FieldTabelnya[i] + ",";
            }
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    return "(" + hasilnya + ")";
    }
    
    public String getIsiTabel(String[] IsiTabelnya){
    String hasilnya = "";
    int DeteksiIndex=IsiTabelnya.length-1;
    
    try {
        for (int i = 0; i < IsiTabelnya.length; i++){
            if (i==DeteksiIndex){
                hasilnya=hasilnya+"'"+IsiTabelnya[i]+"'";
            }else{
                hasilnya=hasilnya+"'"+IsiTabelnya[i]+"',";
            }
        }
    } catch (Exception e){
        System.out.println(e.toString());
    }
    return "("+hasilnya+")";
    }
    
    public String getFieldValueEdit(String[] Field, String[] value){
        String hasil = "";
        int deteksi = Field.length-1;
        try {
            for (int i = 0; i < Field.length; i++) {
                if (i==deteksi){
                    hasil = hasil +Field[i]+" ='"+value[i]+"'";
                }else{
                   hasil = hasil +Field[i]+" ='"+value[i]+"',";  
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return hasil;
    }

    
    public void UbahDinamis(String NamaTabel, String PrimaryKey, String IsiPrimary,String[] Field, String[] Value){
        
        try {
           String SQLUbah = "UPDATE "+NamaTabel+" SET "+getFieldValueEdit(Field, Value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
           Statement perintah = getKoneksiDB().createStatement();
           System.out.println("Data Berhasil Diubah");
           perintah.executeUpdate(SQLUbah);
           perintah.close();
           getKoneksiDB().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
    
    public void HapusDinamis(String NamaTabel, String PK, String isi){
        try {
            String SQL="DELETE FROM "+NamaTabel+" WHERE "+PK+"='"+isi+"'";
            Statement perintah = getKoneksiDB().createStatement();
            System.out.println("Data Berhasil Dihapus");
            perintah.executeUpdate(SQL);
            perintah.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
