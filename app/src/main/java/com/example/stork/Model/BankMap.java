package com.example.stork.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BankMap {
    private Map<String,String> bankMap;
    public BankMap(){
        bankMap = new HashMap<>();
        init();
    }

    private void init() {
        bankMap.put("Adabank A.Ş.","100");
        bankMap.put("Akbank T.A.Ş.","046");
        bankMap.put("Aktif Yatırım Bankası A.Ş.","034");
        bankMap.put("Al Baraka Türk Katılım Bankası A.Ş. ","203");
        bankMap.put("Al Baraka Türk Katılım Bankası A.Ş.","223");
        bankMap.put("Alternatifbank A.Ş.","124");
        bankMap.put("Anadolubank A.Ş.","135");
        bankMap.put("Arap Türk Bankası A.Ş.","091");
        bankMap.put("Asya Katılım Bankası A.Ş.","208");
        bankMap.put("Atlas Yatırım Bankası A.Ş.","144");
        bankMap.put("Banca di Roma","087");
        bankMap.put("Bank Mellat","094");
        bankMap.put("Bank of Tokyo -Mitsubishi UFJ Turkey A.Ş.","147");
        bankMap.put("Bank Pozitif Kredi ve Kalkınma Bankası A.Ş.","142");
        bankMap.put("BCCI","095");
        bankMap.put("Birleşik Fon Bankası A.Ş. (Bayındırbank A.Ş.)","029");
        bankMap.put("Birleşik Yatırım","119");
        bankMap.put("BNP-Ak-Dresdner Bank A.Ş.","107");
        bankMap.put("Burganbank A.Ş.","125");
        bankMap.put("Citibank N.A.","092");
        bankMap.put("Credit Lyonnais","110");
        bankMap.put("Credit Suisse First Boston İstanbul Şubesi","140");
        bankMap.put("Denizbank A.Ş.","134");
        bankMap.put("Denizbank","013");
        bankMap.put("Deutsche Bank A.Ş.","115");
        bankMap.put("Diler Yatırım Bankası A.Ş.","138");
        bankMap.put("Family Finans Kurumu","204");
        bankMap.put("Fiba Bank A.Ş.","103");
        bankMap.put("Finansbank A.Ş.","111");
        bankMap.put("Fortis Bank (TEB)","071");
        bankMap.put("GSD Yatırım Bankası A.Ş.","139");
        bankMap.put("Habib Bank Limited","097");
        bankMap.put("HSBC Bank A.Ş. ","048");
        bankMap.put("HSBC Bank A.Ş.","123");
        bankMap.put("IMKB Takas ve Saklama Bankası A.Ş.","132");
        bankMap.put("IMPEXBANK","104");
        bankMap.put("ING BANK","133");
        bankMap.put("Intesa SanPaolo SPA İtalya-İstanbul Merkez Şubesi","148");
        bankMap.put("İller Bankası", "004");
        bankMap.put("JP Morgan Chase Bank İstanbul Türkiye Şubesi","098");
        bankMap.put("KentBank","127");
        bankMap.put("Kuveyt Türk Katılım Bankası A.Ş.","205");
        bankMap.put("Kıbrıs Kredi Bankası","118");
        bankMap.put("Marbank","113");
        bankMap.put("Morgan Guarenty Trusy Company","145");
        bankMap.put("Nurol Yatırım Bankası A.Ş.","141");
        bankMap.put("OdeaBank A.Ş.","146");
        bankMap.put("Okan Yatırım Bankası A Ş","136");
        bankMap.put("Oyak Bank A.Ş. - ING BANK","099");
        bankMap.put("Park Yatırım Bankası","128");
        bankMap.put("PORTIGON A.G.","106");
        bankMap.put("Rabobank Nederland İstanbul Merkez Şubesi","137");
        bankMap.put("Societe Generale","122");
        bankMap.put("Standard Chartered Yatırım Bankası Türk A.Ş.","121");
        bankMap.put("Sınai Yatırım Bankası A.Ş.","058");
        bankMap.put("Şekerbank T.A.Ş.","059");
        bankMap.put("TAİB Yatırım Bank A.Ş.","116");
        bankMap.put("Tat Yatırım Bankası A.Ş.","129");
        bankMap.put("Tekstil Bankası A.Ş.","109");
        bankMap.put("The Royal Bank of Scotland PLC Merkezi Amsterdam İstanbul Merkez Şubesi","088");
        bankMap.put("Turizm Yatırım ve Ticaret Bank A.Ş.","117");
        bankMap.put("Turkish Bank A.Ş.","096");
        bankMap.put("Turkland Bank A.Ş.","108");
        bankMap.put("Türk Ekonomi Bankası A.Ş.","032");
        bankMap.put("Türk Sakura Bank A.Ş.","101");
        bankMap.put("Türkiye Cumhuriyet Merkez Bankası A.Ş.","001");
        bankMap.put("Türkiye Cumhuriyeti Ziraat Bankası A.Ş.","010");
        bankMap.put("Türkiye Finans Katılım Bankası A.Ş.","206");
        bankMap.put("Türkiye Garanti Bankası A.Ş.","062");
        bankMap.put("Türkiye Halk Bankası A.Ş.","012");
        bankMap.put("Türkiye İhracat Kredi Bankası A.Ş. (Eximbank)","016");
        bankMap.put("Türkiye İş Bankası A.Ş.","064");
        bankMap.put("Türkiye Kalkınma Bankası A.Ş.","017");
        bankMap.put("Türkiye Sınai Kalkınma Bankası A.Ş.","014");
        bankMap.put("Türkiye Vakıflar Bankası T.A.O.","015");
        bankMap.put("Vakıf Katılım Bankası A.Ş.","210");
        bankMap.put("Yapı ve Kredi Bankası A.Ş.","067");
    }
    public String getValue(String key) {
        return bankMap.get(key);
    }

    public Set<String> getKeyList() {
        return bankMap.keySet();
    }
}
