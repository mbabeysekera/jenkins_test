pipeline {
    agent any
    environment {
        APP_VERSION = '1.0.0'
        CREDENTIALS = credentials('jenkins-test')
    }
    parameters {
        string(name: 'version', defaultValue: "1.0.0", description: '')
        choice(name: 'Tool', choices: ["shell", "mnv", "gradle"], description: '')
        booleanParam(name: "Production", defaultValue: false, description: '')
    }
    stages {
        stage('test') {
            when {
                expression {
                    BRANCH_NAME == 'dev' && params.Production == false
                }
            }
            steps {
                sh 'echo "test cases passed - SUCCESS"'
            }
        }
        stage('build') {
            when {
                expression {
                    params.Tool == "shell"
                }
            }
            steps {
                sh 'echo "build completed - SUCCESS"'
                echo "build version is ${APP_VERSION}"
            }
        }
        stage('deploy') {
            steps {
                sh 'echo "deployment completed - SUCCESS"'
                echo "credentials are ${CREDENTIALS}"
            }
        }
    }
}