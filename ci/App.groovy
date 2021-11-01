pipeline {

    agent any

    options {
        disableConcurrentBuilds()
    }
    parameters {
        string(name:'user',defaultValue: 'kamenskyvo', description: 'Docker hub user')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh "cd demo && mvn package"
                }
            }
        }
        stage('Docker build'){
            steps{
                script{
                    sh "cd demo && docker build -t hello-app.jar ."
                }
            }
        }
        stage('Docker publish'){
            steps{
                script{
                    sh "docker tag hello-app.jar kamenskyvo/hello-app && docker push kamenskyvo/hello-app"
                }
            }
        }
    }
}