pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh ' ./gradlew tasks'
        echo 'Build complete'
      }
    }

    stage('Test') {
      steps {
        sh './gradlew test'
      }
    }

  }
}