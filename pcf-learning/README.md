Sample application to leatn Pivotal Cloud Foundry (PCF).

**PCF commands**: <br>
cf login -> If you have logged in before, you will be asked for Email and password. <br>
cf login -a <api> -> You can directly provide the server in which you want to log in to. <br>
cf apps -> How many apps are deployed on the server. <br>
cf target -> To get all the details about target server like Org, space, user etc. <br>
cf push <appName> --random-route -p <JarPath/JarName>-> To push the application on target server with random route. <br>
cf logs <appName> -> See the logs of the application. <br>
cf routes -> get all the routes defined. <br>
cf map-route {route-name} {domain-name} --hostname {new-route-name} <br>

As soon as we push an app, PCF creates an application with routes. So, first time we can
say --random-route but it is not required for the second time. Or we can provide our own route
but that route must be globally unique. 

cf restart -> To restart the apps.

cf start/stop -> To start/stop.

We just need to push an application's JAR, PCf automatically identifies the type of the application.
It downloads all the buildpack and then check which buildpack is necessary for the application to create 
a droplet (combination of code and container information). Finally the Droplet is uploaded to
create container and it is started to server the route.

Everytime downloading buildpack is not very efficient so we can create manifest.yml file to
provide PCF all the instructions in single file with cf create-app-manifest <app-name-in-pcf> -> It reads 
configuration from PCF container and creates the file. We can rename it once it if generated.

cf push -> Running this command looks for manifest.yml in the folder and if found, it will use it.

cf v3-droplets <appName> -> List all the droplets created.

**PCF terminology**

Package: Code + Manifest.yml
First,PCF takes the package in and try to create Droplet (Source code + Buildpack) from it. Droplet creation happes in
Staging part in which build pack is identified and downloaded if required. Then the buildpack is run
to create Droplet. At the end, Droplet is uploaded to cell which is a virtual server and start the
container to serve the route.

Sometime the applications take more than 60 seconds to start and default timeout is defined as 
60 seconds so we can tweak this value by "timeout" property in manifest file.









 


