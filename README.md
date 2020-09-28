# spring-cloud-config-client

The client applications (Config Clients) will retrieve the configurations from the Config Server when they start up. Here the spring-cloud-config-client will retrieve the related configurations from the spring-cloud-config-server.

Config Clients are connected to each other through a Spring Cloud Bus. Here I have used RabbitMQ as Spring Cloud message broker to broadcast events across all connected clients.

Actuator refresh endpoint for individual service refresh:
  POST localhost:8080/actuator/refresh

Refresh endpoint for all service refresh using cloud bus: 
  POST localhost:8080/actuator/bus-refresh
