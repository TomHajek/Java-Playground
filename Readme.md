Proto module serves as a "microservice" dependency for client and server service.
In this module, we have a protobuf schema of services and objects. By running 
`mvn compile` protoc compiles the protobuf file and creates a target 
folder within the proto module.