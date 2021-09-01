#use the openjdk 8 image as the base image
FROM openjdk:8

#create a new app directory for my application files
RUN mkdir /app

#copy application file from host machine to image file
COPY src/main/java/com/example/vacc_reg/ /app

#set directory for executing future commands
WORKDIR /app

#run the
CMD java Main
