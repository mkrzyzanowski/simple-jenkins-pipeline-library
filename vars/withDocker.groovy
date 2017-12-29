def call(Closure body) {
    def dockerTool = tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
    withEnv(["DOCKER=${dockerTool}/bin"]) {
        body()
    }
}