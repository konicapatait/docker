# Docker

## What is Docker?
- Open source project to automate the deployment of software applications inside container
- It allows the users to package the application with all it's dependencies into a standardized unit.
- Unlike VMs, containers do not have high overheads and hence, use the underlying system and resources efficiently.

## Work with Docker

 ### Setting up the machine
 - Install the docker using https://docs.docker.com/docker-for-mac/install/
 - Use homebrew to install docker. Reference: https://pilsniak.com/how-to-install-docker-on-mac-os-using-brew/
    -   brew install docker docker-compose docker-machine xhyve docker-machine-driver-xhyve
 - To test the docker installation, run
    - docker run hello-world

### Basic Docker commands

-   docker info

    This command will provide the imformation about the docker like no. of container running, stopped etc.

-   docker pull `<image-name>`

    This command fetches the image from docker registry and save it on your system.

-   docker images

    This will list all the images on your system

-   docker run `<image-name>`

    This command will run a docker container based on this image

-   docker ps

    This command will list all the containers that are currently running

-   docker ps -a

    This command will list all the containers that we ran. `STATUS` column shows the current status of the container.

-   docker run -it `<image-name>` sh

    This command allow to run multiple commands on the container.

-   docker rm `<container-id>`

    This command will delete the container and frees the disk space. To delete the all the exited containers, use `docker rm $(docker ps -a -q -f status=exited)`.

    `-a`  returns all the containers. `-q` returns numeric container ids and `-f` filters the output based upon the condition provided.

    `docker container prune` can be used to get the same result.

-   docker start `<container-name>`

    This command will start the existing (prevoiusly stopped) container.

-   docker search `<filter-keyword>`

    This command will search the registry to provide all the available images related to the filter keyword. e.g. 
    -   docker search tomcat
    -   docker search nginx

### Docker Jargons

-  `Dockerfile` : It is a source code
-  `Image` : Binary resulting from compiling and builing the `Dockerfile `
-  `Container` : Running instance of image, a process by all means.
-  `Registry` : Images are stored in registry. Think of apt, yum, pip or npm. Docker has two types of registries 
    -   public  
    -   private  

    Docker offers public registry that anyone can use to store images.

![alt text](https://github.com/konicapatait/docker/blob/master/images/docker-arch.png "Docker Jargons")


### Work with Dockerfile 

-   Docker file is basically a text file named as `Dockerfile` with no extension. It contain all the commands used to assemple the docker image. Every line of command in dockerfile creates a layer that make up a docker image.

-  It is basically a blueprint of docker image.  Just like the compiler or interpreter does to programming languages, Docker reads the Dockerfile from top to bottom.

-   The commands in the Dockerfile are not case sensitive.

-   Comments in Dockerfiles are denoted by using the hash or pound symbol # at the beginning of the line.

-   Docker is Linux based, so it uses the backslash `\` as an escape character due to Linux conventions.T o change this behaviour, you’ll use the escape parser directive as: `# escape=`

-   Identify the base image to use. To search for existing public image run ` docker search <keyword>` . This will search the existing images in docker registry having keyword.
- <b>Dockerfile instructions: </b>

    -   FROM <base-image>

        Pull the dependencies from the other images

    -   MAINTAINER <Owner>

        Sets the maintainer of the image for reference and documentation.

    -   LABEL <META-DATA>

        It needs metadata. After building an image and running a container off it, you can use the docker inspect command to find information on the container.

        `LABEL "maintainer"="Konica Patait" "appname"="Hello World" `

    -   RUN <commands>

        These are the sets of the commands that runs from the container when it is first created. These can be any command line instruction if you have dependency to support it.

    -   ENV <environment-variables>

        This sets the environment variable in container.

        `ENV applocation /usr/src`

    -   COPY
    
        COPY instruction copies files or directories, from the Docker host to the Docker image. You'll copy the source code to the Docker image. The command below uses the set environment variable.
        
        `COPY helloworld $applocation/helloworld`

    -   VOLUME 
        
        This defines a path in the container that Docker exposes to the host system and mapped using the `-v` argument when running a container.

    -   WORKDIR 
    
        This changes the active directory of the container to a specified location, in case you need to run commands from or in a particular location.

    -   CMD

        This runs the software that container is desfigned to run. Docker can run only one CMD command. Therefore, if you insert two or more CMD instructions, Docker would only run the last one i.e. the most recent one. Format used is `CMD [executable] [parameter1] [parameter2]`.

    -   ENTRYPOINT

        Entrypoint sets the main command for the image.

        -   It can be used in conjunction with `CMD` as `dockerfile ENTRYPOINT ["/swarm"] CMD ["--help"]`
        -   ENTRYPOINT command is to run a bash script in the image, allowing for more complex operations.
    
    -   EXPOSE 
    
        It exposes the ports that the software uses, ready for you to map to the host when running a container with the `-p` argument.

        `EXPOSE 5000`


### Build the Image

One can build a docker image using below command:

`docker build -t <image-name> .`

where dot(.) indicates that the file you are working with are in current directory.

### Run the Container 

Using `docker run -ip <DOCKER-HOST>:<DOCKER-CONTAINER> <IMAGE-NAME>:<TAG-NAME>`

where -i indicates it run in interactive mode and -p binds the docker host port to the docker container's port
e.g.

`docker run -ip 80:8080 sample_image:latest`

`-p` is used to map the container port `8080` for the mywebapp image to port `80` on the host machine. Web application will run at `http://localhost:80`

### Push Image to Dockerhub

-   docker login
-   docker tag  `<IMAGE-ID> <USER-NAME>/<PROJ-NAME>:<TAG-NAME> `
-   docker push `<USER-NAME>/<PROJ-NAME>`

### Pull the Image

-   docker pull `<USER-NAME>/<PROJ-NAME>`




    