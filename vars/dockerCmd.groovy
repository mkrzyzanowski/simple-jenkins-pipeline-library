def call(args) {
    assert DOCKER != null
    assert args != null
    return sh(script: "sudo ${DOCKER}/docker ${args}", returnStdout: true)
}