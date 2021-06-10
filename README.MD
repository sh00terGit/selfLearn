Запустить в докере кролика и редис ( или удалить пакет с редисом)

* Кролик
  *docker run -d --rm --name rabbit --network=host rabbitmq:latest
  *docker exec -it 9a54 bash
 root@andrey-notebook:/# rabbitmq-plugins enable rabbitmq_management

* Редиска
 docker run -d --rm --name redis --network=host redis:alpine3.13



