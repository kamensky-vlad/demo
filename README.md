# Sample Spring boot app for docker.

For simple Spring application see https://start.spring.io/
For docker information see https://docs.docker.com/

# Structure

Directory "demo" contain java app, dockerfile and k8s deployment file.

Directory "ci" contain a groovy script for Jenkins, for automate build .jar, dockerfile and push it to docker hub. 

https://hub.docker.com/r/kamenskyvo/hello-app/tags

# Build

`cd /demo && mvn package`

# Build docker

`cd /demo && docker build -t hello-app.jar .`

# Publish docker

`docker tag hello-app.jar ${DockerhubID}/hello-app && docker push ${DockerhubID}/hello-app `

# Need to do
Automatic deployment to k8s and apply it on cluster

Add k8s Service yaml

Add version file

Helm chart

Fix docker build jenkins
