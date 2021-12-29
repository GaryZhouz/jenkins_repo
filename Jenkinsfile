pipeline {
    agent any

    stages {
        stage('checkout code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'b1b40358-bb2f-4318-8e14-e8eb5e6d1bfb', url: 'git@github.com:wzz1206414629/jenkins_repo.git']]])
                echo "pull code success"
            }
        }
    }

    post {
        always {
            emailext(
                subject: '构建通知：${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}!',
                body: '${FILE,path="email.html"}',
                to: '1206414629@qq.com'
             )
            echo "send success"
        }
    }
}