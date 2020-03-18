pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool 'Gradle6'
        sh ' ./gradlew wrapper'
        sh './gradlew build'
      }
    }

  }
}