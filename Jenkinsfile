node {
  stage('========== Clone repository ==========') {
    checkout scm
  }
  stage('========== Build image ==========') {
    app = docker.build("demo2")
  }
  stage('========== Push image ==========') {
    docker.withRegistry('', 'admin') {
      app.push("${env.BUILD_NUMBER}")
      app.push("latest")
      echo "Completed!"
    }
  }
}