pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'Gradle', type: 'Gradle')
        sh '  sh \'gradle build --info\''
      }
    }

  }
}