pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh ' ./gradlew tasks'
      }
    }

    stage('Test') {
      steps {
        sh './gradlew test'
      }
    }

  }
}