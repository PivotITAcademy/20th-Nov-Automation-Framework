pipeline {
    agent {
    label 'master'}

    stages {
        stage('Clean') {
            steps {
            echo "BUILD_NUMBER=${env.BUILD_NUMBER}"
            echo "BRANCH_NAME=${env.BRANCH_NAME}"
                echo 'Cleaning Workspace...'
                echo "Branch Name: ${params.branch}"
                bat "mvn help:effective-settings help:effective-pom -U clean -X"
            }
        }   
         stage('Verify'){
        steps{
        
        echo 'Verify Work Space'
        bat "mvn verify -X"
        
            }
        }          
        stage('Compile') {
            steps {
                echo 'Compile.....'
                bat "mvn compile -U -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Test....'
                bat "mvn help:effective-settings help:effective-pom test -X"
            }
        }
        stage('Install'){
        
        steps{
            
            echo 'install'
            bat "mvn install -Dmaven.test.failure.ignore=true -X"
        }

            }   
       
    }
    post{
        always{
            echo "Build Completed. Current Build Result=${currentBuild.currentResult}"
                                          }
                                          
                                          changed {
                                              sendNotification(buildChanged: true)
                                          }
                              
                              failure{
                                  sendNotification(buildChanged: true)
                              }


        }}
        
        def sendNotification(buildChanged){
            if (currentBuild.currentResult== 'SUCCESS') {       
            script {
            emailext(to: 'manvir.singh.parmar88@gmail.com',subject: "$JOB_NAME - Build # ${currentBuild.currentResult}!",body:"The build is back to normal. Check console output at ${BUILD_URL} to view the results", mimetype:'text/html',)                                                                                 
                }
				}
                
                else  if (currentBuild.currentResult== 'FAILURE' && buildChanged) {       
            script {
            emailext(to: 'manvir.singh.parmar88@gmail.com',subject: "$JOB_NAME - Build # ${currentBuild.currentResult}!",body:"Something went wrong.Check console output at ${BUILD_URL} to view the results", mimetype:'text/html',)
 
                                                                                               
                }

                }
                
                 else  if (currentBuild.currentResult== 'FAILURE') {       
            script {
            emailext(to: 'manvir.singh.parmar@gmail.com',subject: "$JOB_NAME - Build # ${currentBuild.currentResult}!",body:"Something went wrong.Check console output at ${BUILD_URL} to view the results", mimetype:'text/html',)
 
                                                                                               
                }

                }
            }

        


    


