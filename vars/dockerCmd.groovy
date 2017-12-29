def call(args) {
    assert DOCKER != null
    assert args != null
    sh "sudo ${DOCKER}/docker ${args}"
}