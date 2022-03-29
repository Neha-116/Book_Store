pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {

        stage('Build Maven') {
            steps{
                 git branch: 'ashwin', credentialsId: 'AshwinThonoor', url: 'https://github.com/AshwinThonoor/BookApp.git
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
                
            }
        }   
    }
}
