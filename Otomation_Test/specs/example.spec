# Getting Started with Gauge

This is an example markdown specification file.
Every heading in this file is a scenario.
Every bulleted point is a step.

To execute this specification, use
	npm test

This is a context step that runs before every scenario
 # Login İşlemleri
 * Doğru kullanıcı adı ve şifre ile giriş yapılır
* Yanlış kullanıcı adı/şifre girildiğinde hata mesajı gösterilir

# Menü ve Navigasyon Testleri
* Sol üstteki menüye tıklanır ve kullanıcı iç menü içeriğine ulaşır
* Sağ üstteki sepet butonuna tıklanır ve doğru sayfaya yönlendirilir
* En üstteki Swag Labs logosuna tıklanır ve Products sayfasına yönlendirilir

# Filtreleme Özellikleri
* Filtre "Name (A to Z)" seçildiğinde ürünler doğru şekilde sıralanır
* Filtre "Name (Z to A)" seçildiğinde ürünler doğru şekilde sıralanır
* Filtre "Price (low to high)" seçildiğinde ürünler doğru şekilde sıralanır
* Filtre "Price (high to low)" seçildiğinde ürünler doğru şekilde sıralanır

# Sepet ve Ürün Ekleme / Çıkarma İşlemleri
* Tüm ürünlerde "Add to Cart" butonlarının çalıştığı kontrol edilir
* Ürün eklendikten sonra butonun "Remove" olarak değiştiği kontrol edilir
* "Remove" butonlarının çalıştığı kontrol edilir
* Sepete eklenen ürünler eksiksiz olarak listelenir
* Ürün resmine tıklanınca ürün detay sayfasına gidildiği kontrol edilir
* Ürün ismine tıklanınca ürün detay sayfasına gidildiği kontrol edilir

# Sosyal Medya Linkleri
* Twitter butonu doğru URL’ye yönlendirir
* Facebook butonu doğru URL’ye yönlendirir
* Linkedin butonu doğru URL’ye yönlendirir

# Checkout Süreci
* Checkout butonu "Checkout: Your Information" sayfasına yönlendirir
* Continue Shopping butonu çalışır
* Sepet içerisindeki ürünün satın alım sayısı değiştirilebilir
* First name kutusuna metin girişi yapılabilir
* Last name kutusuna metin girişi yapılabilir
* Zip/Postal Code kutusuna veri girişi yapılabilir
* First name kutusuna sayı girilememelidir
* Last name kutusuna sayı girilememelidir
* Zip/Postal Code kutusuna harf girilememelidir
* Tüm kutular boş bırakıldığında uyarı gösterilir
* Cancel butonu doğru sayfaya yönlendirir
* Finish butonu doğru sayfaya yönlendirir
* Back Home butonu doğru çalışır
