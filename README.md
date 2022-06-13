# sices - sistema de controle de equipamentos
-------------------

simple project using adminfaces layout jsf to control medical equipaments in hospital army.


<img src="/img/captura-login.png" alt="My cool logo"/>

<img src="/img/captura-consulta.png" alt="My cool logo1"/>

System requirements
-------------------

All you need to build this project is Java 7.0 (Java SDK 1.7) or better, Maven 3.1 or better, Jboss Wildfly 10.0.0 Final or better.

Build and Running
-------------------------

1. In command line terminal mvn clean install.
2. In command line navigate to directory the installation the Jboss Wildfly Server in standalone/configuration/standalone.xml.
3. Configure parameters in database and credentials security of your choice. 
4. Running server Jboss Wildfly in bin/standalone.sh
5. Open a command line and navigate to the directory target in project Java.
6. In  command terminal java -jar sices-1.jar running application. 
7. Open browser in address http://localhost:8080/sices/login.xhtml.
