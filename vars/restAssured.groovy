def call(Map config) {
    try {
        sh "./gradlew test ${config?.params ?: ''}"
    } finally {
        def path = config?.artifactsPath?.concat('/') ?: ''
        junit testResults: "${path}build/*.xml", allowEmptyResults: true
        archiveArtifacts "${path}build/**"
    }
}