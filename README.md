# Docker Workshop
## Rover-Service bauen
```
mvn clean package
```
## Rover-Service Docker Image bauen
```
docker build -t rover-service .
```

### Rover-Service Docker Container testen
```
docker run --rm --name rover-service -d -p 10100:8080 rover-service
```

### Im Browser
### URL: http://localhost:10100/api/properties/hostname
### URL: http://localhost:10100/q/health/ready