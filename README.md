demo-jpa
====================================================

HOW TO EXECUTE
----------------------------------------------------
* default(mysql)
  * `mvn spring-boot:run`

* postgresql
  * `mvn sqpring-boot:run -Dspring.profiles.active=postgresql -Dspring.datasource.platform=postgresql`

* execute commands below
  * count data
    * `curl http://10.68.252.138:8080/count`
  * delete data
    * `curl http://10.68.252.138:8080/deleteAll`
  * init data
    * `curl http://10.68.252.138:8080/initParent`
    * `curl http://10.68.252.138:8080/initChild`
  * check data
    * `curl http://10.68.252.138:8080/demo1`


* Hibernate issue : [HHH-6776](https://hibernate.atlassian.net/browse/HHH-6776)
  * execute command below
    * `curl http://10.68.252.138:8080/demo2`
  * you can see that 2 child entity entity is printed to the console
  * but if you count the data, you can see that there is only one child entity
