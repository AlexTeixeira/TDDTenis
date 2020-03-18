pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool 'Gradle6'
        sh ' gradle wrapper'
        sh './gradlew build'
      }
    }

  }
}