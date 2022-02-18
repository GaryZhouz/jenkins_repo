pipeline {
    agent {
        docker {
            image 'maven:3-jdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {

        stage('checkout code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'e47ec2c9-de46-44fd-9bf0-4fd173bc54cb', url: 'git@github.com:wzz1206414629/jenkins_repo.git']]])
                echo 'pull code success'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
                echo 'package code success'
            }
        }
    }
}
