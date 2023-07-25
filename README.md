# GlobalGroupwareAssignment
# Spring Boot REST API with MongoDB - Readme

This repository contains a Spring Boot REST API project that uses MongoDB as its database. Below are the instructions on how to run the project, set up the database, and access basic API documentation for every route created, including the input JSON structure for each route.

## Prerequisites
Before proceeding, make sure you have the following installed on your system:
1. Java Development Kit (JDK) 8 or higher
2. Apache Maven
3. MongoDB (installed and running)

## Getting Started
1. Clone this repository to your local machine.
2. Navigate to the project directory.

## Set up MongoDB
1. Make sure MongoDB is installed and running on your system.
2. By default, the Spring Boot application uses a local MongoDB instance running on `localhost` and port `27017`. If your MongoDB setup is different, update the `spring.data.mongodb.uri` property in the `application.properties` file located in the `src/main/resources` directory.

## Build and Run the Application
1. Open a terminal or command prompt and navigate to the project directory.
2. Build the project using Maven:

   ```bash
   mvn clean package


