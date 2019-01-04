# Alten Resources Application
This application using spring web, swagger, spring cloud, liquibase and eureka client

## Using Docker to simplify development

You can use Docker to deploy the application.
To start a mysql database in a docker container, run:

    docker-compose -f src/main/docker/mysql.yml up -d

To stop it and remove the container, run:

    docker-compose -f src/main/docker/mysql.yml down

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:
    
    mvn package docker:build -X

Then run:

    docker-compose -f src/main/docker/app.yml up -d
    
## What is this application Do

This Application performing CRUD operations on customers and their vehicles.