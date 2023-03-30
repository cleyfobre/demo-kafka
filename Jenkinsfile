node {
    stage('========== Clone repository ==========') {
        checkout scm
    }
    stage('========== Build image ==========') {
        app = docker.build("cleyfobre/demo2")
    }
    stage('========== Push image to docker hub ==========') {
        docker.withRegistry('', 'cleyfobre') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
            sh 'docker rmi cleyfobre/demo2:0.0.1'
            sh 'docker rmi cleyfobre/demo2:latest'
        }
    }
    stage('========== Push image to ec2 ==========') {
        sh 'pwd'
        sh 'scp -o StrictHostKeyChecking=no -i /var/jenkins_home/plkdev.pem ./src/deploy/build.sh ubuntu@172.31.5.156:/home/ubuntu'
        steps {
            sshagent (credentials: ['jenkins-ssh']) {
                sh """
                   ssh -o StrictHostKeyChecking=no ubuntu@172.31.5.156 "pwd"
                """
            }
        }
    }
}