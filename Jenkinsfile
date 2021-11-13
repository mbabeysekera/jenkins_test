pipeline {
    agent any
    environment {
        APP_VERSION = '1.0.0'
    }
    stages {
        stage('test') {
            when {
                expression {
                    BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                }
            }
            steps {
                sh 'echo "test cases passed - SUCCESS"'
            }
        }
        stage('build') {
            steps {
                sh 'echo "build completed - SUCCESS"'
                echo "build version is ${APP_VERSION}"
            }
        }
        stage('deploy') {
            steps {
                sh 'echo "deployment completed - SUCCESS"'
            }
        }
    }
    post {
         
    }
}