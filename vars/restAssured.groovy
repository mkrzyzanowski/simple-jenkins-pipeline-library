def call(Map config) {
    try {
        sh "./gradlew test ${config?.params ?: ''}"
    } finally {
        junit testResults: "${config?.artifactsPath ?: ''}/build/*.xml", allowEmptyResults: true
        archiveArtifacts "${config?.artifactsPath ?: ''}/build/**"
    }
}