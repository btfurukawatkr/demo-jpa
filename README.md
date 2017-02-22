demo-jpa
====================================================

* modify `/demo-jpa/src/main/resources/config/application.yml` to switch DB connection

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

* [HHH-6776](https://hibernate.atlassian.net/browse/HHH-6776)
  * execute command below
    * `curl http://10.68.252.138:8080/demo2`
