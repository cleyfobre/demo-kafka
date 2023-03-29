node {
  stage('========== Clone repository ==========') {
    checkout scm
  }
  stage('========== Build image ==========') {
    app = docker.build("demo2")
  }
  stage('========== Push image ==========') {
    docker.withRegistry('YOUR_REGISTRY', 'YOUR_CREDENTIAL') {
      echo "hello world"
    }
  }
}