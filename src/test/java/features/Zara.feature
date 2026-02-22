Feature: Testinium Test

  Background: Sayfayı aç
    * Zara uygulamasını aç
    * "Anasayfa" sayfasını gör

  Scenario: Sepet Kontrolü
    * "Menüyü Aç" elementine tıkla
    * "Erkek" elementine tıkla
    * "Tümünü Gör" elementine çift tıkla
    * "Ürün Arama" elementine tıkla
    * "Genel Arama" elementine "Şort" değerini yaz
    * "Genel Arama" elementinin değerini temizle
    * "Genel Arama" elementine "Gömlek" değerini yaz
    * "Enter" a bas
    * "Listedeki İlk Ürün" elementine tıkla
    * "Ürün Fiyatı" elementine ait metni al ve "UrunFiyat" key ile kaydet
    * "Ürün Bilgisi" elementine ait metni al ve "UrunBilgi" key ile kaydet
    * "Sepete Ekle" elementine tıkla
    * "XL ürünü seç" elementine tıkla
    * "Sepet" elementine tıkla
    * "epet Fiyat Bilgisi" elementinin değerinin "UrunFiyat" key değerini içerdiği kontrol edilir
    * "Sepet Ürün Bilgisi" elementinin değerinin "UrunBilgi" key değerini içerdiği kontrol edilir
    * "Sepet Ürün Sil" elementine tıkla
    * "Sepetiniz Boş" elementinin sayfada olduğunu kontrol et