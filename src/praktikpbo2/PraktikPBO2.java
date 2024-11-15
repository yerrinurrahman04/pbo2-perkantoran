/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikpbo2;
import configdb.configdb;
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
public class PraktikPBO2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Simpan Surat Dinamis
        /*try {
            configdb config = new configdb();
            //Koding untuk pemanggilan SimpanSuratDinamis
            int id_surat = 1;
            int id_bulk = 1;  // Pastikan id_bulk sudah ada di tabel bulk
            String sender = "John";
            String title = "title here";
            String description = "description here";
            String status = "status here";
            String create_at = "2021-06-12";
            String modified_at = "2024-12-12";
            int create_by = 1;
            String modified_by = "duke";
            String no_naskah = "1122";
            String tgl_surat = "2024-11-15";
            // Memanggil metode SimpanSuratDinamis
            config.SimpanSuratDinamis(id_surat, id_bulk, sender, title, description, status, create_at, modified_at, create_by, modified_by, no_naskah, tgl_surat);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        //Simpan Disposisi Dinamis
        /*try {
            configdb config = new configdb();
            //Koding untuk pemanggilan SimpanDisposisiDinamis
            int id_disposisi = 1;
            int id_surat = 1;
            String pengirim = "Duke";
            String penerima = "Harry";
            String instruksi = "pelaksanaan tugas";
            String status = "jabatan";
            String create_at = "2021-06-12";
            int create_by = 1;
            String modified_at = "2024-12-12";
            String modified_by = "Jane";
            // Memanggil metode SimpanSuratDinamis
            config.SimpanDisposisiDinamis(id_disposisi, id_surat, pengirim, penerima, instruksi, status, create_at, create_by, modified_by, modified_at);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        //Koding untuk menjalankan Ubah Dinamis
        /*try {
            configdb config = new configdb();
            
            // Menentukan tabel, primary key, dan isi primary key
            String NamaTabel = "disposisi";
            String PrimaryKey = "id_disposisi";
            String IsiPrimary = "1";
            
            // Menentukan field dan value untuk update
            String[] Field = {"id_surat","pengirim","penerima","instruksi","status","create_at","create_by","modified_by","modified_at"};
            String[] Value = {"3", "Ragil", "Akbar","kirimkan ke ketua", "sekretaris", "2024-11-15", "9", "Turmuzi","2023-12-12"};
            
            // Memanggil metode UbahDinamis
            config.UbahDinamis(NamaTabel, PrimaryKey, IsiPrimary, Field, Value);
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        //Koding untuk menjalankan Hapus Dinamis
        try {
            configdb config = new configdb();
            
            // Menentukan tabel, primary key, dan isi primary key yang akan dihapus
            String NamaTabel = "disposisi";
            String PrimaryKey = "id_disposisi";
            String IsiPrimary = "1";  // Nilai primary key yang ingin dihapus
            
            // Memanggil metode HapusDinamis
            config.HapusDinamis(NamaTabel, PrimaryKey, IsiPrimary);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
