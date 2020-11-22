# Nawress devops project :
This is my first challenge using DevOps tools.
it includes different tasks.

## 1. Create a web application (Java, JSP, maven, MySql, Tomcat): 
I created a web application based on java/jsp and maven .

The database used is : MySql.

I wrote unit tests for this CRUD app in Test.java .

This application is a sort of online car store to manage cars.

Each car is decribed by its :
- matriculation
- brand
- model
- price

we can list, update, add, delete cars.
For test and validation purpose, the application has been deployed locally on Tomcat server.
![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/WEB_APP_Interface.JPG)


## 2. Apply CI/CD pipeline with GitLab

   ### CI Part : (gitlab-ci)
   I imported my github repository into a new project in GitLAB CI.
   
   Then, I created .gitlab-ci.yml file which includes different instructions.
   3 Stages has been defined for this pipeline :
   - Build
   - Test
   - Deploy
    
   
   To setup the host server, I installed gitlab runner on my local machine then I registred the CI/CD pipeline to be able to run it.
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/Pipline_running.JPG) 
   
   ### CD Part : (Heroku)
   To be able to do the CD part, I used Heroku where I created my project target.
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/app_built_in_Heroku.JPG)
   
   Successufuls deployement are automatically detected by Heroku at each pull request on master branch:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/Heroku_deploys.JPG)

   To verify this pipeline, we went back to gitlab-ci where we could check the status of the different stages :
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/Pipline_passed.JPG)
   
## 3. Configure and provision a virtual environment and run your application using IaC approach :
    -- Sorry, I had a health problem so I didn't have a enough time to finish this part. 
    
## 4. Build Docker image of your application :
   ### 1- Create Docker image of your application :
   After creating the Dockerfile and .dockerignore files, I executed this comand to generate the image:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_build.JPG)
   
   Then I got a message confirming that the build was successfull
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_image_built.JPG)

   ### 2- Push the image to Docker Hub :
   To run the docker image I executed this command:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_run.JPG)
   
   Then to check active docker container I executed this command:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_ps.JPG)
   
   Finally, to push image into my ptivate repository of docker hub I executed these commands:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_push.JPG)
   
   Then I went to my docker hub repository to check the image:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_hub_repository.JPG)
   
   
   
 ## 5. Make container orchestration using Docker Compose :  
    First I created the docker-compose.yml file then I executed command:
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_compose.JPG)
   
   Then build has been processed and I got this message:   
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/docker_compose_success.JPG)
    
    
   
   
   
# Used Usefull Links :
https://malike.github.io/Gitlab-CI-CD-Pipeline.html
https://dzone.com/articles/automate-spring-boot-app-deployment-with-gitlab-ci
https://dashboard.heroku.com/apps/devops-project-s20
https://linuxize.com/post/how-to-list-docker-containers/
https://www.oreilly.com/content/how-to-manage-docker-containers-in-kubernetes-with-java/
https://dev.to/pmgysel/from-a-web-application-to-a-docker-image-to-a-deployment-with-kubernetes-171b
