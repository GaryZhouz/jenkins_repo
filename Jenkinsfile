pipeline {
        agent any
//     agent {
//         docker {
//             image 'maven:3-alpine'
//             args '-v /root/.m2:/root/.m2'
//         }
//     }
    stages {

//         stage('checkout code') {
//             steps {
//                 checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'e47ec2c9-de46-44fd-9bf0-4fd173bc54cb', url: 'git@github.com:wzz1206414629/jenkins_repo.git']]])
//                 echo 'pull code success'
//             }
//         }

        stage('Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-u root -v /var/jenkins_home:/var/jenkins_home'
                }
            }
            steps {
                echo 'start package'
                sh '''#!/bin/ash
                ls'''
//                 sh 'mvn -B -DskipTests clean package'
//                 echo 'maven package jar success'
            }
        }
    }
}
