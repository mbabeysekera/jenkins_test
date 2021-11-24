def gv
pipeline {
    agent any
    environment {
        APP_VERSION = '1.0.0'
        CREDENTIALS = credentials('jenkins-test')
    }
    parameters {
        string(name: 'version', defaultValue: '1.0.0', description: '')
        choice(name: 'Tool', choices: ['shell', 'mnv', 'gradle'], description: '')
        booleanParam(name: 'Production', defaultValue: false, description: '')
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'functions.groovy'
                }
            }
        }
        stage('test') {
            when {
                expression {
                    BRANCH_NAME == 'dev' && params.Production == false
                }
            }
            steps {
                script {
                    gv.testConfig()
                }
            }
        }
        stage('build') {
            when {
                expression {
                    params.Tool == 'shell'
                }
            }
            steps {
                script {
                    gv.buildConfig()
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deployConfig()
                }
            }
        }
    }
}
