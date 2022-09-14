Для работы нужно запустить локально/удаленно бд postgres,
затем прописать настройки в pom (позже вынесу их оттуда в окружение):
<configuration>
<jdbc>
<driver>org.postgresql.Driver</driver>
<url>jdbc:postgresql://localhost:5432/postgres</url>
<user>postgres</user>
<password>Pass3110</password>
</jdbc>

Поменять настройки подключения к базе в application-local.yml

Собираем mvn clean install:
инициализируется база с помощью flyway
создаются объекты pojo на основе базы в target/classes/com/farzoom/jooq/model/tables/pojos

*пометить папку target "Cancel Exclusion"