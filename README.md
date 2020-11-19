# Nawress devops project :
This is my first challenge using DevOps tools.
it includes different tasks.

## 1. Create a web application : 
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

## 2. Apply CI/CD pipeline with GitLab

   ### CI PART : here i used gitlab-ci 
   I imported my github repository into a new project in GitLAB CI.
   
   Then, i created .gitlab-ci.yml file which includes different instructions.
   3 Stages has been defined for this pipeline :
   - Build
   - Test
   - Deploy
    
   
   To setup the host server, I installed gitlab runner on my local machine then I registred the CI/CD pipeline to be able to run it.
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/Pipline_running.JPG) 
   
   
   
   
   
   
   
# Used Usefull Links :
https://malike.github.io/Gitlab-CI-CD-Pipeline.html
https://dzone.com/articles/automate-spring-boot-app-deployment-with-gitlab-ci
https://dashboard.heroku.com/apps/devops-project-s20
https://linuxize.com/post/how-to-list-docker-containers/
https://www.oreilly.com/content/how-to-manage-docker-containers-in-kubernetes-with-java/
https://dev.to/pmgysel/from-a-web-application-to-a-docker-image-to-a-deployment-with-kubernetes-171b
