def call(Map config) {
    withCredentials([usernamePassword(credentialsId: config.credentials, passwordVariable: 'password', usernameVariable: 'username')]) {
        sh "git config user.email ${config?.email ?: 'jenkins@example.com'} && git config user.name ${config?.username ?: 'Jenkins'}"
        sh "mvn release:prepare release:perform -Dusername=${username} -Dpassword=${password}"
    }
}