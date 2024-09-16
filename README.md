En dikkat edilmesi gerekenler: Controller ve Service sınıflarında hata yönetimi genelde farklıdır. Service sınıfında hata yönetimi genellikle yapılması gereken bir durumdur, ancak şart değildir.

Spring'de Olmayan Ama Elle Eklenmesi Gereken MySQL'in Reactive Bağımlılığı: Normal MySQL bağımlılığı da olmalıdır; yani hem normal hem de reactive bağımlılıklar bulunmalıdır.

Bilgilendirme Notu: Çoğu ayar geleneksel programlamaya göre farklıdır. Burada tablolar otomatik olarak oluşmaz; SQL kodu yazarız. Bunun için Flyway migration ekledik. Burada entity anotasyonu olmadığı için SQL kodu yazacağız. Ayrıca, @GeneratedValue anotasyonu da olmadığı için SQL yazarken auto increment ayarını da eklemelisiniz. Ayrıca, burada @Id ve @Table gibi anotasyonlar mevcuttur ve kullanacağız. Repository'de JPA ile extends yerine Reactive CRUD ile extends edeceğiz.

Docker komutu:

bash
Kodu kopyala
    docker run -p 3306:3306 -d -e MYSQL_USER=uzay -e MYSQL_PASSWORD=12345 -e MYSQL_DATABASE=mydb -e MYSQL_ROOT_PASSWORD=12345 mysql:latest
Root şifresini vermeyi unutmayın!

Flyway İçin SQL Kodlarını Yazacağınız Klasörün Konumu: resources içinde db klasörü altında migration klasörüne koyun. SQL dosyalarının adlandırma kurallarına dikkat etmek gerekecektir. Dosya adları ad sırasına göre alfabetik olabilir; bu nedenle 1, 2, 3, 4, 5 gibi numaralandırmalar yapabiliriz.

Mono ve Flux Kullanımı:

    Maksimum bir kullanıcı dönme ihtimali varsa Mono kullanılır.
    Çok kullanıcı dönme ihtimali varsa Flux kullanılır.
Servis Sınıfı ve Controller Sınıfı Dikkati: Bu sınıflara gelmeden önce kendi hata sınıfınızı oluşturmanız gerekmektedir.
