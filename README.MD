Запустить в докере кролика и редис ( или удалить пакет с редисом)

* Кролик
  *docker run -d --rm --name rabbit --network=host rabbitmq:latest
  *docker exec -it 9a54 bash
 root@andrey-notebook:/# rabbitmq-plugins enable rabbitmq_management

* Редиска
 docker run -d --rm --name redis --network=host redis:alpine3.13

* заслать в рэббит и получить через Listener
http://localhost:8080/api/rabbit/developers/2/clever
  
либо http://localhost:15672
{
"developer": {
"id": 3,
"firstName": "Maksim",
"lastName": "Maksimov"
},
"process": "PROCESS",
"message": "developer placed into company clever"
}


