# Docker/K8s Workshop
## Lokale Docker Registry auf Minikube Registr setzen
eval $(minikube docker-env)
## Rover-Service bauen
mvn clean package
## Rover-Service Docker Image bauen
docker build -t rover-service .

### Rover-Service Docker Container testen

### Im Browser
### URL: http://localhost:10100/api/properties/hostname
### URL: http://localhost:10100/q/health/ready