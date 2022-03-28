pipeline {
    agent any

    environment {
        serviceName = 'app'
    }

    tools {
        maven 'my_mvn'
    }

    stages {

        stage('package') {
            steps {
                sh 'ls'
                echo 'delete target'
                sh 'rm -rf target'
                sh 'ls'

                echo 'start package'
                sh 'mvn -B -DskipTests clean package'
                echo 'maven package jar success'
            }
        }

        stage('build image') {
            steps {
                imageId = sh 'docker images | grep $serviceName | awk \'{print $3}\''
                echo 'docker remove old image -> ${imageId}'
                sh 'docker rmi -f $serviceName:${BUILD_NUMBER}'

                echo 'docker build image'
                sh 'ls'
                sh 'docker build --no-cache -t app:${BUILD_NUMBER} .'
            }
        }

        stage('Run app') {
            steps {
                sh 'docker run -d -p 8090:8090 app:${BUILD_NUMBER}'
            }
        }
    }
}
