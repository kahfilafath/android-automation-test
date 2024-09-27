//Jenkinsfile (Declarative Pipeline)
/* Requires the Docker Pipeline plugin */
pipeline {
    agent  any
    //{ docker { image 'gradle:8.2.0-jdk17-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --version'
            }
        }
        stage('test'){
          steps {
            sh './gradlew clean cucumber --tags "@TC001"'
          }
        }
        stage('Generate Report'){
            steps{
                cucumber buildStatus: 'UNSTABLE',
                      reportTitle: 'cucumber-report',
                      fileIncludePattern: '**/cucumber.json',
                      jsonReportDirectory: 'target',
                      trendsLimit: 10,
                      classifications: [
                          [
                             'key': 'Browser',
                             'value': 'Chrome'
                          ]
                      ]
            }
        }

    }
}
