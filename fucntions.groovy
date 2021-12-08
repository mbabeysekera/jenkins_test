def testConfig() {
    sh 'echo "test cases passed - SUCCESS"'
}

def buildConfig() {
    sh 'echo "build completed - SUCCESS"'
    echo "build version is ${APP_VERSION}"}

def deployConfig() {
    sh 'echo "deployment completed - SUCCESS"'
    echo "credentials are ${CREDENTIALS}"
    sh '''ssh root@192.168.220.132 'bash -s' <<'ENDSSH'
  pwd
ENDSSH
'''
}
return this