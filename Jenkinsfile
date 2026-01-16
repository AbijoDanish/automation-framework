pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK ver'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AbijoDanish/automation-framework.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
        }

        success {
            echo 'BUILD SUCCESSFUL'
        }

        failure {
            echo 'BUILD FAILED'
        }
    }
}
