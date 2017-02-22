demo-jpa
====================================================

* modify `/demo-jpa/src/main/resources/config/application.yml` for DB connection

* execute commands below
 * delete data
  * `curl http://10.68.252.138:8080/deleteAll`
  * `curl http://10.68.252.138:8080/count`

 * init data
  * `curl http://10.68.252.138:8080/initParent`
  * `curl http://10.68.252.138:8080/initChild`
  * `curl http://10.68.252.138:8080/count`

 * check data
  * `curl http://10.68.252.138:8080/demo1`
  * `curl http://10.68.252.138:8080/count`

