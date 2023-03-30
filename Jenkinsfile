pipeline {
    agent any
    stages {
        stage('========== Clone repository ==========') {
            steps {
                checkout scm
            }
        }
        stage('========== Push image to docker hub ==========') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'cleyfobre', passwordVariable: 'password', usernameVariable: 'username')]){
                        sh '''
                            echo "${password} | docker login -u ${username} --password-stdin"
                        '''
                        def app = docker.build("cleyfobre/demo2")
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                        sh 'docker rmi cleyfobre/demo2:0.0.1'
                        sh 'docker rmi cleyfobre/demo2:latest'
                    }
                }
            }
        }
        stage('========== Test ==========') {
            steps {
                echo "testing..."
            }
        }
        stage('========== Work for test-web instance ==========') {
            steps {
                sh 'ls'
                sshagent (credentials: ['test-web-ssh']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no ${TARGET_HOST} '
                        pwd
                        '
                    """
                }
                sh 'whoami'
            }

        }
    }
    environment {
        TARGET_HOST = "ubuntu@172.31.5.156"
    }
}
