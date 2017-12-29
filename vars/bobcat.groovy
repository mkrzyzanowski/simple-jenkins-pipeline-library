def call(Map config) {
    try {
        sh "mvn clean test -Dmaven.test.failure.ignore=true ${config?.params ?: ''}"
    } finally {
        def path = config?.artifactsPath?.concat('/')
        junit testResults: "${path}target/*.xml", allowEmptyResults: true
        archiveArtifacts "${path}target/**"
    }
}