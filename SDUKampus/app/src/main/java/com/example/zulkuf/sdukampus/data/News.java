package com.example.zulkuf.sdukampus.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zulkuf on 11/03/17.
 */

public class News {

    private String image;
    private String caption;
    private String description;

    public String getImage() {
        return image;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<News> createNewsList(){
        News news1 = new News();
        news1.setCaption("Mehmet Akif Ersoy’u Anma Programları");
        news1.setDescription("Üniversitemiz Eğitim Fakültesi, Uluslararası Kültür" +
                " ve Etkileşim, Edebiyat, Stratejik Düşünce Topluluğu tarafından İstiklal Marşı’nın" +
                " Kabulü ve Mehmet Akif Ersoy’u anma etkinliği düzenleniyor.");
        news1.setImage("http://w3.sdu.edu.tr/SDU_Files/Images/mehmetakif%20afi%c5%9f%20SON-01-01%20(1).jpg");

        News news2 = new News();
        news2.setCaption("Araştırmacı Yazar Hamza Türkmen'den Konferans");
        news2.setDescription("Süleyman Demirel Üniversitesi Yoldaki İşaretler Topluluğu" +
                " tarafından düzenlenen \"Ulustan Ümmete\" konulu konferans, Araştırmacı Yazar" +
                " Hamza Türkmen'in katılımıyla 15 Mart Çarşamba günü 16.00'da Hukuk Fakültesi Konferans Salonu'nda gerçekleştirilecek.");
        news2.setImage("http://w3.sdu.edu.tr/SDU_Files/Images/ulustan%20u%cc%88mmete.jpg");

        News news3 = new News();
        news3.setCaption("Uluslararası Perspektiften Cumhurbaşkanlığı Hükümeti Sistemi");
        news3.setDescription("Süleyman Demirel Üniversitesi İktisadi ve İdari Bilimler Fakültesi" +
                " tarafından “Uluslararası Perspektiften Cumhurbaşkanlığı Hükümeti Sistemi”nin" +
                " konulu bir sempozyum düzenleniyor");
        news3.setImage("http://w3.sdu.edu.tr/SDU_Files/Images/sempozyum(1).jpg");

        News news4 = new News();
        news4.setCaption("Erasmus+ Öğrenci Hareketliliği Yerleştirme Sonuçları");
        news4.setDescription("ÜErasmus Kurum Koordinatörlüğünce 12 Aralık 2016 tarihinde yapılan Yabancı Dil " +
                "Sınav sonucu kapsamında 2017 -2018 Akademik Yılında Erasmus+ Öğrenci Hareketliliği yerleştirme" +
                " sonuçları açıklandı.");
        news4.setImage("http://w3.sdu.edu.tr/SDU_Files/Slider/0cfc1d2f-2971-4215-89e1-1c6f44e9e86a.jpg");

        News news5 = new News();
        news5.setCaption("2017 SDÜ YÖS Başvuru Takvimi");
        news5.setDescription("2017 SDÜ YÖS başvuruları 27 Şubat - 21 Nisan 2017 tarihleri arasında yapılacaktır.");
        news5.setImage("http://w3.sdu.edu.tr/SDU_Files/Slider/sosyal-medya-banner.jpg?v=2");


        List<News>newsList = new LinkedList<>();
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        newsList.add(news5);
        return newsList;
    }
}
