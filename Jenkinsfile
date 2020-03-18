pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool 'Gradle6'
        sh '  sh \'gradle build --info\''
      }
    }

  }
}