pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Working'
        withGradle() {
          sh './gradlew build'
        }

      }
    }

  }
}