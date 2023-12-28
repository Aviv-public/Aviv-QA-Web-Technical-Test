pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Chrome Test') {
            steps {
                script {
                    withEnv(["browser=chrome"]) {
                        bat 'mvn clean test'
                    }
                }
            }
        }

        stage('Firefox Test') {
            steps {
                script {
                    withEnv(["browser=firefox"]) {
                        bat 'mvn clean test'
                    }
                }
            }
        }
    }
    post {
        success {
            echo 'Tests passed successfully!'
        }

        failure {
            echo 'Tests failed!'
        }
    }
}
