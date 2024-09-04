function fn() {

    if (!env) {
        env = 'local';
    }

    var config = {
        baseUrls : {
            userSystem : "http://localhost:8080/Product"
        }

    }
    if (env === 'dev') {
        config.baseUrls.userSystem = "http://dev/Product"
    }

    return config
}