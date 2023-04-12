# Enoca Backend Challange
### Projede kullandığım araç ve teknolojiler aşağıdadır.
* Java Spring Boot
*	Exceptions
*	Response-Request Pattern
*	Ioc
*	Model Mapper
*	Patter Design
*	PostgreSQL
*	Domain Driver Design
*	Maven Repository(io.github.bernaozgen:common)

> Projeyi oluştururken çalışma bakanlığında eğitim aldığım dönemde microservice projesi için oluşturduğum, içinde exception , result , model mapperında bulunduğu maven repositorye attığım common projemi kullandım. 
 Aşagıdaki adreslerden commona ulaşıp inceleyebilirsiniz.
 
> https://github.com/bernaozgen/common

> https://mvnrepository.com/search?q=io.github.bernaozgen

> https://s01.oss.sonatype.org/#view-repositories;releases~browsestorage~io/github/bernaozgen 

Bunun dışında pom da kullandığım diğer dependencyler şöyledir;
*	Spring Boot Data JPA
*	Validation
*	Spring Boot Web
*	Spring Boot Devtools
*	PostgreSQL
*	Lombok

### Entities Katmanı
 iki class oluşturdum bunlardan birisi company diğeri employeedir. Aralarındaki ilişki şöyledir;
* @OneToMany -> Bir çalışan sadece bir şirkette çalışabilir.
* @ManyToOne -> Bir şirketin birden fazla çalışanı olabilir.  
### Data Access katmanı
veritabanı bağlantısını kurdum. Burada JPARepository kullandım.
### Business Katmanı
Request-Response pattern kullanıldı. Business rules , clean code, Domain Driver Design yaklaşımına uygun geliştirdim. Ayrıca company ve employee için id kontrolü yapan, aynı isimli şirket oluşturulmasını engelleyen iş kodlarını da projeye dahil ettim. 
>> Not: Delete işlemi için iki farklı yol kullandım. Bunlardan birisi http uzantısına id ekleyerek diğeri ise Response-Request paterna uygun delete metodunu yazdım.
### Wep Api Katmanı
projeyi istemci tarafına aktarmak için Restful altyapısını kullandım.





