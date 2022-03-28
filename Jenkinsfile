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

        stage('delete container and images') {
            steps {
                script {
                    def containerId = "${BUILD_NUMBER}"
                    echo containerId
//                     def containerIds = sh 'docker ps -a | grep $serviceName | awk \'{print $1}\''
//                     env.containerIds = containerIds
//                     echo containerIds
//                     docker.rm(docker.images)
                }
                echo 'docker will delete run container'
                sh 'docker rm -f ${env.containerIds}'
                echo 'docker will delete images'
                sh 'docker rmi -f $(docker images | grep app | awk \'{print $3}\')'
            }
        }

        stage('build image') {
            steps {
                sh 'printenv'
                echo 'docker build image'
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
