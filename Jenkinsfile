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
      echo "Completed!"
    }
  }
  stage('========== Push image to ec2 ==========') {
    sh 'pwd'
    sh 'ls -al'
  }
}