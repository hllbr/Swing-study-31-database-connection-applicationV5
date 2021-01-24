
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaglanmaProjeV3 {
        private String kullanıcı_adı ="root";
        private String parola = "";
        private String db_isim = "omar11";
        private String host = "localhost";
        private int port = 3306;
        private Connection con = null ;
        private Statement state = null ;

        public BaglanmaProjeV3(){
            //Constructor
            String url = "jdbc:mysql://"+host+":"+port+"/"+db_isim+ "?useUnicode=true&characterEncoding=utf8";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Sunucuya bağlanma işlemi başarılı");
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Sunucu Bulunamadı");
            }
            try {
                con = DriverManager.getConnection(url,kullanıcı_adı,parola);
                System.out.println("SQL TERİ TABANINA BAĞLANMA İŞLEMİ BAŞARILI");
            } catch (SQLException ex) {
                System.out.println("SQL BAĞLANMA HATASI");
                //Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void calısanlarıGetir(){
            String sorgu ="Select * From calisanlar";

            try {
                state = con.createStatement();
                ResultSet res = state.executeQuery(sorgu);
                while(res.next()){
                int id = res.getInt("id");
                String ad = res.getString("ad");
                String soyad = res.getString("soyad");
                String email = res.getString("email");
                System.out.println("/-Ad : "+ad+" /-Soyad : "+soyad+" /-Email : "+email+" /-Id : "+id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        public void calısanEkle(){
            try {
                state = con.createStatement();
                
                String ad = "Mehri";
                
                String soyad = "Kingston";
                
                String email = "MehriKingston@gmail.com";
               
                String Sorgu = "Insert Into calisanlar(ad,soyad,email) VALUES("+"'"+ad+"',"+"'"+soyad+"',"+"',"+email+"')";
              
                state.executeUpdate(Sorgu);
                
            } catch (SQLException ex) {
                Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        public void CalısanGuncelle(){
            try {
                state = con.createStatement();
                String sorgu = "Update calisanlar Set email = 'hllbr@prince' where id =2";
                /*
                Hangi tabloyu güncelleyeceğimizi ifade ediyorum başta
                daha sonra tablonun hangi özelliğini güncellemek istediğimi ifade ediyorum
                id 1 olan email adresinin verisi değiştiriliyor
                */
                state.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("SQL EXCEPTİON HATASI MEYDANA GELDİ");
               // Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         public void CalısanGuncelle1(){
            try {
                state = con.createStatement();
                String sorgu = "Update calisanlar Set email = 'doyouknowsehzade@prince' where id >2";
                /*
                Hangi tabloyu güncelleyeceğimizi ifade ediyorum başta
                daha sonra tablonun hangi özelliğini güncellemek istediğimi ifade ediyorum
                id 1 olan email adresinin verisi değiştiriliyor
                */
                state.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("SQL EXCEPTİON HATASI MEYDANA GELDİ");
               // Logger.getLogger(BaglanmaProjeV3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    public static void main(String[] args) {
    BaglanmaProjeV3 v3 = new BaglanmaProjeV3();
    System.out.println("***************************************************V2");
    System.out.println("Eklenmeden Önce");
    v3.calısanlarıGetir();
   // System.out.println("***************************************************v3");
   // v3.calısanEkle();
   // System.out.println("eklendikten sonra");
        System.out.println("*************************************************V4");
        v3.CalısanGuncelle();
        
    v3.calısanlarıGetir();
    v3.CalısanGuncelle1();
     System.out.println("*************************************************V4.0");
     v3.calısanlarıGetir();
     //Güncelleme = örnek olarak idsi 1 olan çalışanın mail adresini güncellemek mesela yada ıdsi 3 ten büyük olan çalışanların mail adreslerini güncellemek gibi işlemler
    

    
        
        
        
    }
    
}
