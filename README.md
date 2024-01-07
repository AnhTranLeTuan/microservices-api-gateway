# API Gateway for Cloud-Based Microservices with DevOps and Automation

## Description
A part of the cloud-based microservices with DevOps and automation project that include:
* Set up this server for port 8765
* Implement the global filter which is the logger in this case for all URL requests to monitor requests’ paths
* Configure the API Gateway to detect other microservices and servers and use their functions through the Eureka service registry, as well as allow using lowercase to access them instead of the default uppercase
* Implement routes that can map URLs to other URLs, as well as add customizable filters and rewrite path feature
* Register this server for the Eureka service registry at port 8761
* Set up Micrometer and OpenTelemetry to allow the Zipkin server to monitor and manage this server's metrics, logs, and traces
