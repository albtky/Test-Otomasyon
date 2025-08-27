# Hepsiburada E2E Akışları
# tags: e2e, regression

## Senaryo: Smoke - Login Akışı (Pozitif)
# tags: smoke, login
* Giriş ekranına doğru git
* Çerez/izin banner'ını kapat
* Hesap menüsünü aç
* Giriş ekranına geçiş yap
* Kullanıcı "<email>" ve "<şifre>" ile giriş yapar
* Başarılı giriş mesajı "<beklenen_isim>" olarak görünür

| email                        | şifre       | beklenen_isim |
| alperen.tky06@gmail.com     | Tek1getir1  | ALPEREN       |


## Senaryo: Login Akışı (Negatif veri seti)
# tags: negative, login
* Giriş ekranına doğru git
* Çerez/izin banner'ını kapat
* Hesap menüsünü aç
* Giriş ekranına geçiş yap
* Kullanıcı "<email>" ve "<şifre>" ile giriş yapar
* Hata mesajı "<hata_mesajı>" görünür olmalı

| email                    | şifre        | hata_mesajı                                |
| alperen.tky06@gmail.com | yanlışSifre1 | E-posta adresi veya şifre hatalı           |
| bilinmeyen@ornek.com    | Tek1getir1   | E-posta adresi veya şifre hatalı           |


## Senaryo: Sepete Ekle – Tek Ürün (Smoke)
# tags: smoke, cart
* Kullanıcı login durumundadır
* Ürün sayfasına "<ürün_url>" ile gider
* Sepete ekle butonuna tıklar
* Sepette "<beklenen_ad>" ürünü görünür olmalı

| ürün_url                                                                 | beklenen_ad                                  |
| https://www.hepsiburada.com/some-product-url-p-ABC123                    | Apple AirPods 3. Nesil                        |


## Senaryo: Sepete Ekle – Çoklu Ürünler (Data-Driven)
# tags: cart, dd
* Kullanıcı login durumundadır
* Aşağıdaki ürünler sepete eklenir
    | ürün_url                                                              | beklenen_ad                         |
    | https://www.hepsiburada.com/product-1-p-111                          | Philips 27" 144Hz Monitör          |
    | https://www.hepsiburada.com/product-2-p-222                          | Logitech MX Keys Klavye            |
    | https://www.hepsiburada.com/product-3-p-333                          | Sandisk 1TB Taşınabilir SSD        |
* Sepette toplam "<adet>" adet ürün görünmelidir

| adet |
| 3    |


## Senaryo: Sepet - Fiyat ve Kargo Eşik Doğrulaması
# tags: cart, price
* Kullanıcı login durumundadır
* Sepetten tüm ürünler kaldırılır
* Aşağıdaki ürünler sepete eklenir
    | ürün_url                                                              | beklenen_ad                  |
    | https://www.hepsiburada.com/product-4-p-444                          | Xiaomi Mi Smart Band         |
    | https://www.hepsiburada.com/product-5-p-555                          | Anker 30W Şarj Adaptörü      |
* Sepet ara toplamı "<min>" ile "<max>" TL arasında olmalı
* Kargo bedava etiketi durumu "<etiket_beklenir_mi>" olmalıdır

| min | max | etiket_beklenir_mi |
| 900 | 1500| true               |


## Senaryo: Hesap - Kullanıcı Bilgileri Linki
# tags: account
* Kullanıcı login durumundadır
* Hesap menüsünü aç
* "Kullanıcı Bilgilerim" linki görünür ve tıklanabilir olmalı
* "Üyelik Bilgilerim" sayfası başlığı "<başlık>" içermelidir

| başlık              |
| Üyelik Bilgilerim   |


## Senaryo: Oturum Kapatma
# tags: logout
* Hesap menüsünü aç
* Çıkış yap linkine tıkla
* Login butonu tekrar görünür olmalı
