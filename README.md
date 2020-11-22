# This is my first devops project :
## Author :
##### Nawress Mahmoudi
##### Data Engineer student, DSTI, Spring Cohort 2020
 ##### E-mail adress : nawress.abdelkabir@edu.dsti.institute

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
   
   
   ## 6. Make docker orchestration using Kubernetes :
   
   I successfully installed Kubernetes cluster using Minikube. And it is running.
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/minikube_start_status.JPG)
  
   Then , I created many yaml files :
   
   1-  Deployments file :
     I configured a [a link](/pods/storage/deployment.yaml)
    ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/deployment_kubectl.JPG)
 
   2- Services file : 
    I configured a [service.yaml]
     ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/create_services_get.JPG)
   
   After that , i made an [index.html] :
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/indexXML.JPG) 
     
   3- Persistent volume file : 
   I configured a [pv-volume.yaml ]
   
   And then, I created the Persistent Volume . The "get" shows us information about what we created.
   The output shows the status of the PersistentVolume : available.
  ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/pv_status_available.JPG)
     
   4- Persistent volume claim file :
   I configured a [pv-claim.yaml] . Then a created the persistent volume claim. 
   It shows now that the status of PV is Bound ! 
    ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/PVC_status_bound.JPG)
    
   5- Pod creation :
   The next step is to create a Pod that uses your PersistentVolumeClaim as a volume, configured in [pv-pod.yaml] 
   
   ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/pod_creation.JPG)
   
   When showing the pod information :
     ![alt text](https://github.com/NawressM/1st-DevOps-Project/blob/master/images/errTmagePull_get_pod.JPG)
     There is a error in the status . before that when i first tried it was pending . However, it seems it has an error in the image.
     
 ## 7.Make a service mesh using Istio
   For this long part, i didn't succed to get somthing. I will try again next days.
   
## Tools used :
 - Github
 - MySql
 - Java , JSP
 - maven
 - Tomcat
 - Gitlab-CI
 - Heroku
 - Docker
 - Kubernetes
 
## Usefull Links :
- https://malike.github.io/Gitlab-CI-CD-Pipeline.html
- https://dzone.com/articles/automate-spring-boot-app-deployment-with-gitlab-ci
- https://dashboard.heroku.com/apps/devops-project-s20
- https://linuxize.com/post/how-to-list-docker-containers/
- https://www.oreilly.com/content/how-to-manage-docker-containers-in-kubernetes-with-java/
- https://dev.to/pmgysel/from-a-web-application-to-a-docker-image-to-a-deployment-with-kubernetes-171b
- https://kubernetes.io/docs/tasks/configure-pod-container/configure-persistent-volume-storage/
## Thanks for your help during the DevOps course ! :)
