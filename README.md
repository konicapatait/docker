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

    `docker container prune` can be used to get the same result

### Docker Jargons

-  `Dockerfile` : It is a source code
-  `Image` : Binary resulting from compiling and builing the `Dockerfile `
-  `Container` : Running instance of image, a process by all means.
-  `Registry` : Images are stored in registry. Think of apt, yum, pip or npm. Docker offers public registry that anyone can use to store images.

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Docker Jargons")



    