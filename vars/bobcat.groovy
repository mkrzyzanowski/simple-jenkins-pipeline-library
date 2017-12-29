try {
    sh "mvn clean test -Dmaven.test.failure.ignore=true ${config?.params ?: ''}"
} finally {
    junit testResults: "${config?.artifactsPath ?: ''}/target/*.xml", allowEmptyResults: true
    archiveArtifacts "${config?.artifactsPath ?: ''}/target/**"
}