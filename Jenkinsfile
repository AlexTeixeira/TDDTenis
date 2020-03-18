pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        withGradle() {
          sh './gradlew build'
        }

      }
    }

  }
}