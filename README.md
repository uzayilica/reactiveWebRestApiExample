En dikkat edilmesi gerekenler Controller ve Service sınıfında hata yönetiminin genelde diğerinden farklı olarak service sınıfında yapılması şart olmasada genelde böyle olur.
SPRİNG İO'DA OLMAYAN AMA ELLE EKLEMEN GEREKEN MYSQL'İN REACTİVE DEPENENCYSİ
NORMAL MYSQL DE OLMALI YANİ HEM NORMALİ HEMDE REACTİVE OLMALI

Bilgilendirme Notu
Çoğu ayarı geleneksel programlamaya göre farklıdır.
Burada tablolar otomatik oluşmaz sql kodu yazarız bunun için flyfaw migration ekledik
Burada entity anotasyonu olmadığı için sql kodu yazacağız
@Generatedvalue anotasyonuda olmadığı için sql yazarken auto increment ayarıda ekle
Ayrıca burada @ID @Table gibi anotasyonlar mevcuttur ve kullanıcaz.
Yine repository'de jpa ile extends değil reactivecrudile extends edeceğiz

    docker run -p 3306:3306 -d -e MYSQL_USER=uzay -e MYSQL_PASSWORD=12345 -e MYSQL_DATABASE=mydb -e MYSQL_ROOT_PASSWORD=12345 mysql:latest

root password vermeyi unutma !

FLYWAY İÇİN SQL KODLARINI YAZACAĞIN KLASÖRÜN KONUMU
    resources içinde db klasörü içinde migration klasörüne koy 
Burada sql'in adlandırma kurallarına dikkat etmek gerekecektir
Ad sırasına göre alfabetik olabilir böyle çalıştığı için 1 2 3 4 5 gibi yaparız.


    maksimum Bir kullanıcı dönme ihtimali varsa mono 
    çok kullanıcı döndürme ihtimali varsa flux kullandık
Servis Sınıfı Ve Controller Sınıfına Dikkat Bunlara Gelmeden Önce Kendi Hata Sınıfımı Oluşturmam Gerekiyor (Kendi Hata Sınıfımız)
